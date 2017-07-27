package sort;

import java.util.Arrays;

public class HeapSort {

	public void heapSort(int[] nums) {
		if (nums.length == 0) {
			return;
		}
		int len = nums.length;
		for (int i = len / 2; i >= 0; i--) {
			HeapAdjust(nums, i, len);
		}
		for (int i = len - 1; i >= 1; i--) {
			int tmp = nums[0];
			nums[0] = nums[i];
			nums[i] = tmp;
			HeapAdjust(nums, 0, i - 1);
		}
	}

	private void HeapAdjust(int[] nums, int index, int length) {
		int tmp = nums[index];
		for (int i = 2 * index + 1; i < length; i = 2 * i + 1) {
			if (i < length && nums[i] < nums[i + 1]) {
				i++;
			}
			if (tmp >= nums[i]) {
				break;
			}
			nums[index] = nums[i];
			index = i;
		}
		nums[index] = tmp;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 2, 1, 3, 4, 9, 6, 7, 8, 5 };
		System.out.println(Arrays.toString(nums));
		HeapSort HeapSort = new HeapSort();
		HeapSort.heapSort(nums);
		System.out.println(Arrays.toString(nums));
	}

}
