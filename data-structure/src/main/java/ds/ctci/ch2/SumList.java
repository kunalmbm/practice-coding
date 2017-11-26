package ds.ctci.ch2;

import ds.ctci.Node;

public class SumList {
	
	
	private Node sumSimple(Node node1, Node node2) {
		
		int c = 0;
		Node dummy = new Node(0), node = dummy;
		while(node1!=null || node2!=null) {
			if(node1!=null) {
				c+=node1.data;
				node1 = node1.next;
			}
			if(node2!=null) {
				c+=node2.data;
				node2 = node2.next;
			}
			
			node = node.next = new Node(c%10);
			c/=10;
		}
		
		if(c > 0) 
			node.next = new Node(c);
		
		return dummy.next;
	}
	
	private Node sum(Node node1, Node node2) {
		int n1 = Node.sizeOf(node1);
		int n2 = Node.sizeOf(node2);
		
		Node head = null;
		if(n1 == 0 && n2 == 0)
			return head;
		
		if(n1 >= n2) 
			head = sumRecursive(node1,node2,n1,n2);
		else
			head = sumRecursive(node2,node1,n2,n1);
		
		if(head.data < 10)
			return head;
		
		Node node = new Node(head.data / 10);
		head.data %= 10;
		node.next = head;
		return node;
	}
	
	private Node sumRecursive(Node node1, Node node2, int n1, int n2) {
		if(n1 == 0 && n2 == 0)
			return null;
		
		Node head = null, node = new Node(0);
		int d1 = 0, d2 = 0, c = 0;
		if(n1 > n2) {
			d1 = node1.data;
			head = sumRecursive(node1.next, node2, n1-1, n2);
		} else {
			d1 = node1.data;
			d2 = node2.data;
			head = sumRecursive(node1.next, node2.next, n1-1, n2-1);
		}
		
		if(head!=null && head.data > 9) {
			c = head.data / 10;
			head.data %= 10;
		}
		
		c+=(d1+d2);
		node.data = c;
		node.next = head;
		return node;
		
	}
	

	public static void main(String[] args) {

		SumList obj = new SumList();
		
		int[] A1 = {9,5,8,9};
		int[] A2 = {  9,2,5};
		
		Node node1 = Node.createList(A1);
		Node node2 = Node.createList(A2);
		
		Node.printList(node1,"node1 - before");
		Node.printList(node2,"node2 - before");
		//Node node = obj.sumSimple(node1, node2);
		Node node = obj.sum(node1, node2);
		Node.printList(node,"node - sum");

	}
}
