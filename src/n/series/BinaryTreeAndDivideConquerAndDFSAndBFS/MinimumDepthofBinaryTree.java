package n.series.BinaryTreeAndDivideConquerAndDFSAndBFS;
/**
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path
 * from the root node down to the nearest leaf node.
 * Example
 * Given a binary tree as follow:
 *     1
 *    / \
 *   2   3
 *  / \
 * 4   5
 * The maximum depth is 2.
 *
 *
 */
public class MinimumDepthofBinaryTree {

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

        MinimumDepthofBinaryTree minimumDepthofBinaryTree = new MinimumDepthofBinaryTree();
        System.out.println(minimumDepthofBinaryTree.getMin(root));

    }

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return getMin(root);
    }

    private int getMin(TreeNode root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int left = getMin(root.left);
        int right = getMin(root.right);
        return Math.min(left, right) + 1;
    }

}
