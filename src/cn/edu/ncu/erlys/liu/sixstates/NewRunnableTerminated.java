package cn.edu.ncu.erlys.liu.sixstates;

/**
 * NEW RUNNABLE TERMINATED 状态
 * 即使正在运行，也是RUNNABLE状态而不是RUNNING
 */
public class NewRunnableTerminated implements Runnable {


    public static void main(String[] args) {
        Object o = new Object();
        Thread thread = new Thread(new NewRunnableTerminated());
        System.out.println(thread.getState()); // 打印出NEW的状态
        thread.start();
        System.out.println(thread.getState()); //

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 打印出RUNNABLE状态,即使在运行中
        // 打印出TERMINATED状态
        System.out.println(thread.getState());

    }


    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(i);
        }
    }
}
