package m.series;

/**
 * 53. 最大子数组和
 *
 * @Author luckylau
 * @Date 2022/3/13
 */
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        if (nums == null && nums.length == 0) {
            return -1;
        }
        int max = Integer.MIN_VALUE;
        int sum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (sum < 0) {
                sum = nums[i];
            } else {
                sum += nums[i];
            }
            if (sum > max) {
                max = sum;
            }

        }
        return max;
    }
}
