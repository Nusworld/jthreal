package cn.edu.ncu.erlys.liu.uncaughtexception;

public class ExceptionInChildThread implements Runnable{

    public static void main(String[] args) {
        new Thread(new ExceptionInChildThread()).start();

        for (int i = 0; i < 1000; i++) {
            System.out.println(i);
        }
    }

    @Override
    public void run() {
        throw new RuntimeException();
    }
}
