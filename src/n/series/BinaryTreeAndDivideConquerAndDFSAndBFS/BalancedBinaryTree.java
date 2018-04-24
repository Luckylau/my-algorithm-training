/**
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 * Example
 * Given binary tree A = {3,9,20,#,#,15,7}, B = {3,#,20,15,7}

 *  A)  3            B)    3 
       / \                  \
      9  20                 20
        /  \                / \
       15   7              15  7
 *The binary tree A is a height-balanced binary tree, but B is not.
 * 
 * 
 */
package n.series.BinaryTreeAndDivideConquerAndDFSAndBFS;

public class BalancedBinaryTree {
	
	public boolean isBalanced(TreeNode root) {
        // write your code here
        return maxDepth(root)!= -1;
    }
    
    private int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        if( left == -1 || right == -1 || Math.abs(left - right) > 1 ) {
            return -1;
        }
        return Math.max(left, right)  + 1;
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode node3 = new TreeNode(3);
		TreeNode node9= new TreeNode(9);
		TreeNode node20 = new TreeNode(20);
		TreeNode node15 = new TreeNode(15);
		TreeNode node7 = new TreeNode(7);
		//node3.left = node9;
		node3.right = node20;
		node20.left = node15;
		node20.right = node7;
		BalancedBinaryTree balancedBinaryTree = new BalancedBinaryTree();
		System.out.println(balancedBinaryTree.isBalanced(node3));
	}

}
