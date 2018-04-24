/**
 * 
 * Given a linked list, return the node where the cycle begins.
 * If there is no cycle, return null.
 * 
 * 
 */
package n.series.LinkedList;

public class LinkedListCycleII {
	
	public ListNode detectCycle(ListNode head) {  
        // write your code here
        if(head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        
        while(slow != fast) {
            if(fast == null || fast.next == null ) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        
        while (head != slow.next){
            head = head.next;
            slow = slow.next;
        }
        return head;
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
		node4.next = node2;
		LinkedListCycleII linkedListCycleII = new LinkedListCycleII();
		System.out.println(linkedListCycleII.detectCycle(head).val);

	}

}
