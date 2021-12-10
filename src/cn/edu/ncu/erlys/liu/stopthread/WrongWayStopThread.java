package cn.edu.ncu.erlys.liu.stopthread;

// stop导致线程突然停止，造成脏数据
public class WrongWayStopThread implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("连队" + i + "开始领取武器");
            for (int j = 0; j < 10; j++) {
                System.out.print(j + " ");
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("\n连队" + i + "已经领取完毕\n");
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new WrongWayStopThread());
        thread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.stop();
    }
}
