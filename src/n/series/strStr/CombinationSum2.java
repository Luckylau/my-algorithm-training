/**
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 * Each number in C may only be used once in the combination.
 * Notice
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 * The solution set must not contain duplicate combinations.
 */
package n.series.strStr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {

    public static void main(String[] args) {
        int[] candidates = new int[]{2, 3, 6, 7};
        CombinationSum2 CombinationSum2 = new CombinationSum2();
        System.out.println(CombinationSum2.combinationSum2(candidates, 7));

    }

    public List<List<Integer>> combinationSum2(int[] num, int target) {
        List<List<Integer>> results = new ArrayList<>();
        if (num.length == 0 || num == null) {
            return results;
        }
        Arrays.sort(num);
        List<Integer> combination = new ArrayList<Integer>();
        helper(num, 0, target, combination, results);
        return results;
    }

    private void helper(int[] num, int startIndex, int target, List<Integer> combination, List<List<Integer>> results) {
        if (target == 0) {
            results.add(new ArrayList<Integer>(combination));
        }
        for (int i = startIndex; i < num.length; i++) {
            if (num[i] > target) {
                break;
            }
            if (i != startIndex && num[i] == num[i - 1]) {
                continue;
            }
            combination.add(num[i]);
            helper(num, i + 1, target - num[i], combination, results);
            combination.remove(combination.size() - 1);
        }
    }

}
