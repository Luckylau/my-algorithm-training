/**
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. 
 * (ie, from left to right, then right to left for the next level and alternate between).
 * Example
 * Given binary tree {3,9,20,#,#,15,7},
 *   3
 *  / \
 * 9  20
 *   /  \
 *  15   7
 * return its zigzag level order traversal as:
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 * 
 */
package n.series.BinaryTreeAndDivideConquerAndDFSAndBFS;

import java.util.ArrayList;
import java.util.Stack;

public class BinaryTreeZigzagLevel {
	
	 public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
	        // write your code here
	        ArrayList<ArrayList<Integer>> result =new ArrayList<ArrayList<Integer>>();
	        if (root == null) {
	            return result;
	        }
	        boolean flag =true;
	        Stack<TreeNode> currentlevel = new Stack<TreeNode>();
	        Stack<TreeNode> nextlevel = new Stack<TreeNode>();
	        Stack<TreeNode> tmplevel;
	        currentlevel.push(root);
	        while ( !currentlevel.isEmpty()) {
	            ArrayList<Integer> list = new ArrayList<Integer>();
	            while(!currentlevel.isEmpty()) {
	                TreeNode tmp = currentlevel.pop();
	                list.add(tmp.val);
	                if(flag){
	                	if(tmp.left !=null) {
	                        nextlevel.push(tmp.left);
	                    }
	                	if(tmp.right !=null) {
	                        nextlevel.push(tmp.right);
	                    }
	                }else{
	                	if(tmp.right !=null) {
	                        nextlevel.push(tmp.right);
	                    }
	                	if(tmp.left !=null) {
	                        nextlevel.push(tmp.left);
	                    }
	                }   
	            }
	            result.add(list);
	            tmplevel = currentlevel;
	            currentlevel = nextlevel;
	            nextlevel = tmplevel;
	            flag=!flag;
	        }
	        return result;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);
		TreeNode node8 = new TreeNode(8);
		root.left = node2;
		root.right = node3;
		node2.left=node4;
		node3.right=node5;
		node4.left=node6;
		node4.right=node7;
		node7.right=node8;
		BinaryTreeZigzagLevel binaryTreeZigzagLevel =new BinaryTreeZigzagLevel();
		System.out.println(binaryTreeZigzagLevel.zigzagLevelOrder(root));

	}

}
