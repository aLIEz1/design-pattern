package com.lm.singleton.type3;

/**
 * 懒汉式，线程不安全
 * 实现了懒加载的效果，但是只能在单线程下使用
 * 如果在多线程下，一个线程进入了if (INSTANCE == null)判断语句块，还未来得及往下执行
 * 另一个线程也通过了这个判断语句，这时便会产生多个实例
 * 所以在多线程情况下不可以使用这种方式
 * @author zhangfuqi
 * @date 2020/11/18
 */
public class SingletonTest3 {
    public static void main(String[] args) {
        Singleton3 instance1 = Singleton3.getInstance();
        Singleton3 instance2 = Singleton3.getInstance();
        System.out.println(instance1.hashCode());
        System.out.println(instance2.hashCode());

    }
}

class Singleton3 {
    private static Singleton3 INSTANCE;

    private Singleton3() {
    }

    /**
     * 提供一个静态的公有方法，当使用到该方法时才去创建INSTANCE
     * 即懒汉式
     *
     * @return Singleton3
     */
    public static Singleton3 getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Singleton3();
        }
        return INSTANCE;
    }
}
