package n.series.binarytreeanddivideconqueranddfsandbfs;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author luckylau
 * @Date 2022/3/31
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * Example
 * Given binary tree {1,#,2,3},
 * <p>
 * 1
 * \
 * 2
 * /
 * 3
 * return [1,3,2].
 */
public class BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        root.right = node1;
        node1.left = node2;
        BinaryTreeInorderTraversal binaryTreeInorderTraversal = new BinaryTreeInorderTraversal();
        System.out.println(binaryTreeInorderTraversal.inorderTraversal(root));
        System.out.println(binaryTreeInorderTraversal.inorderTraversal2(root));
        System.out.println(binaryTreeInorderTraversal.inorderTraversal3(root));

    }

    //分治思想
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        // write your code here
        ArrayList<Integer> inorder = new ArrayList<Integer>();
        if (root == null) {
            return inorder;
        }

        ArrayList<Integer> left = inorderTraversal(root.left);
        ArrayList<Integer> right = inorderTraversal(root.right);

        inorder.addAll(left);
        inorder.add(root.val);
        inorder.addAll(right);


        return inorder;
    }

    //递归思想
    public ArrayList<Integer> inorderTraversal2(TreeNode root) {
        ArrayList<Integer> inorder = new ArrayList<Integer>();
        traverse(root, inorder);
        return inorder;
    }

    private void traverse(TreeNode root, List<Integer> inorder) {
        if (root == null) {
            return;
        }
        traverse(root.left, inorder);
        inorder.add(root.val);
        traverse(root.right, inorder);

    }

    //非递归思想
    public List<Integer> inorderTraversal3(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                list.add(root.val);
                root = root.right;
            }
        }
        return list;
    }

}
