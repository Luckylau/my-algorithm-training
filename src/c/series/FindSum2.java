package c.series;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 从1到n中找出所有等于sum的组合，并输出
 */
public class FindSum2 {

    public static void main(String[] args) {
        FindSum2 findSum2 = new FindSum2();
        System.out.println(Arrays.deepToString(findSum2.findSum2(4, 6).toArray()));

    }

    public List<List<Integer>> findSum2(int sum, int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<>();
        helper(sum, n, list, res);
        return res;
    }

    private void helper(int sum, int n, List<Integer> list, List<List<Integer>> res) {
        if (sum == 0) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        if (sum < 0 || n <= 0) {
            return;
        }
        list.add(n);
        helper(sum - n, n - 1, list, res);
        list.remove(list.size() - 1);
        helper(sum, n - 1, list, res);

    }

}
