package l.series;

import java.util.Arrays;

public class EvenoddOrder {

    public static void main(String[] args) {

        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        EvenoddOrder evenoddSort = new EvenoddOrder();
        evenoddSort.evenoddSort(nums);
        System.out.println(Arrays.toString(nums));

    }

    public void evenoddSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            if (nums[start] % 2 == 0) {
                while (nums[end] % 2 == 0) {
                    end--;
                }
                int tmp = nums[start];
                nums[start] = nums[end];
                nums[end] = tmp;
                end--;
            }
            start++;
        }
    }

}
