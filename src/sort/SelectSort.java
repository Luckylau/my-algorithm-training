package sort;

import java.util.Arrays;

public class SelectSort {
    public static void main(String[] args) {
        int[] nums = {2, 1, 3, 4, 9, 6, 7, 8, 5};
        System.out.println(Arrays.toString(nums));
        SelectSort selectSort = new SelectSort();
        selectSort.selectSort(nums);
        System.out.println(Arrays.toString(nums));

    }

    public void selectSort(int[] nums) {
        if (nums.length == 0) {
            return;
        }
        int len = nums.length;
        int min;
        for (int i = 0; i < len; i++) {
            min = i;
            for (int j = min + 1; j < len; j++) {
                if (nums[j] < nums[min]) {
                    min = j;
                }
            }
            if (min != i) {
                int tmp = nums[min];
                nums[min] = nums[i];
                nums[i] = tmp;
            }
        }
    }

}
