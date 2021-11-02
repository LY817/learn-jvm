package org.ly817.learn.pattern.singleton;

/**
 * @author LY
 * @date 2020/01/29 16:25
 * <p>
 * Description:
 * synchronized的单例 多线程安全 但执行效率较低
 */
public class SyncSingleton {
    public static volatile SyncSingleton instance = null;

    public SyncSingleton() {
        System.out.println(Thread.currentThread().getName() + ":init SyncSingleton");
    }

    public static synchronized SyncSingleton getInstance() {
        if (instance == null) {
            instance = new SyncSingleton();
        }
        return instance;
    }

    public static void main(String[] args) {
        // 会调用多次
        for (int i = 0; i < 10; i++) {
            new Thread(SyncSingleton::getInstance).start();
        }
    }
}
