package m.series.str;

/**
 * 反转链表
 *
 * @Author luckylau
 * @Date 2021/4/12
 */
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode current = head;
        ListNode next = null;
        while (current != null) {
            next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        return pre;
    }

    private static class ListNode {
        ListNode next;
    }
}
