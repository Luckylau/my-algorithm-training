package l.series;

/**
 * @Author luckylau
 * @Date 2020/2/9
 */
public class LengthOfLIS {
    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 5, 7};
        LengthOfLIS lengthOfLIS = new LengthOfLIS();
        System.out.println(lengthOfLIS.lengthOfLIS(nums));
        System.out.println(lengthOfLIS.lengthOfLIS2(nums));


    }

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            int max = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    max = Math.max(max, dp[j] + 1);
                }
            }
            dp[i] = max;
        }
        int ret = 0;
        for (int i = 0; i < n; i++) {
            ret = Math.max(ret, dp[i]);
        }
        return ret;
    }

    public int lengthOfLIS2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = 0;
        int n = nums.length;
        int[] tails = new int[n];
        for (int i = 0; i < n; i++) {
            int index = binarySearch(tails, len, nums[i]);
            tails[index] = nums[i];
            if (index == len) {
                len++;
            }
        }

        return len;
    }

    private int binarySearch(int[] tails, int end, int target) {
        int start = 0;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (target == tails[mid]) {
                return mid;
            } else if (target > tails[mid]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }
}
