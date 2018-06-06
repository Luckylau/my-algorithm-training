package n.series.LinkedList;
/**
 * Given a singly linked list L: L0 --> L1 ..... Ln-1 --> Ln
 * reorder it to: L0 --> Ln --> L1 --> Ln-1 --> L2 --> Ln-2 --> ...
 */
public class ReorderList {

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
        ReorderList reorderList = new ReorderList();
        reorderList.reorderList(head);
        System.out.println(ListNode.printListfromHeadtoTail(head));

    }

    public void reorderList(ListNode head) {
        // write your code here
        if (head == null || head.next == null) {
            return;
        }
        ListNode mid = findMiddle(head);
        ListNode right = reverse(mid.next);
        mid.next = null;
        merge(head, right);


    }

    private ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode tmp = head.next;
            head.next = pre;
            pre = head;
            head = tmp;
        }
        return pre;
    }

    private void merge(ListNode l1, ListNode l2) {
        int index = 0;
        ListNode dummy = new ListNode(-1);
        ListNode pointer = dummy;
        while (l1 != null && l2 != null) {
            if (index % 2 == 0) {
                pointer.next = l1;
                l1 = l1.next;
            } else {
                pointer.next = l2;
                l2 = l2.next;
            }
            index++;
            pointer = pointer.next;
        }

        if (l1 != null) {
            pointer.next = l1;
        }
        if (l2 != null) {
            pointer.next = l2;
        }
    }

}
