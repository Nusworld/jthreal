package cn.edu.ncu.erlys.liu.singleton;

/**
 * 双重检查 (推荐面试使用)
 */
public class Singleton6 {
    private volatile static Singleton6 INSTANCE;

    private Singleton6() {}

    public static Singleton6 getInstance() {
        if (INSTANCE == null) {
            // 不同线程拿到锁之后仍然会多次创建实例
            synchronized (Singleton6.class) {
                if (INSTANCE == null)
                    INSTANCE = new Singleton6();
            }
        }
        return INSTANCE;
    }
}
