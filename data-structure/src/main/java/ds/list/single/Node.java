package ds.list.single;

public class Node {

	private int data;
	private Node next;
	
	public Node(int data) {
		this.data = data;
	}

	public int data() {
		return data;
	}
	public void data(int data) {
		this.data = data;
	}
	public Node next() {
		return next;
	}
	public void next(Node next) {
		this.next = next;
	}
	
	public static Node getLastNode(Node node) {
		
		if(node == null)
			return null;
		
		while(node.next!=null)
			node = node.next;
		
		return node;
		
	}
	public static Node addNextNode(Node node, Node next) {
		
		if(node == null)
			return next;
		
		node.next = next;
		
		return next;
		
	}
	
	public static Node addLastNode(Node node, Node last) {
		
		if(node == null)
			return last;
		
		Node firstNode = node;
		while(node.next!=null)
			node = node.next;
		
		node.next = last;
		
		return firstNode;

	}
	
	public static void printAllNodes(Node node, String prefix) {
		
		System.out.printf("%s: ", prefix);
		while(node!=null) {
			
			if(node.next != null) {
				System.out.printf("%d -> ",node.data);
			} else {
				System.out.printf("%d",node.data);
			}

			node = node.next;
		}
		System.out.println();

	}
	
	public static void printAllNodes(Node node) {
		
		printAllNodes(node, "Node");
		

	}
}
