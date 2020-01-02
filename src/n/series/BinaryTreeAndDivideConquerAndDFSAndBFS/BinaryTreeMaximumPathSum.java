/**
 * Given a binary tree, find the maximum path sum.
 * The path may start and end at any node in the tree.
 * Example
 * Given the below binary tree:
 * 1
 * / \
 * 2   3
 * return 6.
 */
package n.series.BinaryTreeAndDivideConquerAndDFSAndBFS;

import util.TreeNode;

public class BinaryTreeMaximumPathSum {

    public static void main(String[] args) {
        TreeNode node15 = new TreeNode(-15);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node8 = new TreeNode(-8);
        TreeNode node1 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        TreeNode node9 = new TreeNode(9);
        TreeNode node2 = new TreeNode(2);
        TreeNode node66 = new TreeNode(6);
        TreeNode node0 = new TreeNode(0);
        TreeNode node4 = new TreeNode(4);
        TreeNode node11 = new TreeNode(-1);
        TreeNode node10 = new TreeNode(10);
        node15.left = node5;
        node15.right = node6;
        node5.left = node8;
        node5.right = node1;
        node8.left = node2;
        node8.right = node66;
        node6.left = node3;
        node6.right = node9;
        node9.right = node0;
        node0.left = node4;
        node0.right = node11;
        node11.left = node10;
        BinaryTreeMaximumPathSum binaryTreeMaximumPathSum = new BinaryTreeMaximumPathSum();
        System.out.println(binaryTreeMaximumPathSum.maxPathSum(node15));
    }

    public int maxPathSum(TreeNode root) {
        // write your code here
        ResultType result = maxPathSumhelper(root);
        return result.maxPath;

    }

    private ResultType maxPathSumhelper(TreeNode root) {
        if (root == null) {
            return new ResultType(0, Integer.MIN_VALUE);
        }
        ResultType left = maxPathSumhelper(root.left);
        ResultType right = maxPathSumhelper(root.right);

        int singlePath = Math.max(left.singlePath, right.singlePath) + root.val;
        singlePath = Math.max(singlePath, 0);
        int maxPath = Math.max(left.maxPath, right.maxPath);
        maxPath = Math.max(maxPath, right.singlePath + left.singlePath + root.val);
        return new ResultType(singlePath, maxPath);

    }

    static class ResultType {
        int singlePath;//root to any
        int maxPath;//any to any

        public ResultType(int singlePath, int maxPath) {
            this.singlePath = singlePath;
            this.maxPath = maxPath;
        }
    }
}

