package org.ly817.learn.jmm;

/**
 * @author LY
 * @date 2020/01/29 12:58
 * <p>
 * Description:
 * 利用volatile跨线程通信demo
 */
public class VolatileThreadNotifyDemo {

    // 基本数据类型

    // main线程感知到flag变化 执行notified并退出
    private static volatile Boolean flag = false;
    // main线程不能感知到flag变化 不执行notified
//    private static boolean flag = false;


    public static void main(String[] args) {
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + ":start");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            VolatileThreadNotifyDemo.flag = true;
            System.out.println(Thread.currentThread().getName() + ":finished");
        }).start();

        do {
//            System.out.println(Thread.currentThread().getName() + ":wait...");
        } while (!flag);

        System.out.println(Thread.currentThread().getName() + ":notified");
    }


}
