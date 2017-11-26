package ds.ctci;

public class Node {
	public int data = 0;
	public Node next = null;
	
	public Node(int data) {
		this.data = data;
	}

	public static Node createList(int[] A) {
		
		Node head = new Node(0), node = head;
		for (int a : A) {
			node = node.next = new Node(a);
		}
		return head.next;
	}
	
	public static void printList(Node node) {
		printList(node, null);
	}
	
	public static void printList(Node node, String prefix) {
		if(prefix == null)
			prefix = "node";
		System.out.printf("%s",prefix);
		while(node!=null) {
			System.out.printf(" -> %d",node.data);
			node = node.next;
		}
		System.out.println();
	}
	
	public static int sizeOf(Node head) {
		int n = 0;
		while(head!=null) {
			n++;
			head = head.next;
		}
		return n;
	}
	
	public static void swapData(Node node1, Node node2) {
		if(node1 == null || node2 == null || node1 == node2)
			return;
		
		int tmp = node1.data;
		node1.data = node2.data;
		node2.data = tmp;
	}
	
	public static Node reverse(Node head) {
		Node prev = null, next = null;
		while(head!=null) {
			next = head.next;
			
			head.next = prev;
			prev = head;
			head = next;
		}
		return prev;
	}

}
