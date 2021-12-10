package cn.edu.ncu.erlys.liu.stopthread;

// 在方法签名中抛出异常
// 即传递异常, 在顶层调用方法中处理异常
public class RightWayStopThreadInProd implements Runnable {
    @Override
    public void run() {
        while (true) {
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("程序运行结束");
                break;
            }
        }
        reInterrupt();
    }

    private void reInterrupt() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new RightWayStopThreadInProd());
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
    }
}
