package n.series.LinkedList;

import java.util.ArrayList;
import java.util.List;

public class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }

    public static List<Integer> printListfromHeadtoTail(ListNode head) {
        List<Integer> res = new ArrayList<Integer>();
        if (head == null) {
            return res;
        }
        while (head != null) {
            res.add(head.val);
            head = head.next;
        }
        return res;
    }

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
        System.out.println(ListNode.printListfromHeadtoTail(head));
    }

}
