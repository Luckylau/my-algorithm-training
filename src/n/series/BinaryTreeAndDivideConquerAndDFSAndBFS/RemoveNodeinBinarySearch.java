package n.series.BinaryTreeAndDivideConquerAndDFSAndBFS;

import util.TreeNode;

public class RemoveNodeinBinarySearch {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(7);
        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;
        BinaryTreeLevelOrderTraversal binaryTreeLevelOrderTraversal = new BinaryTreeLevelOrderTraversal();
        System.out.println(binaryTreeLevelOrderTraversal.levelOrder2(root).toString());
        RemoveNodeinBinarySearch removeNodeinBinarySearch = new RemoveNodeinBinarySearch();
        removeNodeinBinarySearch.removeNode(root, 4);
        System.out.println(binaryTreeLevelOrderTraversal.levelOrder2(root).toString());

    }

    public TreeNode removeNode(TreeNode root, int value) {
        // write your code here
        TreeNode dummy = new TreeNode(-1);
        dummy.left = root;

        TreeNode parent = findNode(dummy, root, value);
        TreeNode tmp;
        if (parent.left != null && parent.left.val == value) {
            tmp = parent.left;
        } else if (parent.right != null && parent.right.val == value) {
            tmp = parent.right;
        } else {
            return dummy.left;
        }

        deleteNode(parent, tmp);
        return dummy.left;
    }

    private TreeNode findNode(TreeNode parent, TreeNode node, int value) {
        if (node == null) {
            return parent;
        }
        if (node.val == value) {
            return parent;
        }

        if (node.val > value) {
            return findNode(node, node.left, value);
        } else {
            return findNode(node, node.right, value);
        }
    }

    private void deleteNode(TreeNode parent, TreeNode node) {
        if (node.right == null) {
            if (parent.left == node) {
                parent.left = node.left;
            } else {
                parent.right = node.left;
            }
        } else {
            TreeNode father = node;
            TreeNode tmp = node.right;
            while (tmp.left != null) {
                father = tmp;
                tmp = tmp.left;
            }

            if (father.left == tmp) {
                father.left = tmp.right;
            } else {
                father.right = tmp.right;
            }

            if (parent.left == node) {
                parent.left = tmp;
            } else {
                parent.right = tmp;
            }

            tmp.left = node.left;
            tmp.right = node.right;
        }
    }

}
