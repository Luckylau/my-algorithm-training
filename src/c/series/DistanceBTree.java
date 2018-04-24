package c.series;

public class DistanceBTree {
	int max = 0;

	public int distanceBTree(TreeNode root) {
		if (root == null) {
			return 0;
		}
		helper(root);
		return max;
	}

	private int helper(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = helper(root.left);
		int right = helper(root.right);
		int tmp = left + right + 1;
		if (max < tmp)
			max = tmp;
		return Math.max(left, right) + 1;
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
		DistanceBTree DistanceBTree = new DistanceBTree();
		System.out.println(DistanceBTree.distanceBTree(root));

	}

}
