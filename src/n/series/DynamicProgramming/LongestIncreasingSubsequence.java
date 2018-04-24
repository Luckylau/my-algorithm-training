/**
 * Given a sequence of integers, find the longest increasing subsequence (LIS).
 * You code should return the length of the LIS.
 * Example
 * For [5, 4, 1, 2, 3], the LIS is [1, 2, 3], return 3
 * For [4, 2, 4, 5, 3, 7], the LIS is [2, 4, 5, 7], return 4
 * 
 * 
 */
package n.series.DynamicProgramming;

public class LongestIncreasingSubsequence {
    public int longestIncreasingSubsequence(int[] nums) {
        // write your code here
        if ( nums.length == 0 || nums == null) {
            return 0;
        }
        int[] f = new int[nums.length];
        int max = 0;
        for (int i = 0;i < nums.length; i++) {
            f[i] = 1;
            for (int j = 0; j < i;j++) {
                if (nums[i] > nums[j]) {
                    f[i] = f[i] > f[j] + 1 ? f[i] : f[j] + 1;
                }
            }
            if (max < f[i]) {
                max = f[i];
            }
        }
        return max;
    }
	public static void main(String[] args) {
		int[] nums = {1,2,3,7,10,6,5,4,3,2,1};
		LongestIncreasingSubsequence longestIncreasingSubsequence = new LongestIncreasingSubsequence();
		System.out.println(longestIncreasingSubsequence.longestIncreasingSubsequence(nums));
	}

}
