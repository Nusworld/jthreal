package cn.edu.ncu.erlys.liu.createthread.rightways;

public class RunnableStyle implements Runnable {
    @Override
    public void run() {
        System.out.println("In Runnable");
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new RunnableStyle());
        thread.start();
    }
}
