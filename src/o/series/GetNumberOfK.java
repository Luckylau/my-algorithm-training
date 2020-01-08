package o.series;
/**
 * 统计一个数字在排序数组中出现的次数。
 */

/**
 * @Author luckylau
 * @Date 2019/12/23
 */
public class GetNumberOfK {
    public static void main(String[] args) {
        int[] a = new int[]{2, 2, 3};
        GetNumberOfK getNumberOfK = new GetNumberOfK();
        System.out.println(getNumberOfK.getNumberOfK(a, 3));
    }

    public int getNumberOfK(int[] array, int k) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int lowIndex;
        int highIndex;

        int start = 0;
        int end = array.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (array[mid] >= k) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        if (start == array.length || array[start] != k) {
            return 0;
        }
        lowIndex = start;
        end = array.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (array[mid] <= k) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        highIndex = end;
        return highIndex - lowIndex + 1;
    }
}
