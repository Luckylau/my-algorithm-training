package l.series;

import java.util.Arrays;

/**
 *
 */
public class HollandFlag {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 0, 1, 0, 1, 2, 1, 0, 0, 0, 1};
        HollandFlag hollandFlag = new HollandFlag();
        hollandFlag.hollandFlag(nums);
        System.out.println(Arrays.toString(nums));

    }

    public void hollandFlag(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int cur = 0;
        int begin = 0;
        int end = nums.length - 1;
        while (cur <= end) {
            if (nums[cur] == 0) {
                swap(nums, cur, begin);
                cur++;
                begin++;
            } else if (nums[cur] == 1) {
                cur++;
            } else if (nums[cur] == 2) {
                swap(nums, cur, end);
                end--;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
