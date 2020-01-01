package sort;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] nums = {2, 1, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(Arrays.toString(nums));
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(nums);
        System.out.println(Arrays.toString(nums));

    }

    public void quickSort(int[] nums) {
        if (nums.length == 0) {
            return;
        }
        int low = 0;
        int high = nums.length - 1;
        helper(nums, low, high);
    }

    private void helper(int[] nums, int low, int high) {
        if (low < high) {
            int pivot = Partition(nums, low, high);
            helper(nums, 0, pivot - 1);
            helper(nums, pivot + 1, high);

        }
    }

    private int Partition(int[] nums, int low, int high) {
        int tmp = nums[low];
        while (low < high) {
            while (low < high && nums[high] >= tmp) {
                high--;
            }
            nums[low] = nums[high];
            while (low < high && nums[low] <= tmp) {
                low++;
            }
            nums[high] = nums[low];
        }
        nums[low] = tmp;
        return low;

    }

}
