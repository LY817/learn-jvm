package org.ly817.learn.pattern.singleton;

/**
 * @author LY
 * @date 2020/01/29 15:44
 * <p>
 * Description:
 * Double Check Lock 双重检查 避免对线环境下多次创建实例
 *
 */
public class DCLSingleton {

    public static volatile DCLSingleton instance = null;

    public DCLSingleton() {
        System.out.println(Thread.currentThread().getName() + ":init DCLSingleton");
    }

    public static DCLSingleton getInstance() {
        if (instance == null) {
            synchronized (DCLSingleton.class) {
                if (instance == null) {
                    instance = new DCLSingleton();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(DCLSingleton::getInstance).start();
        }
    }
}
