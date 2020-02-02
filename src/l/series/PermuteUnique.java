package l.series;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author luckylau
 * @Date 2020/2/2
 */
public class PermuteUnique {
    public static void main(String[] args) {
        int[] nums = {3, 3, 0, 3};
        PermuteUnique permuteUnique = new PermuteUnique();
        System.out.println(Arrays.deepToString(permuteUnique.permuteUnique(nums).toArray()));
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        boolean[] isVisited = new boolean[nums.length];
        List<Integer> sub = new ArrayList<>();
        backtracking(res, sub, nums, isVisited);
        return res;
    }

    private void backtracking(List<List<Integer>> res, List<Integer> sub, int[] nums, boolean[] isVisited) {
        if (sub.size() == nums.length) {
            res.add(new ArrayList<>(sub));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (isVisited[i] || (i != 0 && nums[i] == nums[i - 1] && isVisited[i - 1])) {
                continue;
            }
            isVisited[i] = true;
            sub.add(nums[i]);
            backtracking(res, sub, nums, isVisited);
            sub.remove(sub.size() - 1);
            isVisited[i] = false;
        }
    }
}
