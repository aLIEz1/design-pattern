package com.lm.singleton.type1;

/**
 * 饿汉式，静态常变量实现
 * 写法简单，类加载的时候完成实例化，避免了线程同步问题
 * 但是没有实现懒加载的效果，如果从未使用过，可能会造成内存的浪费
 *
 * @author zhangfuqi
 * @date 2020/11/17
 */
public class SingletonTest1 {
    public static void main(String[] args) {
        Signleton instance1 = Signleton.getInstance();
        Signleton instance2 = Signleton.getInstance();
        //恒为true,且hashCode相同
        System.out.println(instance1.hashCode());
        System.out.println(instance2.hashCode());
    }
}

class Signleton {


    /**
     * 构造器私有化
     */
    private Signleton() {
    }

    /**
     * 本类内部创建对象实例
     */
    private static final Signleton INSTANCE = new Signleton();

    /**
     * 提供一个公开的静态方法，返回实例对象
     *
     * @return INSTANCE
     */
    public static Signleton getInstance() {
        return INSTANCE;
    }
}
