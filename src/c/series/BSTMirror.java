package c.series;

/**
 *树的镜像
 *
 */
public class BSTMirror {

	public TreeNode bstMirror(TreeNode root) {
		if (root == null) {
			return null;
		}
		TreeNode tmp = root.left;
		root.left = root.right;
		root.right = tmp;
		root.left = bstMirror(root.left);
		root.right = bstMirror(root.right);
		return root;

	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode node1 = new TreeNode(2);
		TreeNode node2 = new TreeNode(3);
		root.right = node1;
		node1.left = node2;
		BSTMirror bSTMirror = new BSTMirror();
		bSTMirror.bstMirror(root);

	}



}

