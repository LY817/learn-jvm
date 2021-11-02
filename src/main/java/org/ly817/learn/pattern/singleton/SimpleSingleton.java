package org.ly817.learn.pattern.singleton;

/**
 * @author LY
 * @date 2020/01/29 16:25
 * <p>
 * Description:
 * 简单的单例 多线程不安全
 */
public class SimpleSingleton {
    public static volatile SimpleSingleton instance = null;

    public SimpleSingleton() {
        System.out.println(Thread.currentThread().getName() + ":init SimpleSingleton");
    }

    public static SimpleSingleton getInstance() {
        if (instance == null) {
            instance = new SimpleSingleton();
        }
        return instance;
    }

    public static void main(String[] args) {
        // 会调用多次构造方法
        for (int i = 0; i < 10; i++) {
            new Thread(SimpleSingleton::getInstance).start();
        }
    }
}
