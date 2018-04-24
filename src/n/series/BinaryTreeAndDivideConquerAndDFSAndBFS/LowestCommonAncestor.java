/**
 * 
 * Given the root and two nodes in a Binary Tree. Find the lowest common ancestor(LCA) of the two nodes.
 * The lowest common ancestor is the node with largest depth which is the ancestor of both nodes.
 * Example
 * For the following binary tree:
 *  4
 * / \
 *3   7
 *   / \
 *  5   6
 * LCA(3, 5) = 4
 * LCA(5, 6) = 7
 * LCA(6, 7) = 7
 * 
 */
package n.series.BinaryTreeAndDivideConquerAndDFSAndBFS;

public class LowestCommonAncestor {
	
	 public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
	        // write your code here
	        if (root == null || root == A || root == B) {
	            return root;
	        }
	        
	        TreeNode left = lowestCommonAncestor(root.left,A,B);
	        TreeNode right = lowestCommonAncestor(root.right,A,B);
	        
	        if (left  != null && right != null ) {
	            return root;
	        }
	        
	        if (left != null) {
	            return left;
	        }
	        
	        if (right != null) {
	            return right;
	        }
	        
	        return null;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root =new TreeNode(4);
		TreeNode node3 = new TreeNode(3);
		TreeNode node7 = new TreeNode(7);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		root.left = node3;
		root.right= node7;
		node7.left = node5;
		node7.right =node6;
		LowestCommonAncestor lowestommonAncestor =new LowestCommonAncestor();
		System.out.println(lowestommonAncestor.lowestCommonAncestor(root, node5, node6));

	}

}
