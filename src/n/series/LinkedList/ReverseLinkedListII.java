/**
 * Reverse a linked list from position m to n.
 * Example
 * Given 1->2->3->4->5->NULL, m = 2 and n = 4, return 1->4->3->2->5->NULL.
 * Given m, n satisfy the following condition: 1 �� m �� n �� length of list.
 * Challenge 
 * Reverse it in-place and in one-pass
 * 
 * 
 * 
 */
package n.series.LinkedList;

public class ReverseLinkedListII {
	
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if( head == null ){
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        head = dummy;
        
        for (int i = 1 ; i < m ;i ++) {
            head = head.next;
        }
        ListNode premNode = head;
        ListNode mNode = head.next;
        ListNode nNode = head.next;
        ListNode postnNode = head.next.next;
        for ( int i = m ; i < n ; i ++ ) {
            ListNode temp = postnNode.next;
            postnNode.next = nNode;
            nNode = postnNode;
            postnNode = temp;
        }
        
        premNode.next = nNode;
        mNode.next = postnNode;
        return dummy.next;
      }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(1);
		ListNode node = new ListNode(2);
		ListNode node2 = new ListNode(3);
		ListNode node3 = new ListNode(4);
		ListNode node4 = new ListNode(5);
		head.next = node;
		node.next = node2;
		node2.next = node3;
		node3.next = node4;
		System.out.println(ListNode.printListfromHeadtoTail(head));
		ReverseLinkedListII reverseLinkedListII = new ReverseLinkedListII();
		reverseLinkedListII.reverseBetween(head, 2, 4);
		System.out.println(ListNode.printListfromHeadtoTail(head));

	}

}
