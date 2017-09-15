package demo;

import java.util.Arrays;

/**
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。 
 * 请写程序找出这两个只出现一次的数字。 要求时间复杂度是O(n)，空间复杂度是O(1)。
 */
public class GetTwoUniqueNum {

	public int[] getTwoUniqueNum(int[] nums) {
		int[] res = new int[] { 0, 0 };
		if (nums.length == 0 || nums == null) {
			return res;
		}
		int xor = 0;
		for (int i = 0; i < nums.length; i++) {
			xor ^= nums[i];
		}
		int pos = getFirstOne(xor);
		for (int i = 0; i < nums.length; i++) {
			if (isOne(nums[i], pos)) {
				res[0] ^= nums[i];
			} else {
				res[1] ^= nums[i];
			}
		}
		return res;

	}

	private int getFirstOne(int num) {
		int pos = 0;
		while ((num & 0x01) != 1) {
			num = num >> 1;
			pos++;
		}
		return pos;
	}

	private boolean isOne(int nums, int pos) {
		int num = nums;
		num = num >> pos;
		return (num & 0x01) == 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 2, 4, 5, 1, 2, 6, 6, 5, 8,9,8 };
		GetTwoUniqueNum getTwoUniqueNum = new GetTwoUniqueNum();
		System.out.println(Arrays.toString(getTwoUniqueNum.getTwoUniqueNum(nums)));

	}

}
