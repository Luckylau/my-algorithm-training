package m.series;

/**
 * 160.相交链表
 *
 * @Author luckylau
 * @Date 2021/4/14
 */
public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode head1 = headA;
        ListNode head2 = headB;
        while (head1 != head2) {
            head1 = head1 == null ? headB : head1.next;
            head2 = head2 == null ? headA : head2.next;
        }
        return head1;
    }

    class ListNode {
        ListNode next;
    }
}
