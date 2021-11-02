package org.ly817.learn.juc;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author LY
 * @date 2020/01/29 17:37
 * <p>
 * Description:
 */
public class AtomicTest {
    static AtomicInteger i = new AtomicInteger(666);
    static AtomicInteger j = new AtomicInteger(1666);

    public static void main(String[] args) {
        j.compareAndSet(1666,888);
    }
}