package org.ly817.learn.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author LY
 * @date 2020/01/30 19:51
 * <p>
 * Description:
 * condition 精确通知现场
 */
public class LockConditionDemo {

    volatile int flag = 0;

    Lock lock = new ReentrantLock();

    Condition conditionA = lock.newCondition();

    Condition conditionB = lock.newCondition();

    Condition conditionC = lock.newCondition();

    public void methodA() {
        lock.lock();
        try {
            while (flag % 3 != 0) {
                try {
                    conditionA.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("do methodA");
            flag++;
            // 唤醒B现场
            conditionB.signal();
        } finally {
            lock.unlock();
        }
    }

    public void methodB() {
        lock.lock();
        try {
            while (flag % 3 != 1) {
                try {
                    conditionB.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("do methodB");
            flag++;
            // 唤醒C现场
            conditionC.signal();
        } finally {
            lock.unlock();
        }
    }

    public void methodC() {
        lock.lock();
        try {
            while (flag % 3 != 2) {
                try {
                    conditionC.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            flag++;
            System.out.println("do methodC");
            // 唤醒C现场
            conditionA.signal();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        LockConditionDemo demo = new LockConditionDemo();

        // 3个线程轮流唤醒

        new Thread(() -> {
            while (true) {
                demo.methodA();
            }
        },"AAA").start();

        new Thread(() -> {
            while (true) {
                demo.methodB();
            }
        },"BBB").start();

        new Thread(() -> {
            while (true) {
                demo.methodC();
            }
        },"CCC").start();
    }

}
