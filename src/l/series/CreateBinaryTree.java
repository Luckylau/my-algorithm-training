package l.series;

/**
 * 有序数组构建二叉查找树
 */
public class CreateBinaryTree {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        CreateBinaryTree createBinaryTree = new CreateBinaryTree();
        createBinaryTree.createBinaryTree(nums);

    }

    public TreeNode createBinaryTree(int[] nums) {
        if (nums.length == 0 || nums == null) {
            return null;
        }
        return helper(nums, 0, nums.length - 1);
    }

    private TreeNode helper(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, start, mid - 1);
        root.right = helper(nums, mid + 1, end);
        return root;
    }
}

class TreeNode {
    int val;
    TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
    }
}

