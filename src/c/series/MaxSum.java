package c.series;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		int sum = nums[0];
		int tmp = 0;
		for (int i = 0; i < nums.length; i++) {
			if (tmp >= 0) {
				tmp += nums[i];
				list.add(nums[i]);
			} else {
				tmp = nums[i];
				list.clear();
				list.add(nums[i]);

			}
			map.put(tmp, new ArrayList<Integer>(list));
			if (tmp > sum) {
				sum = tmp;
			}
		}
		return map.get(sum);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[] { 2, -1, -9, 1, 2, 3, -1, -2, -3 };
		MaxSum maxSum = new MaxSum();
		System.out.println(maxSum.maxSum(nums));
		System.out.println(Arrays.toString(maxSum.maxSum2(nums).toArray()));

	}

}
