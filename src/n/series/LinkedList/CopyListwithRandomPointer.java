/**
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
 * Return a deep copy of the list.
 * 
 * 
 */
package n.series.LinkedList;

import java.util.HashMap;

public class CopyListwithRandomPointer {
	
	public RandomListNode copyRandomList(RandomListNode head) {
        // write your code here
        if( head == null ) {
            return null;
        }
        
        HashMap<RandomListNode,RandomListNode> map = new HashMap<RandomListNode,RandomListNode>();
        RandomListNode dummy= new RandomListNode(-1);
        RandomListNode pointer = dummy;
        RandomListNode newNode;
        
        while(head !=null ){
            if(map.containsKey(head)){
                newNode =map.get(head);
            }else{
                newNode = new RandomListNode(head.label);
                map.put(head,newNode);
            }
            
            if(head.random !=null){
                if(map.containsKey(head.random)){
                    newNode.random = map.get(head.random);
                }else {
                    newNode.random = new RandomListNode(head.random.label);
                    map.put(head.random,newNode.random);
                }
            }
            pointer.next = newNode;
            pointer = newNode;
            head = head.next;
            
        }
        
        return dummy.next;
    }
	
	public RandomListNode copyRandomList2(RandomListNode head) {
        // write your code here
        if( head == null ) {
            return null;
        }
        copyNext(head);
        copyRandom(head);
        return spiltList(head);
    }
    
    private RandomListNode copyNext(RandomListNode head){
        while(head  != null ){
            RandomListNode newNode = new RandomListNode(head.label);
            newNode.random = head.random;
            newNode.next = head.next;
            head.next = newNode;
            head = head.next.next;
        }
        return head;
    }
    private RandomListNode copyRandom(RandomListNode head){
        while(head !=null) {
            if(head.next.random !=null){
                head.next.random = head.random.next;
            }
            head = head.next.next;
        }
        return head;
    }
    
    private RandomListNode spiltList(RandomListNode head ){
        RandomListNode newHead = head.next;
        while ( head !=null ){
            RandomListNode tmp = head.next;
            head.next = tmp.next;
            head = head.next;
            if(tmp.next !=null){
                tmp.next = tmp.next.next;
            }
        }
        return newHead;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
		CopyListwithRandomPointer copyListwithRandomPointer = new CopyListwithRandomPointer();
		RandomListNode head2 =copyListwithRandomPointer.copyRandomList(head);
		System.out.println(RandomListNode.printListfromHeadtoTail(head2));
		System.out.println(RandomListNode.printListRandom(head2));
		RandomListNode head3 =copyListwithRandomPointer.copyRandomList2(head);
		System.out.println(RandomListNode.printListfromHeadtoTail(head3));
		System.out.println(RandomListNode.printListRandom(head3));


	}

}
