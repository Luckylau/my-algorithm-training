package l.series;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author luckylau
 * @Date 2020/2/1
 */
public class Permute {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Permute permute = new Permute();
        System.out.println(Arrays.deepToString(permute.permute(nums).toArray()));
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        List<Integer> sub = new ArrayList<>();
        boolean[] isVisited = new boolean[nums.length];
        backtracking(sub, result, nums, isVisited);
        return result;
    }

    private void backtracking(List<Integer> sub, List<List<Integer>> result, int[] nums, boolean[] isVisited) {
        if (sub.size() == nums.length) {
            result.add(new ArrayList<>(sub));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (isVisited[i]) {
                continue;
            }
            isVisited[i] = true;
            sub.add(nums[i]);
            backtracking(sub, result, nums, isVisited);
            sub.remove(sub.size() - 1);
            isVisited[i] = false;
        }
    }
}
