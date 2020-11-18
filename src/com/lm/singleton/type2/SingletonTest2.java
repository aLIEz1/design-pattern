package com.lm.singleton.type2;

/**
 * 饿汉式，静态代码块实现，和静态常量实现类似，优点和缺点和静态常量实现一样
 *
 * @author zhangfuqi
 * @date 2020/11/17
 */

public class SingletonTest2 {
    public static void main(String[] args) {
        Signleton1 instance1 = Signleton1.getInstance();
        Signleton1 instance2 = Signleton1.getInstance();
        System.out.println(instance1.hashCode());
        System.out.println(instance2.hashCode());
    }
}

class Signleton1 {


    /**
     * 构造器私有化
     */
    private Signleton1() {
    }

    /**
     * 本类内部创建对象实例
     */
    private static final Signleton1 INSTANCE;

    //在静态代码块中创建对象
    static {
        INSTANCE = new Signleton1();
    }

    /**
     * 提供一个公开的静态方法，返回实例对象
     *
     * @return INSTANCE
     */
    public static Signleton1 getInstance() {
        return INSTANCE;
    }
}

