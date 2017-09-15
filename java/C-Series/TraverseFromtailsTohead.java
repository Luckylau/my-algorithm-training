package demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TraverseFromtailsTohead {
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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

}

class ListNode {
	public int val;
	public ListNode next;

	public ListNode(int val) {
		this.val = val;
		this.next = null;
	}
}
