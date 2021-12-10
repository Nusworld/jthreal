package cn.edu.ncu.erlys.liu.uncaughtexception;

/**
 * 1. 不加try catch抛出4个异常，都带线程名
 * 2. 加了try catch,期望捕获第一个线程的异常，线程2，3，4不应该运行，希望看到Caught Exception
 * 3. 执行时发现，根本没有Caught Exception, 线程2, 3, 4 依然运行并且抛出异常
 * 说明线程的异常不能用传统方法捕获
 */
public class CannotCatchDirectly implements Runnable{

    public static void main(String[] args) {
        try{
            new Thread(new CannotCatchDirectly(), "My-Thread-1").start();
            new Thread(new CannotCatchDirectly(), "My-Thread-2").start();
            new Thread(new CannotCatchDirectly(), "My-Thread-3").start();
            new Thread(new CannotCatchDirectly(), "My-Thread-4").start();
        }catch (RuntimeException r) {
            System.out.println("Caught Exception");
        }

    }

    @Override
    public void run() {
        throw new RuntimeException();
    }
}
