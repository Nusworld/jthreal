package cn.edu.ncu.erlys.liu.stopthread;

public class RightWayStopThreadWithSleepEveryLoop {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            try {
                int num = 0;
                while(num <= 10000) {
                    if (num % 100 == 0) {
                        System.out.printf("%d 是100的倍数\n", num);
                    }
                    num++;
                    Thread.sleep(10);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            System.out.println("任务运行结束了");
        };

        Thread thread = new Thread(runnable);
        thread.start();
        Thread.sleep(5000);
        thread.interrupt();
    }
}
