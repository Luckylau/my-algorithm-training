package sort;

import java.util.Arrays;

public class InsertionSort {

	public void insertionSort(int[] nums) {
		if (nums.length == 0) {
			return;
		}
		int len = nums.length;
		for (int i = 1; i < len; i++) {
			for (int j = i; j > 0; j--) {
				if (nums[j] < nums[j - 1]) {
					int tmp = nums[j];
					nums[j] = nums[j - 1];
					nums[j - 1] = tmp;
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 2, 1, 3, 4, 9, 6, 7, 8, 5 };
		System.out.println(Arrays.toString(nums));
		InsertionSort insertionSort = new InsertionSort();
		insertionSort.insertionSort(nums);
		System.out.println(Arrays.toString(nums));

	}

}
