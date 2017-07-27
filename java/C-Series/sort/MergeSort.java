package sort;

import java.util.Arrays;

public class MergeSort {
	// µÝ¹é
	public void mergeSort(int[] nums) {
		if (nums.length == 0) {
			return;
		}
		int len = nums.length;
		helper(nums, 0, len - 1);
	}

	private void helper(int[] nums, int left, int right) {
		if (left < right) {
			int mid = left + (right - left) / 2;
			helper(nums, left, mid);
			helper(nums, mid + 1, right);
			merge(nums, left, right);
		}
	}

	private void merge(int[] nums, int left, int right) {
		int mid = left + (right - left) / 2;
		int i = left;
		int j = mid + 1;
		int count = 0;
		int[] tmp = new int[right - left + 1];
		while (i <= mid && j <= right) {
			if (nums[i] < nums[j]) {
				tmp[count++] = nums[i++];
			} else {
				tmp[count++] = nums[j++];
			}
		}
		while (i <= mid) {
			tmp[count++] = nums[i++];
		}
		while (j <= right) {
			tmp[count++] = nums[j++];
		}
		count = 0;
		while (left <= right) {
			nums[left++] = tmp[count++];
		}
	}

	// ·ÇµÝ¹é
	public void mergeSort2(int[] nums) {
		if (nums.length == 0) {
			return;
		}
		int sublen = 1;
		int length = nums.length;
		while (sublen < length) {
			for (int i = 0; i < length; i += 2 * sublen) {
				merge2(nums, i, sublen);
			}
			sublen *= 2;
		}
	}

	private void merge2(int[] nums, int i, int sublen) {
		int start = i;
		int count = 0;
		int[] tmp = new int[2 * sublen];

		int frontlen = nums.length > (i + sublen) ? (i + sublen) : nums.length;
		int j = i + sublen;
		int rearlen = nums.length > (j + sublen) ? (j + sublen) : nums.length;
		while (i < frontlen && j < rearlen) {
			if (nums[i] < nums[j]) {
				tmp[count++] = nums[i++];
			} else {
				tmp[count++] = nums[j++];
			}
		}
		while (i < frontlen) {
			tmp[count++] = nums[i++];
		}
		while (j < rearlen) {
			tmp[count++] = nums[j++];
		}

		for (int k = 0; k < count; k++) {
			nums[start++] = tmp[k];
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 2, 1, 3, 4, 9, 6, 7, 8, 5, 10, 5, 6 };
		System.out.println(Arrays.toString(nums));
		MergeSort MergeSort = new MergeSort();
		MergeSort.mergeSort(nums);
		System.out.println(Arrays.toString(nums));
		int[] nums2 = { 2, 1, 3, 4, 9, 6, 7, 8, 5, 10, 5, 6 };
		System.out.println(Arrays.toString(nums2));
		MergeSort.mergeSort2(nums2);
		System.out.println(Arrays.toString(nums2));
	}

}
