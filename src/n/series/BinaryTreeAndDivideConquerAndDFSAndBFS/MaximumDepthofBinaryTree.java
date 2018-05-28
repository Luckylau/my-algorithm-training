package n.series.BinaryTreeAndDivideConquerAndDFSAndBFS;
/**
 * Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the
 * longest path from the root node down to the farthest leaf node.
 * Example
 * Given a binary tree as follow:
 *     1
 *    / \
 *   2   3
 *  / \
 * 4   5
 * The maximum depth is 3.
 *
 */
public class MaximumDepthofBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        MaximumDepthofBinaryTree maximumDepthofBinaryTree = new MaximumDepthofBinaryTree();
        System.out.println(maximumDepthofBinaryTree.maxDepth(root));


    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }

}
