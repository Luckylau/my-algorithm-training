/**
 * Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 * The same repeated number may be chosen from C unlimited number of times.
 * Example
 * Given candidate set [2,3,6,7] and target 7, a solution set is:
 * [7]
 * [2, 2, 3]
 * Notice
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 * The solution set must not contain duplicate combinations.
 * 
 * 
 */
package chapter1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // write your code here
        List<List<Integer>>  result = new ArrayList<>();
        if(candidates.length == 0 || candidates == null){
            return result;
        }
        List<Integer> combination = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates, 0, target, combination, result);
        return result;
    }
    private void helper(int[] candidates,int index,int target,List<Integer> combination,
        List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<Integer>(combination));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] > target) {
                break;
            }
            if( i !=index && candidates[i] == candidates[i - 1]){
                continue;
            }
            combination.add(candidates[i]);
            helper(candidates, i, target - candidates[i], combination, result);
            combination.remove(combination.size() - 1);
        }
    }

	public static void main(String[] args) {
		int[] candidates = new int[]{2,2,3};
		CombinationSum combinationSum = new CombinationSum();
		System.out.println(combinationSum.combinationSum(candidates, 7));

	}

}
