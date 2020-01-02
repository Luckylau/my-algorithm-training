package o.series;

/**
 * 输入两个链表，找出它们的第一个公共结点。
 *
 * @Author luckylau
 * @Date 2019/12/20
 */
public class FindFirstCommonNode {
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

        ListNode head2 = new ListNode(6);
        head2.next = node3;
        FindFirstCommonNode findFirstCommonNode = new FindFirstCommonNode();

        System.out.println(findFirstCommonNode.findFirstCommonNode(head, head2).val);


    }

    public ListNode findFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        ListNode tail = pHead1;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = pHead2;
        ListNode slow = pHead1;
        ListNode fast = pHead1.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        while (pHead1 != slow.next) {
            pHead1 = pHead1.next;
            slow = slow.next;
        }
        tail.next = null;

        return pHead1;
    }

    public ListNode findFirstCommonNode2(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        int len1 = len(pHead1);
        int len2 = len(pHead2);
        int diff = Math.abs(len1 - len2);
        if (len1 > len2) {
            while (diff-- > 0) {
                pHead1 = pHead1.next;
            }
        } else if (len1 < len2) {
            while (diff-- > 0) {
                pHead2 = pHead2.next;
            }
        }
        while (pHead1 != pHead2) {
            pHead1 = pHead1.next;
            pHead2 = pHead2.next;
        }
        return pHead1;
    }

    private int len(ListNode node) {
        if (node == null) {
            return 0;
        }
        int count = 0;
        ListNode current = node;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }
}
