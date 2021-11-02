package org.ly817.learn.juc;

/**
 * @author LY
 * @date 2020/01/30 11:01
 * <p>
 * Description:
 * 重入锁 synchronized和ReentrantLock都是可重入锁
 */
public class ReentrantLockDemo {
    public static void main(String[] args) {
        Phone phone = new Phone();

        phone.sendEmail();


        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                phone.sendSMS();
            },"t"+i).start();
        }


    }

}

class Phone {
    public synchronized void sendSMS() {
        sendEmail();
        System.out.println(Thread.currentThread().getName() + ":send sms");

    }

    public synchronized void sendEmail() {
        System.out.println(Thread.currentThread().getName() + ":send email");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
