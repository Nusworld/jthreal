package cn.edu.ncu.erlys.liu.stopthread.volatiledemo;

public class WrongWayVolatile implements Runnable {
    private volatile boolean canceled = false;

    @Override
    public void run() {
        try {
            int num = 0;
            while (num <= 100000 && !canceled) {
                if (num % 100 == 0) {
                    System.out.println(num + "是100的倍数");
                    Thread.sleep(1);
                }
                num++;
            }
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        WrongWayVolatile r = new WrongWayVolatile();
        Thread thread = new Thread(r);
        thread.start();
        Thread.sleep(5000);
        r.canceled = true;
    }
}
