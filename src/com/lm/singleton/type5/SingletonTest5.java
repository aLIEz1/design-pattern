package com.lm.singleton.type5;

/**
 * 双重检查机制 Double Check
 * 解决线程安全问题，同时解决懒加载问题
 * volatile防止指令重排，确保更新立即更新到内存中
 *
 * @author zhangfuqi
 * @date 2020/11/18
 */
public class SingletonTest5 {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(Singleton5.getInstance().hashCode());
            }).start();
        }
    }
}

class Singleton5 {
    private static volatile Singleton5 INSTANCE;

    private Singleton5() {
    }

    public static Singleton5 getInstance() {
        if (INSTANCE == null) {
            synchronized (Singleton5.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Singleton5();
                }
            }
        }
        return INSTANCE;
    }
}
