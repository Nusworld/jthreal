package cn.edu.ncu.erlys.liu.createthread.rightways;

public class ThreadStyle extends Thread{
    @Override
    public void run() {
        System.out.println("In Thread");
//        super.run();
    }

    public static void main(String[] args) {
        new ThreadStyle().start();
    }
}
