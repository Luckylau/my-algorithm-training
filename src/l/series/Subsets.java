package l.series;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author luckylau
 * @Date 2020/2/4
 */
public class Subsets {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Subsets subsets = new Subsets();
        System.out.println(Arrays.deepToString(subsets.subsets(nums).toArray()));
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        List<Integer> sub = new ArrayList<>();
        for (int size = 0; size <= nums.length; size++) {
            backtracking(size, 0, res, sub, nums);
        }
        return res;
    }

    private void backtracking(int size, int start, List<List<Integer>> res, List<Integer> sub, int[] nums) {
        if (size == sub.size()) {
            res.add(new ArrayList<>(sub));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            sub.add(nums[i]);
            backtracking(size, i + 1, res, sub, nums);
            sub.remove(sub.size() - 1);
        }
    }
}
