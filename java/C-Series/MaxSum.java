package demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

	public List<Integer> maxSum2(int[] nums) {
		List<Integer> list = new ArrayList<Integer>();
		int sum = nums[0];
		int tmp = 0;
		for (int i = 0; i < nums.length; i++) {
			if (tmp >= 0) {
				tmp += nums[i];
				list.add(nums[i]);
				if (i == nums.length - 1 && tmp < sum) {
					list.remove(list.size() - 1);
				}
			} else {
				tmp = nums[i];
				list.clear();
				list.add(nums[i]);

			}
			if (tmp > sum) {
				sum = tmp;
			}
		}
		System.out.println(sum);
		return list;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[] { 1, -2, 3, 10, -4, 7, 2, 5 };
		MaxSum maxSum = new MaxSum();
		System.out.println(maxSum.maxSum(nums));
		System.out.println(Arrays.toString(maxSum.maxSum2(nums).toArray()));

	}

}
