package org.ly817.learn.bytecode;

/**
 * @author LY
 * @date 2020/01/29 13:50
 * <p>
 * Description:
 * i++字节码
 */
public class AddOne {

    volatile int i = 0;


    /**
     *   public void add();
     *     Code:
     *        0: aload_0
     *        1: dup
     *        2: getfield      #2                  // Field i:I
     *        5: iconst_1
     *        6: iadd
     *        7: putfield      #2                  // Field i:I
     *       10: return
     */
    public void add(){
        // i++执行了3步操作
        // 1.主内存读取初始值
        // 2.计算
        // 3.写入主内存
        i++;
    }

    /**
     *   public synchronized void syncAdd();
     *     Code:
     *        0: aload_0
     *        1: dup
     *        2: getfield      #2                  // Field i:I
     *        5: iconst_1
     *        6: iadd
     *        7: putfield      #2                  // Field i:I
     *       10: return
     */
    public synchronized  void syncAdd(){
        i++;
    }
}
