/**
 * Merge k sorted linked lists and return it as one sorted list.
 * Analyze and describe its complexity.
 * Example
 * Given lists:
 * [
 * 2->4->null,
 * null,
 * -1->null
 *],
 * 
 * 
 */
package n.series.LinkedList;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergekSortedLists {
	
	public ListNode mergeKLists(List<ListNode> lists) {
		if( lists == null || lists.size() == 0) {
            return null;
        }
		Queue<ListNode> priorityQueue= new PriorityQueue<ListNode>(lists.size(),new Comparator<ListNode>() {

			@Override
			public int compare(ListNode o1, ListNode o2) {
				// TODO Auto-generated method stub
				return o1.val -o2.val;
			}
		});
		for ( int i =0 ;i < lists.size() ; i++){
			if(lists.get(i) !=null){
			      priorityQueue.offer(lists.get(i));
			    }
		}
		ListNode dummy = new ListNode(-1);
		ListNode pointer = dummy;
		while ( !priorityQueue.isEmpty()){
			ListNode tmp =priorityQueue.poll();
			pointer.next = tmp;
			pointer = pointer.next;
			if(tmp.next!=null){
				priorityQueue.offer(tmp.next);
			}
		}
		return dummy.next;
	}
	
	public ListNode mergeKLists2(List<ListNode> lists) {  
        // write your code here
        if( lists == null || lists.size() == 0) {
            return null;
        }
        return mergeHelper(lists,0,lists.size() - 1);
    }
    private ListNode mergeHelper(List<ListNode> lists , int start , int end ){
        if(start == end ) {
            return lists.get(start);
        }
        int mid = start + (end - start)/2 ; 
        ListNode left = mergeHelper( lists , start , mid);
        ListNode right = mergeHelper( lists , mid + 1 , end);
        return mergeTwoLists(left, right);
    }
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // write your code here
        ListNode dummy = new ListNode(-1);
        ListNode point = dummy;
        while ( l1 != null && l2 != null ) {
            if ( l1.val > l2.val) {
                point.next = l2;
                l2 = l2.next;
            } else {
                point.next = l1;
                l1 = l1.next;
            }
            point = point.next;
        }
        
        if ( l2 != null ){
            point.next = l2;
        }
        if ( l1 !=null ) {
            point.next = l1;
        }
        return dummy.next;
    }
    
    

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode node1 = new ListNode(3);
		ListNode node2 = new ListNode(5);
		ListNode node3 = new ListNode(7);
		ListNode node11 = new ListNode(1);
		ListNode node12= new ListNode(9);
		ListNode node21 = new ListNode(2);
		ListNode node22 = new ListNode(4);
		ListNode node23 = new ListNode(6);
		ListNode node24 = new ListNode(8);
		ListNode node25= new ListNode(10);
		node1.next = node2;
		node2.next = node3;
		node11.next = node12;
		node21.next = node22;
		node22.next = node23;
		node23.next = node24;
		node24.next = node25;
		List<ListNode> lists = new ArrayList<ListNode>();
		lists.add(node1);
		lists.add(node11);
		lists.add(node21);
		MergekSortedLists mergekSortedLists = new MergekSortedLists();
		System.out.println(ListNode.printListfromHeadtoTail(mergekSortedLists.mergeKLists(lists)));
		ListNode node1t = new ListNode(3);
		ListNode node2t = new ListNode(5);
		ListNode node3t = new ListNode(7);
		ListNode node11t = new ListNode(1);
		ListNode node12t= new ListNode(9);
		ListNode node21t = new ListNode(2);
		ListNode node22t = new ListNode(4);
		ListNode node23t = new ListNode(6);
		ListNode node24t = new ListNode(8);
		ListNode node25t= new ListNode(10);
		node1t.next = node2t;
		node2t.next = node3t;
		node11t.next = node12t;
		node21t.next = node22t;
		node22t.next = node23t;
		node23t.next = node24t;
		node24t.next = node25t;
		List<ListNode> listst = new ArrayList<ListNode>();
		listst.add(node1t);
		listst.add(node11t);
		listst.add(node21t);
		System.out.println(ListNode.printListfromHeadtoTail(mergekSortedLists.mergeKLists2(listst)));
		

	}

}
