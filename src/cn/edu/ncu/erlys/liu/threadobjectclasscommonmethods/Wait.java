package cn.edu.ncu.erlys.liu.threadobjectclasscommonmethods;

/**
 * wait notify
 * 研究代码执行顺序
 * 证明wait释放锁
 */
public class Wait {
    public static Object object = new Object();

    static class Thread1 extends Thread {
        @Override
        public void run() {
            synchronized (object) {
                System.out.println("线程" + Thread.currentThread().getName() + "开始执行");
                try {
                    object.wait(); // wait 会释放锁
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程" + Thread.currentThread().getName() + "获得到了锁");
            }
        }
    }

    static class Thread2 extends Thread {
        @Override
        public void run() {
            synchronized (object) {
                object.notify();
                System.out.println("线程" + Thread.currentThread().getName() + "调用了notify()");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread1 thread1 = new Thread1();
        Thread2 thread2 = new Thread2();

        thread1.start();
        Thread.sleep(200);
        thread2.start();

    }
}
