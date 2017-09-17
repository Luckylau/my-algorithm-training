package demo;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 
 * 输入一个排好序的数组的一个旋转， 输出旋转数组的最小元素。例如数组{3, 4, 5,
 * 1, 2}为{1, 2, 3, 4, 5}的一个旋转，该数 组的最小值为1。
 * 
 *
 */
public class FindShiftArrayMin {

	public int findShiftArrayMin(int[] nums) {
		if (nums.length == 0 || nums == null) {
			return -1;
		}
		return helper(nums, 0, nums.length - 1);
	}

	private int helper(int[] nums, int start, int end) {
		if (start == end) {
			return nums[start];
		}
		int mid = start + (end - start) / 2;
		if (nums[start] > nums[mid]) {
			return helper(nums, start, mid);
		} else {
			return helper(nums, mid + 1, end);
		}
	}

	public static void main(String[] args) {
		int[] nums = { 4, 5, 8, 9, 10, 1, 2, 3 };
		FindShiftArrayMin findShiftArrayMin = new FindShiftArrayMin();
		System.out.println(findShiftArrayMin.findShiftArrayMin(nums));

	}

}
