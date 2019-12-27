package o.series;
/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */

import java.util.Stack;

/**
 * @Author luckylau
 * @Date 2019/12/24
 */
public class Convert {
    //解答见：/Users/yrd/Documents/github/my-algorithm-training/src/c/series/BinaryTreeToDoubleLinkedList.java

    public TreeNode convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode head = pRootOfTree;
        TreeNode cur = null;
        boolean isFirst = true;
        while (head != null || !stack.isEmpty()) {
            if (head != null) {
                stack.push(head);
                head = head.left;
            } else {
                head = stack.pop();
                if (isFirst) {
                    pRootOfTree = head;
                    cur = head;
                    isFirst = false;
                } else {
                    cur.right = head;
                    head.left = cur;
                    cur = head;
                }

                head = head.right;
            }
        }
        return pRootOfTree;
    }

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
}
