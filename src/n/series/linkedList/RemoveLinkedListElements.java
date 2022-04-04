package n.series.linkedlist;

import util.ListNode;

/**
 * @Author luckylau
 * @Date 2022/3/31
 * Remove all elements from a linked list of integers that have value val.
 * Example
 * Given 1->2->3->3->4->5->3, val = 3, you should return the list as 1->2->4->5
 */
public class RemoveLinkedListElements {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node = new ListNode(2);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(3);
        head.next = node;
        node.next = node2;
        node2.next = node3;
        node3.next = node4;
        System.out.println(ListNode.printListfromHeadtoTail(head));
        RemoveLinkedListElements removeLinkedListElements = new RemoveLinkedListElements();
        removeLinkedListElements.removeElements(head, 2);
        System.out.println(ListNode.printListfromHeadtoTail(head));

    }

    public ListNode removeElements(ListNode head, int val) {
        // Write your code here
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        head = dummy;
        while (head.next != null) {
            if (head.next.val == val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
        return dummy.next;
    }

}
