package demo;

/**
 * ��һ�������ʼ�����ɸ�Ԫ�ذᵽ�����ĩβ�����ǳ�֮Ϊ�������ת�� 
 * ����һ���ź���������һ����ת�� �����ת�������СԪ�ء���������{3, 4, 5,
 * 1, 2}Ϊ{1, 2, 3, 4, 5}��һ����ת������ �����СֵΪ1��
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
