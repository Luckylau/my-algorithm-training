/**
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * Example
 * Given binary tree {1,#,2,3},
 * 
 * 1
 *  \
 *   2
 *  /
 * 3
 *return [1,3,2].
 * 
 * 
 * 
 */
package chapter3;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {
	
	 public ArrayList<Integer> inorderTraversal(TreeNode root) {
	        // write your code here
	        ArrayList<Integer> inorder = new ArrayList<Integer>();
	        if ( root == null) {
	            return inorder;
	        }
	        
	        ArrayList<Integer> left = inorderTraversal(root.left);
	        ArrayList<Integer> right = inorderTraversal(root.right);
	        
	        inorder.addAll(left);
	        inorder.add(root.val);
	        inorder.addAll(right);
	        
	        
	        return inorder;
	    }
	 
	 public ArrayList<Integer> inorderTraversal2(TreeNode root) {
	        ArrayList<Integer> inorder = new ArrayList<Integer>();
		        traverse(root,inorder);
		        return inorder;
		    }
		    
		 private void traverse(TreeNode root ,List<Integer> inorder) {
		        if ( root == null ) {
		            return;
		        }
		        traverse (root.left , inorder);
		        inorder.add(root.val);
		        traverse (root.right ,inorder);
		        
		    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		TreeNode node1 = new TreeNode(2);
		TreeNode node2 = new TreeNode(3);
		root.right = node1;
		node1.left = node2;
		BinaryTreeInorderTraversal binaryTreeInorderTraversal = new BinaryTreeInorderTraversal();
		System.out.println(binaryTreeInorderTraversal.inorderTraversal(root));
		System.out.println(binaryTreeInorderTraversal.inorderTraversal2(root));

	}

}
