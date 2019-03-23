package c.series;

import java.util.Arrays;

/**
 * 寻找K个最小值
 *
 */
public class FindKMin {

	public static void main(String[] args) {
		int[] nums = new int[]{13, 6, 8, 9, 2, 2,};
		FindKMin findKMin = new FindKMin();
		System.out.println(Arrays.toString(findKMin.findKmin(nums, 4)));
		int[] nums2 = new int[]{13, 6, 8, 9, 2, 2,};
		System.out.println(Arrays.toString(findKMin.findKmin2(nums2, 4)));
		int[] nums3 = new int[]{13, 6, 8, 9, 2, 2,};
		System.out.println(Arrays.toString(findKMin.findKmin3(nums2, 4)));
	}

	public int[] findKmin(int[] nums, int k) {
		int[] res = new int[k];
		if (nums == null || nums.length == 0) {
			return res;
		}
		if (k >= nums.length) {
			return nums;
		}
		int low = 0;
		int high = nums.length - 1;
		int pivot = Partition(nums, low, high);
		while (pivot != k - 1) {
			if (pivot > k - 1) {
				high = pivot - 1;
				pivot = Partition(nums, low, high);
			} else {
				low = pivot + 1;
				pivot = Partition(nums, low, high);
			}
		}
		for (int i = 0; i < k; i++) {
			res[i] = nums[i];
		}
		return res;
	}

	private int Partition(int[] nums, int low, int high) {
		int tmp = nums[low];
		while (low < high) {
			while (low < high && nums[high] >= tmp) {
				high--;
			}
			nums[low] = nums[high];
			while (low < high && nums[low] <= tmp) {
				low++;
			}
			nums[high] = nums[low];
		}
		nums[low] = tmp;
		return low;
	}

	public int[] findKmin2(int[] nums, int k) {
		int[] res = new int[k];
		if (nums == null || nums.length == 0) {
			return res;
		}
		if (k >= nums.length) {
			return nums;
		}
		int len = nums.length;
		for (int i = len / 2; i >= 0; i--) {
			HeapAdjust(nums, i, len);
		}
		for (int j = len - 1; j >= len - k; j--) {
			int tmp = nums[0];
			nums[0] = nums[j];
			nums[j] = tmp;
			HeapAdjust(nums, 0, j);
		}
		for (int i = 0; i < k; i++) {
			res[i] = nums[len - i - 1];
		}
		return res;

	}

	private void HeapAdjust(int[] nums, int index, int length) {
		int tmp = nums[index];
		for (int i = 2 * index + 1; i < length - 1; i = 2 * i + 1) {
			if (nums[i] > nums[i + 1]) {
				i++;
			}
			if (tmp < nums[i]) {
				break;
			}
			nums[index] = nums[i];
			index = i;
		}
		nums[index] = tmp;
	}

	public int[] findKmin3(int[] nums, int k) {
		int[] res = new int[k];
		if (nums == null || nums.length == 0) {
			return res;
		}
		int len = nums.length;
		if (k >= len) {
			return nums;
		}
		for (int i = 0; i < k; i++) {
			for (int j = len - 1; j > i; j--) {
				if (nums[i] > nums[j]) {
					int tmp = nums[i];
					nums[i] = nums[j];
					nums[j] = tmp;
				}
			}
			res[i] = nums[i];
		}
		return res;
	}

}
