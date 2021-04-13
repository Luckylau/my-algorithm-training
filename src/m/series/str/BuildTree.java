package m.series.str;

import util.TreeNode;

/**
 * 从前序与中序遍历序列构造二叉树
 *
 * @Author luckylau
 * @Date 2021/4/13
 */
public class BuildTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        if (inorder == null || inorder.length == 0) {
            return null;
        }
        return build(preorder, inorder, 0, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int[] inorder, int preStart, int inStart, int inEnd) {
        if (inStart > inEnd) {
            return null;
        }
        TreeNode current = new TreeNode(preorder[preStart]);
        int inIndex = 0;
        for (inIndex = inStart; inIndex < inEnd; inIndex++) {
            if (inorder[inIndex] == preorder[preStart]) {
                break;
            }
        }
        current.left = build(preorder, inorder, preStart + 1, inStart, inIndex - 1);
        current.right = build(preorder, inorder, inIndex - inStart + 1 + preStart, inIndex + 1, inEnd);
        return current;
    }
}
