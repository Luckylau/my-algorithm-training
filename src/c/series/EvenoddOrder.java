package c.series;

import java.util.Arrays;

public class EvenoddOrder {

	public void evenoddSort(int[] nums) {
		if (nums == null || nums.length == 0) {
			return;
		}
		int start = 0;
		int end = nums.length - 1;
		while (start < end) {
			if (nums[start] % 2 == 0) {
				while (nums[end] % 2 == 0) {
					end--;
				}
				int tmp = nums[start];
				nums[start] = nums[end];
				nums[end] = tmp;
				end--;
			}
			start++;
		}
	}

	public static void main(String[] args) {

		int[] nums = new int[] { 3, 4, 1, 5, 7, 2, 8, 10, 8, 7 };
		EvenoddOrder evenoddSort = new EvenoddOrder();
		evenoddSort.evenoddSort(nums);
		System.out.println(Arrays.toString(nums));

	}

}
