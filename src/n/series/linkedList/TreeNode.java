package n.series.linkedlist;

import java.util.ArrayList;

public class TreeNode {

    public int val;
    public TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }

    public static ArrayList<ArrayList<Integer>> printTreeNodebylevelOrder(TreeNode root) {
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

    private static void dfs(TreeNode root,
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

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TreeNode root = new TreeNode(3);
        TreeNode node3 = new TreeNode(9);
        TreeNode node7 = new TreeNode(20);
        TreeNode node5 = new TreeNode(15);
        TreeNode node6 = new TreeNode(7);
        root.left = node3;
        root.right = node7;
        node7.left = node5;
        node7.right = node6;
        System.out.println(TreeNode.printTreeNodebylevelOrder(root));

    }

    @Override
    public String toString() {
        return this.val + "";
    }

}
