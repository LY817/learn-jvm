package org.ly817.learn;

import java.nio.ByteBuffer;

/**
 * @author LY
 * @date 2020/01/31 21:27
 * <p>
 * Description:
 */
public class NIODemo {

    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1000000);
        byteBuffer.put(new byte[]{}).clear();
    }
}
