package cn.edu.ncu.erlys.liu.stopthread;

public class RightWayStopThreadWithoutSleep implements Runnable{

    @Override
    public void run() {
       int num = 0;
       while(!Thread.currentThread().isInterrupted() && num <= Integer.MAX_VALUE / 2) {
           if (num % 10000 == 0) {
               System.out.printf("%d 是10000的倍数\n", num);
           }
           num++;
       }
        System.out.println("任务运行结束了");
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new RightWayStopThreadWithoutSleep());
        thread.start();
        Thread.sleep(2000);
        thread.interrupt();
    }
}
