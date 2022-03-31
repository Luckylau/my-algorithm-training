package n.series.binarytreeanddivideconqueranddfsandbfs;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author luckylau
 * @Date 2022/3/31
 * Given a binary tree, return the postorder traversal of its nodes' values.
 * Example
 * Given binary tree {1,#,2,3},
 * <p>
 * 1
 * \
 * 2
 * /
 * 3
 * return [3,2,1].
 */
public class BinaryTreePostorderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        root.right = node1;
        node1.right = node2;
        BinaryTreePostorderTraversal binaryTreePostorderTraversal = new BinaryTreePostorderTraversal();
        System.out.println(binaryTreePostorderTraversal.postorderTraversal(root).toString());
        System.out.println(binaryTreePostorderTraversal.postorderTraversal2(root).toString());

    }

    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> postorder = new ArrayList<>();
        if (root == null) {
            return postorder;
        }

        ArrayList<Integer> left = postorderTraversal(root.left);
        ArrayList<Integer> right = postorderTraversal(root.right);

        postorder.addAll(left);
        postorder.addAll(right);
        postorder.add(root.val);

        return postorder;

    }

    public ArrayList<Integer> postorderTraversal2(TreeNode root) {
        ArrayList<Integer> preorder = new ArrayList<Integer>();
        traverse(root, preorder);
        return preorder;
    }

    private void traverse(TreeNode root, List<Integer> preorder) {
        if (root == null) {
            return;
        }
        traverse(root.left, preorder);
        traverse(root.right, preorder);
        preorder.add(root.val);
    }

}
