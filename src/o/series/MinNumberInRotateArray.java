package o.series;
/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */

/**
 * @Author luckylau
 * @Date 2019/12/20
 */
public class MinNumberInRotateArray {
    //解答见：/Users/yrd/Documents/github/my-algorithm-training/src/c/series/FindShiftArrayMin.java

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 0, 1};
        MinNumberInRotateArray minNumberInRotateArray = new MinNumberInRotateArray();
        System.out.println(minNumberInRotateArray.minNumberInRotateArray(nums));

    }

    public int minNumberInRotateArray(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int start = 0;
        int end = array.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (array[end] > array[mid]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return array[start];

    }

}
