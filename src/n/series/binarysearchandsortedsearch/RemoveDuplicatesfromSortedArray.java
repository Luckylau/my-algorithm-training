package n.series.binarysearchandsortedsearch;

import java.util.Arrays;

/**
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * Example
 * Given input array A = [1,1,2],
 * Your function should return length = 2, and A is now [1,2].
 */
public class RemoveDuplicatesfromSortedArray {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2, 4, 4, 5, 5, 5, 8, 9, 12, 15, 16};
        System.out.println(Arrays.toString(nums));
        RemoveDuplicatesfromSortedArray removeDuplicatesfromSortedArray = new RemoveDuplicatesfromSortedArray();
        System.out.println(Arrays.toString(removeDuplicatesfromSortedArray.removeDuplicates(nums)));
    }

    public int[] removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[j]) {
                j++;
                nums[j] = nums[i];
            }
        }
        return Arrays.copyOf(nums, j + 1);
    }

}
