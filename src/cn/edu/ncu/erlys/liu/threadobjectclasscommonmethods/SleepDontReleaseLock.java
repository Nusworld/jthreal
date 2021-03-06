package cn.edu.ncu.erlys.liu.threadobjectclasscommonmethods;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// sleep不释放lock (lock需要手动释放)
public class SleepDontReleaseLock implements Runnable{

    private static final Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        SleepDontReleaseLock lock = new SleepDontReleaseLock();
        new Thread(lock).start();
        new Thread(lock).start();
    }

    @Override
    public void run() {
        lock.lock();
        System.out.println("线程" + Thread.currentThread().getName() + "获取到了锁");
        try {
            Thread.sleep(5000);
            System.out.println("线程" + Thread.currentThread().getName() + "已经苏醒");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
