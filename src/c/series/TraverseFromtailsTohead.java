package c.series;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 尾部遍历单链表
 */
public class TraverseFromtailsTohead {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node = new ListNode(2);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(3);
        head.next = node;
        node.next = node2;
        node2.next = node3;
        node3.next = node4;
        TraverseFromtailsTohead traverseFromtailsTohead = new TraverseFromtailsTohead();
        System.out.println(Arrays.toString(traverseFromtailsTohead.traverseFromtailsTohead(head).toArray()));

    }

    public List<Integer> traverseFromtailsTohead(ListNode head) {
        List<Integer> list = new ArrayList<>();
        if (head == null) {
            return list;
        }
        helper(head, list);
        return list;
    }

    private void helper(ListNode head, List<Integer> list) {
        if (head.next != null) {
            helper(head.next, list);
        }
        list.add(head.val);
    }

    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

}


