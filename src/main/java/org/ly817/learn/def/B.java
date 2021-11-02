package org.ly817.learn.def;

/**
 * @author LY
 * @date 2021/01/31 16:31
 * <p>
 * Description:
 */
public interface B {
    default void get() {
        System.out.println("B");
    }
}
