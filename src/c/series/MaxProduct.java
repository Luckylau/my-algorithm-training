package c.series;

/**
 * 给一组数，求连续乘积最大的值
 */
public class MaxProduct {
    public static void main(String[] args) {
        double[] nums = new double[]{1, 2.1, -1, 5, 7, -3, -9};
        MaxProduct maxproduct = new MaxProduct();
        System.out.println(maxproduct.maxProduct(nums));

    }

    public double maxProduct(double[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        double[] curMax = new double[nums.length];
        double[] curMin = new double[nums.length];
        curMax[0] = curMin[0] = nums[0];
        double max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            curMax[i] = Math.max(nums[i], Math.max(curMin[i - 1] * nums[i], curMax[i - 1] * nums[i]));
            curMin[i] = Math.min(nums[i], Math.min(curMin[i - 1] * nums[i], curMax[i - 1] * nums[i]));
            max = Math.max(max, curMax[i]);
        }

        return max;
    }

}
