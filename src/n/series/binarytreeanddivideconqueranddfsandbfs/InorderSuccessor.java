
package n.series.binarytreeanddivideconqueranddfsandbfs;

import util.TreeNode;

import java.util.Stack;

/**
 * @Author luckylau
 * @Date 2022/3/31
 * Given a binary search tree and a node in it, find the in-order successor of that node in the BST.
 * Note: If the given node has no in-order successor in the tree, return null.
 */
public class InorderSuccessor {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(6);
        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;
        BinaryTreeInorderTraversal binaryTreeInorderTraversal = new BinaryTreeInorderTraversal();
        System.out.println(binaryTreeInorderTraversal.inorderTraversal(root));
        InorderSuccessor inorderSuccessor = new InorderSuccessor();
        System.out.println(inorderSuccessor.inorderSuccessor(root, node3));

    }

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode tmp = root;
        while (tmp != p) {
            stack.push(tmp);
            if (tmp.val > p.val) {
                tmp = tmp.left;
            } else {
                tmp = tmp.right;
            }
        }
        if (tmp.right != null) {
            tmp = tmp.right;
            while (tmp.left != null) {
                tmp = tmp.left;
            }
            return tmp;
        } else {
            while (!stack.isEmpty() && stack.peek().val < tmp.val) {
                stack.pop();
            }
            return stack.isEmpty() ? null : stack.pop();
        }
    }

}
