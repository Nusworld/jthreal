package cn.edu.ncu.erlys.liu.jmm;

import java.util.concurrent.atomic.AtomicInteger;

public class UseVolatile implements Runnable{
    volatile boolean done = false;
    AtomicInteger realA = new AtomicInteger();
    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            setDone();
            realA.incrementAndGet();
        }
    }

    private void setDone() {
        done = true;
    }

    public static void main(String[] args) throws InterruptedException {
        Runnable r = new UseVolatile();
        Thread thread1 = new Thread(r);
        Thread thread2 = new Thread(r);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(((UseVolatile) r).done);
        System.out.println(((UseVolatile) r).realA.get());
    }
}
