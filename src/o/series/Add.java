package o.series;

/**
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 */

/**
 * @Author luckylau
 * @Date 2019/12/17
 */
public class Add {

    public static void main(String[] args) {
        Add add = new Add();
        System.out.println(add.add(5, 7));
    }

    public int add(int a, int b) {
        while (b != 0) {
            int sum = a ^ b;
            b = (a & b) << 1;
            a = sum;
        }
        return a;
    }

}
