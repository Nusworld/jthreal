package cn.edu.ncu.erlys.liu.createthread.wrongways;

public class AnonymousInnerClassDemo {
    public static void main(String[] args) {
        new Thread() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }.start();
        new Thread(()-> System.out.println(Thread.currentThread().getName())).start();
    }
}
