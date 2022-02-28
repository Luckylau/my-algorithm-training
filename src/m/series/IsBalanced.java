package m.series;

import util.TreeNode;

/**
 * 110. 平衡二叉树
 *
 * @Author luckylau
 * @Date 2022/2/28
 */
public class IsBalanced {
    public boolean isBalanced(TreeNode root) {
        return maxDepth(root) != -1;
    }

    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        if (left == -1 || right == -1 || Math.abs(right - left) > 1) {
            return -1;
        }
        return Math.max(left, right) + 1;
    }
}
