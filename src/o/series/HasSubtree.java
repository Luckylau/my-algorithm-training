package o.series;
/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */

/**
 * @Author luckylau
 * @Date 2019/12/27
 */
public class HasSubtree {

    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(3);
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20);
        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);
        node3.left = node9;
        node3.right = node20;
        node20.left = node15;
        node20.right = node7;

        HasSubtree hasSubtree = new HasSubtree();
        System.out.println(hasSubtree.hasSubtree(node3, node7));

    }

    public boolean hasSubtree(TreeNode root1, TreeNode root2) {
        boolean res = false;
        if (root1 != null && root2 != null) {
            if (root1.val == root2.val) {
                res = ifRoot1HasRoot2(root1, root2);
            }
            if (!res) {
                res = hasSubtree(root1.left, root2);
            }
            if (!res) {
                res = hasSubtree(root1.right, root2);
            }
        }
        return res;
    }

    private boolean ifRoot1HasRoot2(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return true;
        }

        if (root1 == null) {
            return false;
        }

        if (root1.val != root2.val) {
            return false;
        }
        return ifRoot1HasRoot2(root1.left, root2.left) &&
                ifRoot1HasRoot2(root1.right, root2.right);
    }

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }
}
