package org.ly817.learn.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author LY
 * @date 2020/01/31 12:06
 * <p>
 * Description:
 * 线程池 自定义参数demo
 */
public class ThreadPoolExecutorDemo {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
                                        3,
                                        8,
                                        2, TimeUnit.SECONDS,
                                        new ArrayBlockingQueue<>(5),
                                        Executors.defaultThreadFactory());
        Runnable task = () -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "执行任务");
        };

        threadPool.execute(task);
        threadPool.execute(task);
        threadPool.execute(task);
        threadPool.execute(task);
        threadPool.execute(task);
        threadPool.execute(task);
        threadPool.execute(task);
        threadPool.execute(task);
        threadPool.execute(task);
        threadPool.execute(task);
        threadPool.execute(task);
        threadPool.execute(task);
        threadPool.execute(task);
    }
}
