package demo;

import java.util.Arrays;

/**
 * 寻找最小的k个数 题目描述：查找最小的k个元素 题目：输入n个整数，输出其中最小的k个。
 * 例如输入1，2，3，4，5，6，7和8这8个数字，则最小的4个数字为1，2，3和4。
 *
 */
public class FindKMin {
	/**
	 * 快速排序变种
	 * 
	 */
	public int[] findKmin(int[] nums, int k) {
		int[] res = new int[k];
		if (nums.length == 0 || nums == null) {
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

	/**
	 * 最小堆
	 * 
	 */
	public int[] findKmin2(int[] nums, int k) {
		int[] res = new int[k];
		if (nums.length == 0 || nums == null) {
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

	public static void main(String[] args) {
		int[] nums = new int[] { 13, 6, 8, 9, 2, 2, };
		FindKMin findKMin = new FindKMin();
		System.out.println(Arrays.toString(findKMin.findKmin(nums, 4)));
		int[] nums2 = new int[] { 13, 6, 8, 9, 2, 2,};
		System.out.println(Arrays.toString(findKMin.findKmin2(nums2, 4)));
	}

}
