/**
 * Given a list of numbers, return all possible permutations.
 * Example
 * For nums = [1,2,3], the permutations are:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 * Challenge 
 * Do it without recursion.
 */
package chapter1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
	
	public List<List<Integer>> permute(int[] nums) {
        // write your code here
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> sub = new ArrayList<Integer>();
        Helper(sub ,nums , result);
        return result;
    }
    private void Helper(List<Integer> sub , int[]nums ,List<List<Integer>> result) {
        if (sub.size() == nums.length) {
            result.add(new ArrayList<Integer>(sub));
        }
        for (int i = 0 ; i < nums.length; i++) {
            if(sub.contains(nums[i])){
                continue;
            }
            sub.add(nums[i]);
            Helper(sub, nums , result);
            sub.remove(sub.size() - 1);
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[] { 4, 1, 0 };
		Permutations Permutations = new Permutations();
		System.out.println(Arrays.deepToString(Permutations.permute(nums).toArray()));

	}

}
