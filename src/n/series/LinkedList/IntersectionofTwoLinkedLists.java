/**
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 * Notice
 * If the two linked lists have no intersection at all, return null.
 * The linked lists must retain their original structure after the function returns.
 * You may assume there are no cycles anywhere in the entire linked structure.
 * Example
 * The following two linked lists:

 *A:          a1 �� a2
 *                �K
 *                    c1 �� c2 �� c3
 *                �J            
 *B:     b1 �� b2 �� b3
 * 
 * 
 * 
 */
package n.series.LinkedList;

public class IntersectionofTwoLinkedLists {
	
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // Write your code here
        if(headA == null || headB ==null){
            return null;
        }
        
        ListNode tail = headA;
        while(tail.next !=null){
            tail = tail.next;
        }
        tail.next = headB;
        ListNode target =detectCycle(headA);
        tail.next = null;
        return target;
    }
    private ListNode detectCycle(ListNode head){
        if(head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while(slow !=fast){
            if(fast == null || fast.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        
        while ( head != slow.next){
            head = head.next;
            slow = slow.next;
        }
        return head;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode headA = new ListNode(1);
		ListNode node = new ListNode(2);
		ListNode node2 = new ListNode(3);
		ListNode node3 = new ListNode(4);
		ListNode node4 = new ListNode(5);
		headA.next = node;
		node.next = node2;
		node2.next = node3;
		node3.next = node4;
		ListNode headB = new ListNode(6);
		ListNode node5 = new ListNode(4);
		ListNode node6 = new ListNode(8);
		ListNode node7= new ListNode(5);
		ListNode node8 = new ListNode(7);
		headB.next = node5;
		node5.next = node6;
		node6.next =node7;
		node7.next =node8;
		node8.next = node2;
		System.out.println(ListNode.printListfromHeadtoTail(headA));
		System.out.println(ListNode.printListfromHeadtoTail(headB));
		IntersectionofTwoLinkedLists intersectionofTwoLinkedLists = new IntersectionofTwoLinkedLists();
		System.out.println(intersectionofTwoLinkedLists.getIntersectionNode(headA, headB).val);
		

	}

}
