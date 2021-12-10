package cn.edu.ncu.erlys.liu.threadobjectclasscommonmethods;

// 使用notify和wait
public class WaitNotifyPrintOddEveWait {
    private static int count;
    private static final Object lock = new Object();


    public static void main(String[] args) {
        new Thread(new TurningRunner(), "偶数").start();
        new Thread(new TurningRunner(), "奇数").start();
    }

    // 拿到锁，打印
    // 打印完，唤醒其他线程，自己休眠
    static class TurningRunner implements Runnable {

        @Override
        public void run() {
            while (count <= 100) {
                synchronized (lock) {
                    System.out.println(Thread.currentThread().getName() + ":" + count++);
                    lock.notify();
                    if (count <= 100) {
                        try {
                            // 如果任务没有结束，就让出锁
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
