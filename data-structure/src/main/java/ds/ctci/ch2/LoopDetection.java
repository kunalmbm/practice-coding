package ds.ctci.ch2;

import ds.ctci.Node;

public class LoopDetection {

	private Node hasLoop(Node head) {
		Node slow = head, fast = head;
		while(fast!=null && fast.next!=null) {
			slow = slow.next;
			fast = fast.next.next;
			
			if(slow == fast)
				return slow;
		}
		
		return null;
	}
	
	private Node loopDetection(Node head) {
		Node node  = hasLoop(head);
		
		if(node == null)
			return null;
		
		while(head!=node){
			head = head.next;
			node = node.next;
		}
		
		return head;
	}
	public static void main(String[] args) {

		LoopDetection obj = new LoopDetection();
		
		int[] A = {1,2,3,4,5,6};
		Node head = Node.createList(A);
		Node.printList(head,"before");
		
		head.next.next.next.next.next.next = head.next.next.next;  

		Node node = obj.loopDetection(head);
		System.out.println(node == null ? "null" : node.data);
	}
}
