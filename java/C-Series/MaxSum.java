package demo;

public class MaxSum {

	public int maxSum(int[] nums) {
		int sum = nums[0];
		int tmp = 0;
		for (int i = 0; i < nums.length; i++) {
			if (tmp >= 0) {
				tmp += nums[i];
			} else {
				tmp = nums[i];
			}
			if (tmp > sum) {
				sum = tmp;
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[] { 1, -2, 3, 10, -4, 7, 2, -5 };
		MaxSum maxSum = new MaxSum();
		System.out.println(maxSum.maxSum(nums));

	}

}
