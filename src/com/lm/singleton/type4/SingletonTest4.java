package com.lm.singleton.type4;

/**
 * 懒汉式，线程安全
 * 效率低下，执行getInstance方法都要进行同步，而其实这个方法只执行一次实例化代码就够了
 * 后面想获得该类实例直接return就好了，方法进行同步效率太低
 *
 * @author zhangfuqi
 * @date 2020/11/18
 */
public class SingletonTest4 {
    public static void main(String[] args) {
//        Singleton4 instance1 = Singleton4.getInstance();
//        Singleton4 instance2 = Singleton4.getInstance();
//        System.out.println(instance1.hashCode());
//        System.out.println(instance2.hashCode());
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(Singleton4.getInstance().hashCode());
            }).start();
        }

    }
}

class Singleton4 {
    private static Singleton4 INSTANCE;

    private Singleton4() {
    }

    /**
     * 提供一个静态的公有方法，当使用到该方法时才去创建INSTANCE
     * 即懒汉式
     *
     * @return Singleton4
     */
    public static synchronized Singleton4 getInstance() {

        if (INSTANCE == null) {
            INSTANCE = new Singleton4();
        }
        return INSTANCE;
    }
}
