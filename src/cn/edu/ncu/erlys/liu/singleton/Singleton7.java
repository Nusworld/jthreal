package cn.edu.ncu.erlys.liu.singleton;

/**
 * 静态内部类 (可用)
 */
public class Singleton7 {
    private volatile static Singleton7 INSTANCE;

    private Singleton7() {}

    private static class SingletonInstance {
        // JVM确保类加载时线程安全
        private static final Singleton7 INSTANCE = new Singleton7();
    }

    public static Singleton7 getInstance() {
        return SingletonInstance.INSTANCE;
    }
}
