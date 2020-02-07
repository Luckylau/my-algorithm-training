package l.series;

/**
 * @Author luckylau
 * @Date 2020/2/7
 */
public class Rob {
    public static void main(String[] args) {
        int[] nums = {1, 12, 11};
        Rob rob = new Rob();
        System.out.println(rob.rob(nums));
        System.out.println(rob.rob2(nums));
    }

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        if (len == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] res = new int[len];
        res[0] = nums[0];
        res[1] = Math.max(nums[1], nums[0]);
        for (int i = 2; i < len; i++) {
            res[i] = Math.max(nums[i] + res[i - 2], res[i - 1]);
        }
        return res[nums.length - 1];
    }

    public int rob2(int[] nums) {
        int preMax = 0;
        int curMax = 0;
        for (int num : nums) {
            int tmp = curMax;
            curMax = Math.max(preMax + num, curMax);
            preMax = tmp;
        }
        return curMax;
    }
}

