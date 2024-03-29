package util;

/**
 * @Author luckylau
 * @Date 2022/2/26
 */
public class TreeNode {
    public int val;
    public TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }

    @Override
    public String toString() {
        return this.val + "";
    }

}
