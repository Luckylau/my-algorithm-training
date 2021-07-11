package sort;

import java.util.Arrays;

public class HeapSort {

    public static void main(String[] args) {
        int[] nums = new int[]{13, 6, 8, 9, 2, 1,};
        System.out.println(Arrays.toString(nums));
        HeapSort heapSort = new HeapSort();
        heapSort.heapSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void heapSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int len = nums.length;
        for (int i = (len - 1) / 2; i >= 0; i--) {
            heapAdjust(nums, i, len);
        }
        for (int i = len - 1; i >= 1; i--) {
            int tmp = nums[0];
            nums[0] = nums[i];
            nums[i] = tmp;
            heapAdjust(nums, 0, i);
        }
    }

    private void heapAdjust(int[] nums, int index, int length) {
        int tmp = nums[index];
        for (int i = 2 * index + 1; i < length; i = 2 * i + 1) {
            if (i + 1 < length && nums[i] < nums[i + 1]) {
                i++;
            }
            if (tmp >= nums[i]) {
                break;
            }
            nums[index] = nums[i];
            index = i;
        }
        nums[index] = tmp;
    }

}
