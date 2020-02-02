package l.series;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author luckylau
 * @Date 2020/2/2
 */
public class CombinationSum2 {
    public static void main(String[] args) {
        int[] candidates = new int[]{10, 1, 2, 7, 6, 1, 5};
        CombinationSum2 combinationSum2 = new CombinationSum2();
        System.out.println(combinationSum2.combinationSum2(candidates, 8));
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        Arrays.sort(candidates);
        boolean[] isVisited = new boolean[candidates.length];
        List<Integer> sub = new ArrayList<>();
        combination(res, sub, isVisited, candidates, 0, target);
        return res;
    }

    private void combination(List<List<Integer>> res, List<Integer> sub, boolean[] isVisited, int[] candidates, int start, int target) {
        if (target == 0) {
            res.add(new ArrayList<>(sub));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (i != start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            if (candidates[i] <= target) {
                sub.add(candidates[i]);
                isVisited[i] = true;
                combination(res, sub, isVisited, candidates, i + 1, target - candidates[i]);
                sub.remove(sub.size() - 1);
                isVisited[i] = false;
            }
        }
    }
}
