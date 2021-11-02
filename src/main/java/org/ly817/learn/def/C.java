package org.ly817.learn.def;

/**
 * @author LY
 * @date 2021/01/31 16:32
 * <p>
 * Description:
 */
public interface C extends A,B {
    void set();

    @Override
    default void get() {

    }
}
