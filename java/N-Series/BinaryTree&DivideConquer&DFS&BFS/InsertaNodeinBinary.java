/**
 * Given a binary search tree and a new tree node, insert the node into the tree. 
 * You should keep the tree still be a valid binary search tree.
 * Example
 * Given binary search tree as follow, after Insert node 6, the tree should be:
 *  2             2
 * / \           / \
 *1   4   -->   1   4
 *   /             / \ 
 *  3             3   6
 * 
 */

package chapter3;

public class InsertaNodeinBinary {
	
	public TreeNode insertNode(TreeNode root, TreeNode node) {
        // write your code here
        if( root == null ) {
            return node;
        }
        if(root.val > node.val){
            root.left = insertNode(root.left,node);
        }else {
            root.right = insertNode(root.right,node);
        }
        return root;
    }
	
	public TreeNode insertNode2(TreeNode root, TreeNode node) {
        // write your code here
        if(root == null){
            root = node;
            return root;
        }
        TreeNode tmp = root;
        TreeNode last = null;
        while(tmp != null){
            last = tmp;
            if(tmp.val > node.val){
                tmp = tmp.left;
            }else{
                tmp = tmp.right;
            }
        }
        
        if(last.val > node.val){
            last.left = node;
        }else {
            last.right =node;
        }
        return root;
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(2);
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(4);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(6);
		root.left = node1;
		root.right = node2;
		node2.left = node3;
		BinaryTreeLevelOrderTraversal binaryTreeLevelOrderTraversal = new BinaryTreeLevelOrderTraversal();
		System.out.println(binaryTreeLevelOrderTraversal.levelOrder(root).toString());
		InsertaNodeinBinary insertaNodeinBinary = new InsertaNodeinBinary();
		System.out.println(binaryTreeLevelOrderTraversal.levelOrder(insertaNodeinBinary.insertNode(root, node4)));

	}

}
