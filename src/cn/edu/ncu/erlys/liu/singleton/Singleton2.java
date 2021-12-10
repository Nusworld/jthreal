package cn.edu.ncu.erlys.liu.singleton;

/**
 *  饿汉式 (静态代码块) (可用)
 */
public class Singleton2 {
    // static 表示类加载时初始化
    // 类加载时JVM保证线程安全
    private final static Singleton2 INSTANCE;

    static {
        INSTANCE = new Singleton2();
    }

    private Singleton2() {

    }

    public static Singleton2 getInstance() {
        return INSTANCE;
    }

}
