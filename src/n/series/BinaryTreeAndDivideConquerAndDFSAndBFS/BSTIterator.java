package n.series.BinaryTreeAndDivideConquerAndDFSAndBFS;
/**
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
 * Calling next() will return the next smallest number in the BST.
 * Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
 */

import util.TreeNode;

import java.util.Stack;

public class BSTIterator {
    private Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public int next() {
        TreeNode curr = stack.pop();
        int res = curr.val;
        while (curr.right != null) {
            curr = curr.right;
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

        }
        return res;
    }

}
