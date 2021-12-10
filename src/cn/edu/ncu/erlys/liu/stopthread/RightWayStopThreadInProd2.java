package cn.edu.ncu.erlys.liu.stopthread;

// 在方法签名中抛出异常
// 在catch中使用interrupt类设置中断状态
// 以便于在后续的执行中依然能够检测到刚刚发生了中断
public class RightWayStopThreadInProd2 implements Runnable {
    @Override
    public void run() {
        while (true) {
            System.out.println("Go");
            try {
                throwInMethod();
            } catch (InterruptedException e) {
                System.out.print("保存日志 ");
                System.out.println("或者停止程序");
                e.printStackTrace();
            }
        }
    }

    private void throwInMethod() throws InterruptedException {
        Thread.sleep(2000);
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new RightWayStopThreadInProd2());
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
    }
}
