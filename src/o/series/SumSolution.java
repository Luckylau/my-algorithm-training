package o.series;
/**
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */

/**
 * @Author luckylau
 * @Date 2019/12/17
 */
public class SumSolution {
    public static void main(String[] args) {
        SumSolution sumSolution = new SumSolution();
        System.out.println(sumSolution.sumSolution(3));
    }

    public int sumSolution(int n) {
        int res = n;
        if (res > 0) {
            res += sumSolution(n - 1);
        }
        return res;
    }


}
