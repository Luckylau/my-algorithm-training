package m.series;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 113. 路径总和 II
 *
 * @Author luckylau
 * @Date 2022/5/8
 */
public class PathSum {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> sub = new ArrayList<>();
        dfs(list, sub, root, targetSum);
        return list;
    }

    private void dfs(List<List<Integer>> list, List<Integer> sub, TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }
        sub.add(root.val);
        targetSum -= root.val;
        if (targetSum == 0 && root.left == null && root.right == null) {
            list.add(new ArrayList<>(sub));
        }
        dfs(list, sub, root.left, targetSum);
        dfs(list, sub, root.right, targetSum);
        sub.remove(sub.size() - 1);
    }
}
