package sort;

import java.util.Arrays;

public class ShellSort {

    public static void main(String[] args) {
        int[] nums = {2, 1, 3, 4, 9, 6, 7, 8, 5};
        System.out.println(Arrays.toString(nums));
        ShellSort shellSort = new ShellSort();
        shellSort.shellSort(nums);
        System.out.println(Arrays.toString(nums));

    }

    public void shellSort(int[] nums) {
        if (nums.length == 0) {
            return;
        }
        int len = nums.length;
        int increment = len / 2;
        while (increment >= 1) {
            for (int i = 0; i < len; i++) {
                for (int j = i; j < len - increment; j += increment) {
                    if (nums[j] > nums[j + increment]) {
                        int tmp = nums[j];
                        nums[j] = nums[j + increment];
                        nums[j + increment] = tmp;
                    }
                }
            }
            increment = increment / 2;
        }
    }

}
