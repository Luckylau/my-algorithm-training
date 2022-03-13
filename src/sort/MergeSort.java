package sort;

import java.util.Arrays;

/**
 * @Author luckylau
 * @Date 2022/3/13
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] nums = {2, 1, 3, 4, 9, 6, 7, 8, 5, 10, 5, 6};
        System.out.println(Arrays.toString(nums));
        MergeSort mergeSort = new MergeSort();
        mergeSort.sortArray(nums);
        System.out.println(Arrays.toString(nums));
    }

    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }


    private void mergeSort(int[] nums, int start, int end) {
        if (start < end) {
            int mid = start + (end - start) / 2;
            mergeSort(nums, start, mid);
            mergeSort(nums, mid + 1, end);
            merge(nums, start, end);
        }
    }

    private void merge(int[] nums, int start, int end) {
        int mid = start + (end - start) / 2;
        int left = start;
        int right = mid + 1;
        int[] tmp = new int[end - start + 1];
        int count = 0;
        while (left <= mid && right <= end) {
            if (nums[left] < nums[right]) {
                tmp[count++] = nums[left++];
            } else {
                tmp[count++] = nums[right++];
            }
        }
        if (left <= mid) {
            while (left <= mid) {
                tmp[count++] = nums[left++];
            }
        }

        if (right <= end) {
            while (right <= end) {
                tmp[count++] = nums[right++];
            }
        }
        count = 0;
        while (start <= end) {
            nums[start++] = tmp[count++];
        }
    }


}
