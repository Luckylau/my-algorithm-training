package n.series.strstr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author luckylau
 * @Date 2022/3/31
 * Given a list of numbers with duplicate number in it. Find all unique permutations.
 * Example
 * For numbers [1,2,2] the unique permutations are:
 * [
 * [1,2,2],
 * [2,1,2],
 * [2,2,1]
 * ]
 */
public class PermutationsII {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 0};
        PermutationsII Permutations = new PermutationsII();
        System.out.println(Arrays.deepToString(Permutations.permuteUnique(nums).toArray()));

    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        // Write your code here
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums.length == 0) {
            result.add(new ArrayList<>());
            return result;
        }
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        List<Integer> sub = new ArrayList<Integer>();
        Helper(nums, visited, sub, result);
        return result;
    }

    private void Helper(int[] nums, boolean[] visited, List<Integer> sub, List<List<Integer>> result) {
        if (nums.length == sub.size()) {
            result.add(new ArrayList<>(sub));
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] || (i != 0 && nums[i] == nums[i - 1] && !visited[i - 1])) {
                continue;
            }
            visited[i] = true;
            sub.add(nums[i]);
            Helper(nums, visited, sub, result);
            sub.remove(sub.size() - 1);
            visited[i] = false;
        }
    }

}
