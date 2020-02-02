package l.series;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author luckylau
 * @Date 2020/2/2
 */
public class CombinationSum {
    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        CombinationSum combinationSum = new CombinationSum();
        System.out.println(Arrays.deepToString(combinationSum.combinationSum(candidates, 7).toArray()));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        List<Integer> sub = new ArrayList<>();
        combination(candidates, 0, target, res, sub);
        return res;

    }

    private void combination(int[] candidates, int start, int target, List<List<Integer>> res, List<Integer> sub) {
        if (target == 0) {
            res.add(new ArrayList<>(sub));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                sub.add(candidates[i]);
                combination(candidates, i, target - candidates[i], res, sub);
                sub.remove(sub.size() - 1);
            }
        }
    }
}
