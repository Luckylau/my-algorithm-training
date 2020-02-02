package l.series;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author luckylau
 * @Date 2020/2/2
 */
public class CombinationSum3 {
    public static void main(String[] args) {
        CombinationSum3 combinationSum3 = new CombinationSum3();
        System.out.println(Arrays.deepToString(combinationSum3.combinationSum3(2, 10).toArray()));
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> sub = new ArrayList<>();
        backtracking(res, sub, k, n, 1);
        return res;

    }

    private void backtracking(List<List<Integer>> res, List<Integer> sub, int k, int n, int start) {
        if (k == 0 && n == 0) {
            res.add(new ArrayList<>(sub));
            return;
        }
        if (k == 0 || n == 0) {
            return;
        }
        for (int i = start; i <= 9; i++) {
            sub.add(i);
            backtracking(res, sub, k - 1, n - i, i + 1);
            sub.remove(sub.size() - 1);
        }
    }
}
