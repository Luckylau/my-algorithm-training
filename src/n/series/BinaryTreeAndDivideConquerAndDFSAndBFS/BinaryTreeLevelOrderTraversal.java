/**
 * Given a binary tree, return the level order traversal of its nodes' values.
 * (ie, from left to right, level by level)
 * Example
 * Given binary tree {3,9,20,#,#,15,7},
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * Challenge 1: Using only 1 queue to implement it.
 * <p>
 * Challenge 2: Use DFS algorithm to do it.
 * <p>
 * return its level order traversal as:
 * <p>
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 */
package n.series.BinaryTreeAndDivideConquerAndDFSAndBFS;

import util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node3 = new TreeNode(9);
        TreeNode node7 = new TreeNode(20);
        TreeNode node5 = new TreeNode(15);
        TreeNode node6 = new TreeNode(7);
        root.left = node3;
        root.right = node7;
        node7.left = node5;
        node7.right = node6;
        BinaryTreeLevelOrderTraversal binaryTreeLevelOrderTraversal = new BinaryTreeLevelOrderTraversal();
        System.out.println(binaryTreeLevelOrderTraversal.levelOrder(root).toString());
        System.out.println(binaryTreeLevelOrderTraversal.levelOrder2(root).toString());

    }

    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        // write your code here
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode tmp = queue.poll();
                list.add(tmp.val);
                if (tmp.left != null) {
                    queue.offer(tmp.left);
                }
                if (tmp.right != null) {
                    queue.offer(tmp.right);
                }
            }
            result.add(list);
        }
        return result;
    }

    public ArrayList<ArrayList<Integer>> levelOrder2(TreeNode root) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        if (root == null) {
            return results;
        }
        int maxLevel = 0;
        while (true) {
            ArrayList<Integer> level = new ArrayList<Integer>();
            dfs(root, level, 0, maxLevel);
            if (level.size() == 0) {
                break;
            }
            results.add(level);
            maxLevel++;
        }
        return results;
    }

    private void dfs(TreeNode root,
                     ArrayList<Integer> level,
                     int curtLevel,
                     int maxLevel) {
        if (root == null) {
            return;
        }
        if (curtLevel == maxLevel) {
            level.add(root.val);
            return;
        }
        dfs(root.left, level, curtLevel + 1, maxLevel);
        dfs(root.right, level, curtLevel + 1, maxLevel);
    }

}
