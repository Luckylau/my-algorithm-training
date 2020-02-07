package o.series;

import java.util.ArrayList;

/**
 * @Author luckylau
 * @Date 2019/12/25
 */
public class PrintListFromTailToHead {

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        print(listNode, list);
        return list;
    }

    private void print(ListNode listNode, ArrayList<Integer> list) {
        if (listNode != null) {
            print(listNode.next, list);
            list.add(listNode.val);
        } else {
            return;
        }
    }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

}
