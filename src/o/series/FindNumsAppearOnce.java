package o.series;
/**
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 */

/**
 * @Author luckylau
 * @Date 2019/12/23
 */
public class FindNumsAppearOnce {

    public static void main(String[] args) {
        int[] array = new int[]{1, 1, 3, 6};
        FindNumsAppearOnce findNumsAppearOnce = new FindNumsAppearOnce();
        int num1[] = new int[1];
        int num2[] = new int[1];
        findNumsAppearOnce.FindNumsAppearOnce(array, num1, num2);
        System.out.println(num1[0]);
        System.out.println(num2[0]);
    }

    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        if (array == null && array.length == 0) {
            return;
        }
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum ^= array[i];
        }
        int index = getFirstBitOf1(sum);
        for (int j = 0; j < array.length; j++) {
            if (isBitOf1(array[j], index)) {
                num1[0] ^= array[j];
            } else {
                num2[0] ^= array[j];
            }
        }

    }

    private boolean isBitOf1(int num, int index) {
        return (num >> index & 1) == 1;
    }

    private int getFirstBitOf1(int num) {
        int index = 0;
        while (num > 0) {
            if ((num & 1) == 1) {
                break;
            }
            num = num >> 1;
            index++;
        }
        return index;
    }
}
