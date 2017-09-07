package demo;

/**
 * 输入一棵二元查找树，将该二元查找树转换成一个排序的双向链表。 要求不能创建任何新的结点，只调整指针的指向
 * 
 *
 */
public class BinaryTreeToDoubleLinkedList {
	Node head = null;
	Node tail = null;

	public Node bSTree2Link(Node root) {
		traverse(root);
		return head;
	}

	private void traverse(Node root) {
		if (root == null) {
			return;
		}
		traverse(root.left);
		if (head == null && tail == null) {
			head = root;
			tail = root;
		} else {
			root.left = tail;
			tail.right = root;
			tail = root;
		}
		traverse(root.right);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = new Node(10);
		Node node1 = new Node(6);
		Node node2 = new Node(14);
		Node node3 = new Node(4);
		Node node4 = new Node(8);
		Node node5 = new Node(12);
		Node node6 = new Node(16);
		root.left = node1;
		root.right = node2;
		node1.left = node3;
		node1.right = node4;
		node2.left = node5;
		node2.right = node6;
		BinaryTreeToDoubleLinkedList binaryTreeToDoubleLinkedList = new BinaryTreeToDoubleLinkedList();
		Node head = binaryTreeToDoubleLinkedList.bSTree2Link(root);
		while (head != null) {
			System.out.println(head.val + " ");
			head = head.right;
		}
	}

}

class Node {
	int val;
	Node left;
	Node right;

	public Node(int val) {
		this.val = val;
		this.left = this.right = null;
	}
}