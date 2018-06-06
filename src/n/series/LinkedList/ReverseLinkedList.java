package n.series.LinkedList;
/**
 * Reverse a linked list.
 * Example
 * For linked list 1->2->3, the reversed linked list is 3->2->1
 * Challenge
 * Reverse it in-place and in one-pass
 *
 *
 */
public class ReverseLinkedList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        head.next = node;
        node.next = node2;
        node2.next = node3;
        node3.next = node4;
        System.out.println(ListNode.printListfromHeadtoTail(head));
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        System.out.println(ListNode.printListfromHeadtoTail(reverseLinkedList.reverse(head)));

    }

    public ListNode reverse(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode pre = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        return pre;
    }

}
