/**
 * Given a binary tree, return the postorder traversal of its nodes' values.
 * Example
 * Given binary tree {1,#,2,3},
 *
 * 1
 *  \
 *   2
 *   /
 *  3
 * return [3,2,1].
 */
package chapter3;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePostorderTraversal {
	
	public ArrayList<Integer> postorderTraversal(TreeNode root) {
        // write your code here
        ArrayList<Integer> postorder = new ArrayList<Integer>();
        if ( root == null) {
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
	        traverse(root,preorder);
	        return preorder;
	    }
	    
	 private void traverse(TreeNode root ,List<Integer> preorder) {
	        if ( root == null ) {
	            return;
	        }
	        traverse (root.left , preorder);
	        traverse (root.right ,preorder);
	        preorder.add(root.val);
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		TreeNode node1 = new TreeNode(2);
		TreeNode node2 = new TreeNode(3);
		root.right = node1;
		node1.right = node2;
		BinaryTreePostorderTraversal binaryTreePostorderTraversal = new BinaryTreePostorderTraversal();
		System.out.println(binaryTreePostorderTraversal.postorderTraversal(root).toString());
		System.out.println(binaryTreePostorderTraversal.postorderTraversal2(root).toString());

	}

}
