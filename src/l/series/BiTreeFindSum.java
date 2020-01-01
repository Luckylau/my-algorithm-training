package l.series;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 题目一：从二叉树找到和为某个值的所有结果；
 * 题目二：判断二叉树是否存在和为某个值的路径；
 */
public class BiTreeFindSum {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode TreeNode1 = new TreeNode(6);
        TreeNode TreeNode2 = new TreeNode(5);
        TreeNode TreeNode3 = new TreeNode(4);
        TreeNode TreeNode4 = new TreeNode(8);
        TreeNode TreeNode5 = new TreeNode(5);
        TreeNode TreeNode6 = new TreeNode(2);
        TreeNode TreeNode7 = new TreeNode(3);
        root.left = TreeNode1;
        root.right = TreeNode2;
        TreeNode1.left = TreeNode3;
        TreeNode1.right = TreeNode4;
        TreeNode2.left = TreeNode5;
        TreeNode2.right = TreeNode6;
        TreeNode6.right = TreeNode7;
        BiTreeFindSum biTreeFindSum = new BiTreeFindSum();
        System.out.println(Arrays.deepToString(biTreeFindSum.findSumfromBiTree(root, 20).toArray()));
        System.out.println(biTreeFindSum.hasPathSum(root, 20));

    }

    public List<List<Integer>> findSumfromBiTree(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }
        helper(root, list, res, sum);
        return res;
    }

    private void helper(TreeNode root, List<Integer> list, List<List<Integer>> res, int sum) {
        list.add(root.val);
        sum -= root.val;
        if (root.left == null && root.right == null && sum == 0) {
            res.add(new ArrayList<Integer>(list));
        }
        if (root.left != null) {
            helper(root.left, list, res, sum);
        }

        if (root.right != null) {
            helper(root.right, list, res, sum);
        }

        list.remove(list.size() - 1);
        sum += root.val;

    }

    public Boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null && sum == root.val) {
            return true;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

}
