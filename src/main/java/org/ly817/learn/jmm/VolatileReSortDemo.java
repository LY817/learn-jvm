package org.ly817.learn.jmm;

/**
 * @author LY
 * @date 2020/01/29 15:07
 * <p>
 * Description:
 * 指令重排demo
 */
public class VolatileReSortDemo {
    int a = 0;

    boolean flag = true;

    public void threadAMethod() {
        a = 1;

        flag = false;
    }

    public void threadBMethod() {
        if (flag) {
            a = a + 5;
            System.out.println(Thread.currentThread().getName() + ":" + a);
        }
    }

}
