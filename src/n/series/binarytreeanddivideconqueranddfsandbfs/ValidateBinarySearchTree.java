/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * Assume a BST is defined as follows:
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * A single node tree is a BST
 * Example
 * An example:
 * 2
 * /   \
 * 1     4
 * \   / \
 * 9 3   5
 */
package n.series.binarytreeanddivideconqueranddfsandbfs;

import util.TreeNode;

public class ValidateBinarySearchTree {

    public static void main(String[] args) {
        TreeNode node2 = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);
        TreeNode node4 = new TreeNode(4);
        TreeNode node3 = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
        TreeNode node9 = new TreeNode(9);
        node2.left = node1;
        node1.right = node9;
        node2.right = node4;
        node4.left = node3;
        node4.right = node5;
        ValidateBinarySearchTree validateBinarySearchTree = new ValidateBinarySearchTree();
        System.out.println(validateBinarySearchTree.validBST(node2));

    }

    public boolean validBST(TreeNode root) {
        ResultType resultType = validheper(root);
        return resultType.isBST;
    }

    private ResultType validheper(TreeNode root) {
        if (root == null) {
            return new ResultType(true, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
        ResultType left = validheper(root.left);
        ResultType right = validheper(root.right);
        if (!left.isBST || !right.isBST) {
            return new ResultType(false, 0, 0);
        }
        if (root.left != null && left.maxValue >= root.val ||
                root.right != null && right.minValue <= root.val) {
            return new ResultType(false, 0, 0);
        }
        return new ResultType(true, Math.max(root.val, right.maxValue), Math.min(root.val, left.minValue));
    }
}

class ResultType {
    boolean isBST;
    int maxValue, minValue;

    public ResultType(boolean isBST, int maxValue, int minValue) {
        this.isBST = isBST;
        this.maxValue = maxValue;
        this.minValue = minValue;
    }

}
