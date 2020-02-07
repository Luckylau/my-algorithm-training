package l.series;

/**
 * @Author luckylau
 * @Date 2020/2/7
 */
public class RobII {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        RobII robII = new RobII();
        System.out.println(robII.rob(nums));
    }

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        return Math.max(maxRob(nums, 0, len - 1), maxRob(nums, 1, len));

    }

    private int maxRob(int[] nums, int start, int end) {
        int preMax = 0;
        int curMax = 0;
        for (int i = start; i < end; i++) {
            int tmp = curMax;
            curMax = Math.max(preMax + nums[i], curMax);
            preMax = tmp;
        }
        return curMax;
    }
}
