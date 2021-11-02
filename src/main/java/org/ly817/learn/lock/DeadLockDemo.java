package org.ly817.learn.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author LY
 * @date 2020/01/31 12:32
 * <p>
 * Description:
 * 死锁
 * 互相等待对方持有的锁
 */
public class DeadLockDemo {

    public static void main(String[] args) {
        Lock lock1 = new ReentrantLock();
        Lock lock2 = new ReentrantLock();

        new Thread(
                () -> {
                    lock1.lock();
                    try {
                        Thread.sleep(1000);
                        lock2.lock();
                        try {

                        } finally {
                            lock2.unlock();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        lock1.unlock();
                    }
                },"thread1"
        ).start();

        new Thread(
                () -> {
                    lock2.lock();
                    try {
                        Thread.sleep(1000);
                        lock1.lock();
                        try {

                        } finally {
                            lock1.unlock();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        lock2.unlock();
                    }
                },"thread1"
        ).start();

    }

}
