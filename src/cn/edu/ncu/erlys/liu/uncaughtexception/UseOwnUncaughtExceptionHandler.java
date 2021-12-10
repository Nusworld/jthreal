package cn.edu.ncu.erlys.liu.uncaughtexception;

public class UseOwnUncaughtExceptionHandler implements Runnable{
    public static void main(String[] args) throws InterruptedException {

            Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHandler("捕获器1"));

            new Thread(new CannotCatchDirectly(), "My-Thread-1").start();
            Thread.sleep(300);
            new Thread(new CannotCatchDirectly(), "My-Thread-2").start();
            Thread.sleep(300);
            new Thread(new CannotCatchDirectly(), "My-Thread-3").start();
            Thread.sleep(300);
            new Thread(new CannotCatchDirectly(), "My-Thread-4").start();
            System.out.println("Caught Exception");
    }

    @Override
    public void run() {
        throw new RuntimeException();
    }
}
