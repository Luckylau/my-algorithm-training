package m.series;

import util.TreeNode;

/**
 * 二叉树中的最大路径和
 *
 * @Author luckylau
 * @Date 2021/4/15
 */
public class MaxPathSum {
    private int sum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        getMax(root);
        return sum;
    }

    private int getMax(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int maxleft = Math.max(getMax(node.left), 0);
        int maxRight = Math.max(getMax(node.right), 0);

        sum = Math.max(sum, node.val + maxRight + maxleft);

        return node.val + Math.max(maxleft, maxRight);
    }
}
