/**
 * Given two values k1 and k2 (where k1 < k2) and a root pointer to a Binary Search Tree. 
 * Find all the keys of tree in range k1 to k2. i.e. print all x such that k1<=x<=k2 and x is a key of given BST. Return all the keys in ascending order.
 * 
 * 
 */
package chapter3;

import java.util.ArrayList;

public class SearchRangeinaBinary {
	
	private ArrayList<Integer> result;
    public ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
        // write your code here
        result = new ArrayList<Integer>();
        searchHelper(root,k1,k2);
        return result;
    }
    private void searchHelper(TreeNode root, int k1,int k2) {
        if(root ==null){
            return;
        }
        
        if(root.val >k1) {
            searchHelper(root.left,k1,k2);
        }
        
         if(root.val >= k1 && root.val <=k2) {
            result.add(root.val);
        }
        
        if(root.val <k2) {
             searchHelper(root.right,k1,k2);
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(2);
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(4);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(7);
		root.left = node1;
		root.right = node2;
		node2.left = node3;
		node2.right = node4;
		
		SearchRangeinaBinary searchRangeinaBinary  = new SearchRangeinaBinary();
		System.out.println(searchRangeinaBinary.searchRange(root, 2, 7));

	}

}
