package ds.ctci.ch2;

import ds.ctci.Node;

public class Partition {
	
	
	private Node partition2(Node head, int x) {
		Node fhead = new Node(0), first = fhead;
		Node shead = new Node(0), second = shead;
		while(head!=null) {
			if(head.data<x) 
				first = first.next = head;
			else
				second = second.next = head;
			
			head = head.next;
		}
		first.next = shead.next;
		second.next=null;
		return fhead.next;
	}
	
	void partition(Node head, int x) {
		Node cur = head, last = head;
		while(cur!=null) {
			if(cur.data < x) {
				swap(cur,last);
				last = last.next;
			}
			cur = cur.next;
		}
		
	}

	private void swap(Node cur, Node last) {
		if(cur == null || last == null || cur == last)
			return;
		
		int tmp = cur.data;
		cur.data = last.data;
		last.data = tmp;
	}

	public static void main(String[] args) {

		Partition obj = new Partition();
		
		int[] A = {3,5,8,5,10,2,1};
		Node head = Node.createList(A);
		Node.printList(head,"before");
		//obj.partition(head, 5);
		head = obj.partition2(head, 5);
		Node.printList(head,"after");
	}
}
