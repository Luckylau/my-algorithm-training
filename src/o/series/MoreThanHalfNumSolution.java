package o.series;
/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */

/**
 * @Author luckylau
 * @Date 2019/12/24
 */
public class MoreThanHalfNumSolution {

    public static void main(String[] args) {
        int[] array = {1, 3, 4, 5, 2, 2, 2, 2, 2, 2, 2};
        MoreThanHalfNumSolution moreThanHalfNumSolution = new MoreThanHalfNumSolution();
        System.out.println(moreThanHalfNumSolution.moreThanHalfNumSolution(array));
    }

    public int moreThanHalfNumSolution(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int result = array[0];
        int times = 1;
        for (int i = 1; i < array.length; i++) {
            if (times == 0) {
                result = array[i];
                times = 1;
            } else if (result == array[i]) {
                times++;
            } else {
                times--;
            }
        }

        times = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == result) {
                times++;
            }
        }
        return times > (array.length >> 1) ? result : 0;
    }
}
