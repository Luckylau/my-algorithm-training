package n.series.LinkedList;

/**
 * Given a linked list, determine if it has a cycle in it.
 * Example
 * Given -21->10->4->5, tail connects to node index 1, return true
 * <p>
 * Follow up:
 * Can you solve it without using extra space?
 */
public class LinkedListCycle {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        LinkedListCycle linkedListCycle = new LinkedListCycle();
        System.out.println(linkedListCycle.hasCycle(head));
        node4.next = node2;
        System.out.println(linkedListCycle.hasCycle(head));

    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;


        }
        return true;
    }

}
