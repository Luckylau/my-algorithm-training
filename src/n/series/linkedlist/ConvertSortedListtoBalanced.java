package n.series.linkedlist;

import util.ListNode;

/**
 * @Author luckylau
 * @Date 2022/3/31
 * Given a singly linked list where elements are sorted in ascending order,
 * convert it to a height balanced BST.
 * Example
 * 2
 * 1->2->3  =>      / \
 * 1   3
 */
public class ConvertSortedListToBalanced {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(7);
        ListNode node6 = new ListNode(9);

        head.next = node;
        node.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        ConvertSortedListToBalanced convertSortedListtoBalanced = new ConvertSortedListToBalanced();
        System.out.println(TreeNode.printTreeNodebylevelOrder(convertSortedListtoBalanced.sortedListToBST(head)));
    }

    public TreeNode sortedListToBST(ListNode head) {
        // write your code here
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }

        ListNode midBefore = findMidBefore(head);
        ListNode mid = midBefore.next;
        TreeNode root = new TreeNode(mid.val);
        midBefore.next = null;
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(mid.next);
        return root;
    }

    private ListNode findMidBefore(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        fast = fast.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

}
