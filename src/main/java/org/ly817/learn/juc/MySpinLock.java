package org.ly817.learn.juc;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author LY
 * @date 2020/01/30 11:51
 * <p>
 * Description:
 * 简单自旋锁
 */
public class MySpinLock {

    private AtomicReference<Thread> currentTread = new AtomicReference<>();

    public void lock() {
        // 自旋占用锁
        while (!currentTread.compareAndSet(null,Thread.currentThread())) {

        }
        System.out.println(currentTread.get().getName() + ":获取锁");
    }

    public void unlock() {
        // 删除锁
        currentTread.compareAndSet(Thread.currentThread(),null);
    }

    public static void main(String[] args) {
        MySpinLock lock = new MySpinLock();

        new Thread(() -> {
            lock.lock();
            try {
                System.out.println("线程1执行");
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        },"t1").start();
        new Thread(() -> {
            lock.lock();
            System.out.println("线程二执行");
            lock.unlock();
        },"t2").start();


    }

}
