package l.series;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author luckylau
 * @Date 2020/2/4
 */
public class SubsetsWithDup {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        SubsetsWithDup subsetsWithDup = new SubsetsWithDup();
        System.out.println(Arrays.deepToString(subsetsWithDup.subsetsWithDup(nums).toArray()));
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return subsets;
        }
        Arrays.sort(nums);
        List<Integer> tempSubset = new ArrayList<>();
        for (int size = 0; size <= nums.length; size++) {
            backtracking(0, tempSubset, subsets, size, nums);
        }
        return subsets;
    }

    private void backtracking(int start, List<Integer> tempSubset, List<List<Integer>> subsets, final int size, final int[] nums) {

        if (tempSubset.size() == size) {
            subsets.add(new ArrayList<>(tempSubset));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (i != start && nums[i] == nums[i - 1]) {
                continue;
            }
            tempSubset.add(nums[i]);
            backtracking(i + 1, tempSubset, subsets, size, nums);
            tempSubset.remove(tempSubset.size() - 1);
        }
    }
}
