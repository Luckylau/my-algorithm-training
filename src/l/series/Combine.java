package l.series;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author luckylau
 * @Date 2020/2/2
 */
public class Combine {
    public static void main(String[] args) {
        Combine combine = new Combine();
        System.out.println(Arrays.deepToString(combine.combine(6, 2).toArray()));
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (n < 1) {
            return result;
        }
        List<Integer> sub = new ArrayList<>();
        backtracking(sub, result, 1, n, k);
        return result;
    }

    private void backtracking(List<Integer> sub, List<List<Integer>> result, int start, int n, int k) {
        if (sub.size() == k) {
            result.add(new ArrayList<>(sub));
            return;
        }
        for (int i = start; i <= n; i++) {
            sub.add(i);
            backtracking(sub, result, i + 1, n, k);
            sub.remove(sub.size() - 1);
        }
    }
}
