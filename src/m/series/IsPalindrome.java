package m.series;


/**
 * 回文链表
 *
 * @Author luckylau
 * @Date 2021/4/15
 */
public class IsPalindrome {
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode lastHalf = revserse(slow.next);
        slow.next = null;
        ListNode p1 = head;
        ListNode p2 = lastHalf;
        while (p1 != null && p2 != null) {
            if (p2.val != p1.val) {
                return false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        slow.next = revserse(lastHalf);
        return true;

    }

    private ListNode revserse(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = null;
        ListNode current = head;
        ListNode next;
        while (current != null) {
            next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        return pre;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
