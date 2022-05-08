package m.series;

import util.ListNode;

/**
 * 23. 合并K个升序链表
 *
 * @Author luckylau
 * @Date 2022/5/8
 */
public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return mergeKLists(lists, 0, lists.length - 1);

    }

    private ListNode mergeKLists(ListNode[] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        }
        int mid = start + (end - start) / 2;
        ListNode left = mergeKLists(lists, start, mid);
        ListNode right = mergeKLists(lists, mid + 1, end);
        return merge2Lists(left, right);
    }

    private ListNode merge2Lists(ListNode left, ListNode right) {
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        ListNode dump = new ListNode(-1);
        ListNode pre = dump;
        while (left != null && right != null) {
            if (left.val > right.val) {
                pre.next = right;
                right = right.next;
            } else {
                pre.next = left;
                left = left.next;
            }
            pre = pre.next;
        }

        pre.next = left == null ? right : left;
        return dump.next;
    }
}
