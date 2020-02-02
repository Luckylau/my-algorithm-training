package o.series;

/**
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 *
 * @Author luckylau
 * @Date 2019/12/18
 */
public class NumberOf1 {
    public static void main(String[] args) {
        NumberOf1 numberOf1 = new NumberOf1();
        System.out.println(numberOf1.numberOf1(10));
    }

    public int numberOf1(int n) {
        int flag = 1;
        int count = 0;
        while (flag != 0) {
            if ((flag & n) != 0) {
                count++;
            }
            flag = flag << 1;
        }
        return count;
    }
}
