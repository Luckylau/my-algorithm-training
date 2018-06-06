package n.series.LinkedList;

import java.util.ArrayList;
import java.util.HashMap;

public class RandomListNode {

    int label;
    RandomListNode next, random;

    public RandomListNode(int x) {
        this.label = x;
        this.next = null;
    }

    public static ArrayList<Integer> printListfromHeadtoTail(RandomListNode head) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (head == null) {
            return res;
        }
        res.add(head.label);
        while (head.next != null) {
            res.add(head.next.label);
            head = head.next;
        }
        return res;
    }

    public static HashMap<Integer, Integer> printListRandom(RandomListNode head) {
        HashMap<Integer, Integer> res = new HashMap<Integer, Integer>();
        if (head == null) {
            return res;
        }
        while (head != null) {
            if (head.random != null) {
                res.put(head.label, head.random.label);
            }
            head = head.next;
        }
        return res;
    }

    public static void main(String[] args) {
        RandomListNode head = new RandomListNode(1);
        RandomListNode node = new RandomListNode(2);
        RandomListNode node2 = new RandomListNode(3);
        RandomListNode node3 = new RandomListNode(4);
        RandomListNode node4 = new RandomListNode(5);
        head.next = node;
        node.next = node2;
        node2.next = node3;
        node3.next = node4;
        node.random = node3;
        System.out.println(RandomListNode.printListfromHeadtoTail(head));
        System.out.println(RandomListNode.printListRandom(head));

    }

}
