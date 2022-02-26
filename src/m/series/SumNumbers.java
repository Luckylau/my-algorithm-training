package m.series;

import util.TreeNode;

/**
 * 129. 求根节点到叶节点数字之和
 *
 * @Author luckylau
 * @Date 2022/2/26
 */
public class SumNumbers {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int preSum) {
        if (root == null) {
            return 0;
        }
        int sum = preSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        } else {
            return dfs(root.left, sum) + dfs(root.right, sum);
        }
    }
}
