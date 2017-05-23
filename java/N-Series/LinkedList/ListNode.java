package chapter4;

import java.util.ArrayList;

public class ListNode {
	int val;
	ListNode next;
	public ListNode(int val){
		this.val = val;
		this.next = null;
	}
	
	public static ArrayList<Integer> printListfromHeadtoTail(ListNode head){
		ArrayList<Integer> res = new ArrayList<Integer>();
		if(head == null) {
			return res;
		}
		res.add(head.val);
		while( head.next != null){
			res.add(head.next.val);
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
