/**
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * Example
 * Given:
 *    1
 *   / \
 *  2   3
   / \
 *4   5
 *return [1,2,4,5,3].
 */

package n.series.BinaryTreeAndDivideConquerAndDFSAndBFS;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal {
	
	//1
	 public ArrayList<Integer> preorderTraversal(TreeNode root) {
	        // write your code here
	        Stack<TreeNode> stack = new Stack<TreeNode>();
	        ArrayList<Integer> preorder = new ArrayList<Integer>();
	        
	        if (root == null) {
	             return preorder;
	        }
	        stack.push(root);
	        while(!stack.empty()) { 
	            TreeNode node = stack.pop();
	            preorder.add(node.val);
	            if (node.right != null) {
	                stack.push(node.right);
	            }
	            if (node.left !=null) {
	                stack.push(node.left);
	            }
	        }
	        return preorder;    
	            
	    }
	 
	 //2
	 public ArrayList<Integer> preorderTraversal2(TreeNode root) {
	        // write your code here
	        ArrayList<Integer> preorder = new ArrayList<Integer>();
	        traverse(root,preorder);
	        return preorder;
	    }
	    
	 private void traverse(TreeNode root ,List<Integer> preorder) {
	        if ( root == null ) {
	            return;
	        }
	        preorder.add(root.val);
	        traverse (root.left , preorder);
	        traverse (root.right ,preorder);
	    }
	 
	 //3
	 public ArrayList<Integer> preorderTraversal3(TreeNode root) {
	        // write your code here
	        ArrayList<Integer> preorder = new ArrayList<Integer>();
	        if ( root == null) {
	            return preorder;
	        }
	        
	        ArrayList<Integer> left = preorderTraversal(root.left);
	        ArrayList<Integer> right = preorderTraversal(root.right);
	        
	        preorder.add(root.val);
	        preorder.addAll(left);
	        preorder.addAll(right);
	        return preorder;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		TreeNode node1 = new TreeNode(2);
		TreeNode node2 = new TreeNode(3);
		TreeNode node3 = new TreeNode(4);
		TreeNode node4 = new TreeNode(5);
		root.left = node1;
		root.right = node2;
		node1.left = node3;
		node1.right = node4;
		BinaryTreePreorderTraversal binaryTreePreorderTraversal = new BinaryTreePreorderTraversal();
		System.out.println(binaryTreePreorderTraversal.preorderTraversal(root).toString());
		System.out.println(binaryTreePreorderTraversal.preorderTraversal2(root).toString());
		System.out.println(binaryTreePreorderTraversal.preorderTraversal3(root).toString());
		

	}

}
