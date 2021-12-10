package cn.edu.ncu.erlys.liu.threadsafe;

public class MultiThreadErrorObserver {

    int count;

    public static void main(String[] args) {
        MySource mySource = new MySource();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                mySource.eventCome(new MySource.Event() {
                });
            }
        }).start();
        MultiThreadErrorObserver multiThreadErrorObserver = new MultiThreadErrorObserver(mySource);
    }

    public MultiThreadErrorObserver(MySource source) {
        source.registerListener(new MySource.EventListener(){
            @Override
            public void onEvent(MySource.Event e) {
                System.out.println("\n我的到的数字是 " + count);
            }
        });
        for (int i = 0; i < 10000; i++) {
            System.out.print(i);
        }
        count = 100;
    }

    static class MySource {
        private EventListener listener;
        void registerListener(EventListener listener) {
            this.listener = listener;
        }

        void eventCome(Event e) {
            if (listener != null) {
                listener.onEvent(e);
            }else {
                System.out.println("还未初始化完毕");
            }
        }

        interface EventListener {
            void onEvent(Event e);
        }

        interface Event {

        }
    }
}
