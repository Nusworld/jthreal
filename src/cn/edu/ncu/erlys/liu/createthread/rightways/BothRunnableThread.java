package cn.edu.ncu.erlys.liu.createthread.rightways;
public class BothRunnableThread {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("来自Runnable接口的run方法");
            }
        }) {
            @Override
            public void run() {
                System.out.println("来自重写run方法");
            }
        }.start();
    }
}
