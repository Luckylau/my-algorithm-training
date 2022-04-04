package n.series.linkedlist;

import util.ListNode;

/**
 * @Author luckylau
 * @Date 2022/3/31
 * Merge two sorted (ascending) linked lists and return it as a new sorted list.
 * The new sorted list should be made by splicing together the nodes of the two lists and sorted in ascending order.
 * Example
 * Given 1->3->8->11->15->null, 2->null , return 1->2->3->8->11->15->null.
 */
public class MergeTwoSortedLists {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(7);
        ListNode node11 = new ListNode(1);
        ListNode node12 = new ListNode(9);
        node1.next = node2;
        node2.next = node3;
        node11.next = node12;
        System.out.println(ListNode.printListfromHeadtoTail(node1));
        System.out.println(ListNode.printListfromHeadtoTail(node11));
        MergeTwoSortedLists mergeTwoSortedLists = new MergeTwoSortedLists();
        System.out.println(ListNode.printListfromHeadtoTail(mergeTwoSortedLists.mergeTwoLists(node1, node11)));

    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // write your code here
        ListNode dummy = new ListNode(-1);
        dummy.next = l1;
        ListNode pre = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                ListNode tmp = l2.next;
                l2.next = pre.next;
                pre.next = l2;
                l2 = tmp;
            } else {
                l1 = l1.next;
            }
            pre = pre.next;
        }

        if (l2 != null) {
            pre.next = l2;
        }
        return dummy.next;
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        // write your code here
        ListNode dummy = new ListNode(-1);
        ListNode point = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                point.next = l2;
                l2 = l2.next;
            } else {
                point.next = l1;
                l1 = l1.next;
            }
            point = point.next;
        }

        if (l2 != null) {
            point.next = l2;
        }
        if (l1 != null) {
            point.next = l1;
        }
        return dummy.next;
    }

}
