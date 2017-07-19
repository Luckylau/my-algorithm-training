package chapter1;

import java.util.ArrayList;
import java.util.Arrays;

public class SubsetsII {
	
	public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] nums) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if ( nums.length == 0) {
            result.add(new ArrayList<Integer>());
            return result;
        }
        Arrays.sort(nums);
        Helper(new ArrayList<Integer>() , 0 , nums , result);
        return result;
    }
    private void Helper( ArrayList<Integer> subset , int startIndex , int[] nums , ArrayList<ArrayList<Integer>> result) {
        result.add(new ArrayList<Integer>(subset));
        for (int i  =  startIndex ; i < nums.length ;i++) {
            if ( i != startIndex && nums[i] == nums[i - 1]){
                continue;
            }
            subset.add(nums[i]);
            Helper(subset,i + 1 ,nums , result);
            subset.remove(subset.size() -1);
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[] { 4, 1, 0 };
		SubsetsII SubsetsII = new SubsetsII();
		System.out.println(Arrays.deepToString(SubsetsII.subsetsWithDup(nums).toArray()));

	}

}
