package demo;

import java.util.Arrays;

/**
 * 现有n个红白蓝三种不同颜色的小球，乱序排列在一起，请通过两两交换任意两个球， 使得从左至右的球依次为红球、白球、蓝球。
 * 这个问题之所以叫荷兰国旗，是因为将红白蓝三色的小球弄成条状物，并有序排列后正好组成荷兰国旗。 红：0 ，白 ：1，蓝：2
 *
 */
public class HollandFlag {

	public void hollandFlag(int[] nums) {
		if (nums.length == 0 || nums == null) {
			return;
		}
		int cur = 0;
		int begin = 0;
		int end = nums.length - 1;
		while (cur <= end) {
			if (nums[cur] == 0) {
				swap(nums,cur,begin);
				cur++;
				begin++;
			}else if (nums[cur] == 1) {
				cur++;
			}else if (nums[cur] == 2) {
				swap(nums,cur,end);
				end--;
			}
		}
	}
	private void swap(int[] nums, int i , int j){
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums= new int[] { 2, 0, 1, 0, 1, 2, 1, 0, 0, 0 ,1};
		HollandFlag hollandFlag = new HollandFlag();
		hollandFlag.hollandFlag(nums);
		System.out.println(Arrays.toString(nums));

	}

}
