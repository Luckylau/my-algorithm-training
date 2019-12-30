package o.series;
/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 */

/**
 * @Author luckylau
 * @Date 2019/12/30
 */
public class FindKthToTail {
    public ListNode findKthToTail(ListNode head, int k) {
        if (head == null || k == 0) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (k - 1 > 0) {
            fast = fast.next;
            if (fast == null) {
                return null;
            }
            k--;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
