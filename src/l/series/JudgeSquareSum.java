package l.series;
/**
 * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c。
 */

/**
 * @Author luckylau
 * @Date 2020/1/2
 */
public class JudgeSquareSum {
    public boolean judgeSquareSum(int c) {
        int i = 0;
        int j = (int) Math.sqrt(c);
        while (i <= j) {
            if (i * i + j * j > c) {
                j--;
            } else if (i * i + j * j < c) {
                i++;
            } else {
                return true;
            }
        }
        return false;
    }
}
