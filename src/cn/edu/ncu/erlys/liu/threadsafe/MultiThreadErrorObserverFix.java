package cn.edu.ncu.erlys.liu.threadsafe;

/**
 * 工厂模式修复初始化问题
 */
public class MultiThreadErrorObserverFix {

    int count;
    private MultiThreadErrorObserverFix.MySource.EventListener listener;

    private MultiThreadErrorObserverFix(MultiThreadErrorObserverFix.MySource source) {
        listener = new MultiThreadErrorObserverFix.MySource.EventListener(){
            @Override
            public void onEvent(MultiThreadErrorObserver.MySource.Event e) {
                System.out.println("\n我的到的数字是 " + count);
            }
        };
        for (int i = 0; i < 10000; i++) {
            System.out.print(i);
        }
        count = 100;
    }

    public static MultiThreadErrorObserverFix getInstance(MultiThreadErrorObserverFix.MySource source) {
        MultiThreadErrorObserverFix safe = new MultiThreadErrorObserverFix(source);
        source.registerListener(safe.listener);
        return safe;
    }

    static class MySource {
        private MultiThreadErrorObserverFix.MySource.EventListener listener;
        void registerListener(MultiThreadErrorObserverFix.MySource.EventListener listener) {
            this.listener = listener;
        }

        void eventCome(MultiThreadErrorObserver.MySource.Event e) {
            if (listener != null) {
                listener.onEvent(e);
            }else {
                System.out.println("还未初始化完毕");
            }
        }

        interface EventListener {
            void onEvent(MultiThreadErrorObserver.MySource.Event e);
        }

        interface Event {

        }
    }
}
