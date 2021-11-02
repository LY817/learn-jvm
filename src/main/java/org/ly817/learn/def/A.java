package org.ly817.learn.def;

/**
 * Created by LuoYu on 2021-01-31.
 */
public interface A {
    default void get() {
        System.out.println("A");
    }
}
