package org.ly817.learn.juc;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author LY
 * @date 2020/01/29 21:12
 * <p>
 * Description:
 * 并发操作list集合
 */
public class ConcurrentListDemo {
    public static void main(String[] args) {

//        List<String> list = new ArrayList<>();
//        List<String> list = new Vector<>();
        List<String> list = new CopyOnWriteArrayList<>();



        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(Thread.currentThread().getName() + ":" + list);

            }).start();
        }
    }
}
