package cn.edu.ncu.erlys.liu.singleton;

/**
 *  饿汉式 (静态常量) (可用)
 */
public class Singleton1 {
    // static 表示类加载时初始化
    private final static Singleton1 INSTANCE = new Singleton1();

    private Singleton1() {

    }

    public static Singleton1 getInstance() {
        return INSTANCE;
    }

}
