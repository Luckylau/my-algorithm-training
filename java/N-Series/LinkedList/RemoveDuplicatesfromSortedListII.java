/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list.
 * Example
 * Given 1->2->3->3->4->4->5, return 1->2->5.
 * Given 1->1->1->2->3, return 2->3.
 */
package chapter4;

public class RemoveDuplicatesfromSortedListII {
	
    public ListNode deleteDuplicates(ListNode head) {
        // write your code here
        if ( head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        head = dummy;
        while( head.next !=null && head.next.next !=null ){
            if(head.next.val == head.next.next.val){
                int val = head.next.val;
                while (head.next!= null && head.next.val == val){
                    head.next = head.next.next;
                }
            }else {
                head = head.next;
            }
        }
        return dummy.next;
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
		System.out.println(ListNode.printListfromHeadtoTail(head));
		RemoveDuplicatesfromSortedListII removeDuplicatesfromSortedListII = new RemoveDuplicatesfromSortedListII();
		removeDuplicatesfromSortedListII.deleteDuplicates(head);
		System.out.println(ListNode.printListfromHeadtoTail(head));

	}

}
