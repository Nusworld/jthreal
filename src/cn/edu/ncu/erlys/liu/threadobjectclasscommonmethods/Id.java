package cn.edu.ncu.erlys.liu.threadobjectclasscommonmethods;

// id从1开始， JVM运行起来之后，我们自己创建的线程id已经不是2
public class Id {
    public static void main(String[] args) {
        Thread thread = new Thread();
        System.out.println("主线程Id" + Thread.currentThread().getId());
        System.out.println("子线程Id" + thread.getId());
    }
}
