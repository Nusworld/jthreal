package cn.edu.ncu.erlys.liu.singleton;

/**
 * 懒汉式 (线程不安全) (不推荐)
 */
public class Singleton5 {
    private static Singleton5 INSTANCE;

    private Singleton5() {}

    public static Singleton5 getInstance() {
        if (INSTANCE == null) {
            // 不同线程拿到锁之后仍然会多次创建实例
            synchronized (Singleton5.class) {
                INSTANCE = new Singleton5();
            }
        }
        return INSTANCE;
    }
}
