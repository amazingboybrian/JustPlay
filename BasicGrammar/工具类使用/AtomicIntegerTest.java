package 工具类使用;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest {
    /*
    CAS算法
    比synchronized更加高效
    获取、比较、设置
     */
    private static AtomicInteger serialNum = new AtomicInteger(5);

    static {
        System.out.println("原数字：" + serialNum + "\n");

        serialNum.set(5);
        System.out.println("自增后（后加加）：" + serialNum.getAndIncrement()); //相当于a++
        serialNum.set(5);
        System.out.println("自增后（前加加）：" + serialNum.incrementAndGet()); //相当于++a

        System.out.println();

        serialNum.set(5);
        System.out.println("自减后（后减减）：" + serialNum.getAndDecrement()); //相当于a--
        serialNum.set(5);
        System.out.println("自减后（前减减）：" + serialNum.decrementAndGet()); //相当于--a
    }

    public static void main(String[] args) {
        ;
    }

    public void setSerialNum(AtomicInteger serialNum) {
        this.serialNum = serialNum;
    }
}
