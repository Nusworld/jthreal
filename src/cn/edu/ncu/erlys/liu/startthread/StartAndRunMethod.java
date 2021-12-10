package cn.edu.ncu.erlys.liu.startthread;

public class StartAndRunMethod {
    public static void main(String[] args) {
        Runnable runnable = () -> System.out.println(Thread.currentThread().getName());
        runnable.run(); // 主线程执行

        new Thread(runnable).start(); // 新建线程执行
    }
}
