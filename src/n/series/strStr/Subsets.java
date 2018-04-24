/**
 * Given a set of distinct integers, return all possible subsets.
 * Notice
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * 
 * 
 */
package n.series.strStr;

import java.util.ArrayList;
import java.util.Arrays;

public class Subsets {

	public ArrayList<ArrayList<Integer>> subsets(int[] nums) {
		// write your code here
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (nums.length == 0) {
			result.add(new ArrayList<Integer>());
			return result;
		}
		Arrays.sort(nums);
		subsetsHelper(new ArrayList<Integer>(), 0, nums, result);
		return result;
	}

	private void subsetsHelper(ArrayList<Integer> subnet, int startIndex, int[] nums,
			ArrayList<ArrayList<Integer>> result) {
		result.add(new ArrayList<Integer>(subnet));
		for (int i = startIndex; i < nums.length; i++) {
			subnet.add(nums[i]);
			subsetsHelper(subnet, i + 1, nums, result);
			subnet.remove(subnet.size() - 1);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[] { 4, 1, 0 };
		Subsets subsets = new Subsets();
		System.out.println(Arrays.deepToString(subsets.subsets(nums).toArray()));

	}

}
