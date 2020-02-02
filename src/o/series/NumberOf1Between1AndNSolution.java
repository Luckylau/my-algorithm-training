package o.series;
/**
 * 题目描述
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
 * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。
 * ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
 */

/**
 * @Author luckylau
 * @Date 2019/12/20
 */
public class NumberOf1Between1AndNSolution {
    public static void main(String[] args) {
        NumberOf1Between1AndNSolution numberOf1Between1AndNSolution = new NumberOf1Between1AndNSolution();
        System.out.println(numberOf1Between1AndNSolution.numberOf1Between1AndNSolution(121));
    }

    public int numberOf1Between1AndNSolution(int n) {
        int base = 1;
        int round = n;
        int count = 0;
        while (round > 0) {
            int weight = round % 10;
            round = round / 10;
            count = count + round * base;
            if (weight == 1) {
                count = count + 1 + n % base;
            }
            if (weight > 1) {
                count = count + base;
            }
            base = base * 10;
        }
        return count;
    }
}
