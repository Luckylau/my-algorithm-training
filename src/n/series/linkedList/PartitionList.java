package n.series.linkedlist;

import util.ListNode;

/**
 * @Author luckylau
 * @Date 2022/3/31
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * Example
 * Given 1->4->3->2->5->2->null and x = 3,
 * return 1->2->2->4->3->5->null.
 */
public class PartitionList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node = new ListNode(4);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(2);
        head.next = node;
        node.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        PartitionList partitionList = new PartitionList();
        System.out.println(ListNode.printListfromHeadtoTail(head));
        partitionList.partition(head, 3);
        System.out.println(ListNode.printListfromHeadtoTail(head));

    }

    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return head;
        }
        ListNode leftDummy = new ListNode(-1);
        ListNode rightDummy = new ListNode(-1);
        ListNode left = leftDummy;
        ListNode right = rightDummy;
        while (head != null) {
            if (head.val >= x) {
                right.next = head;
                right = right.next;
            } else {
                left.next = head;
                left = left.next;
            }
            head = head.next;
        }

        right.next = null;
        left.next = rightDummy.next;
        return leftDummy.next;

    }

}
