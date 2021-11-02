package org.ly817.learn.lang;

/**
 * @author LY
 * @date 2020/01/30 09:57
 * <p>
 * Description:
 * 传值 传引用 String
 */
public class ReferenceDemo {

    private int a = 1;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    @Override
    public String toString() {
        return "ReferenceDemo{" +
                "a=" + a +
                '}';
    }

    public static void modifyInt(int i) {
        i = 666;
    }

    public static void modifyStr(String str) {
        str = "b";
    }

    public static void modifyObj(ReferenceDemo obj) {
        obj.a = 666;
    }

    public static void main(String[] args) {
        int b = 0;

        String str = "a";

        ReferenceDemo obj = new ReferenceDemo();

        // 基本数据类型
        // 传入的是当前方法中参数的【副本】 不能修改
        System.out.println("post:" + b);
        modifyInt(b);
        System.out.println("after:" + b);

        // 引用数据类型
        // 传入的是对象在堆中的地址引用 可以修改
        System.out.println("post:" + obj);
        modifyObj(obj);
        System.out.println("after:" + obj);

        // 字符串
        // 传入的是字符串在常量池中String对象的地址引用
        // 但是String对象是不可变，修改会在常量池中创建一个新的String对象
        // 原对象引用指向不变
        System.out.println("post:" + str);
        modifyStr(str);
        System.out.println("after:" + str);

    }
}
