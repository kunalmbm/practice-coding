package ds.list.doubly;

public class NodeInt {

	private int data;
	private NodeInt next;
	private NodeInt prev;
	
	public NodeInt(int data) {
		this.data = data;
	}
	
	public NodeInt() {
	}
	
	public int data() {
		return data;
	}
	public void data(int data) {
		this.data = data;
	}

	public NodeInt next() {
		return next;
	}
	public void next(NodeInt next) {
		this.next = next;
	}
	public NodeInt prev() {
		return prev;
	}
	public void prev(NodeInt prev) {
		this.prev = prev;
	}
	
	public void addNext(NodeInt newNode) {
		
		this.next = newNode;
		newNode.prev = this;

	}
	
	public static NodeInt addLast(NodeInt node, NodeInt newNode) {

		if(node == null)
			return newNode;
		
		NodeInt start = node;
		while(node.next() != null) 
			node = node.next();
		
		node.next = newNode;
		newNode.prev = node;
		
		return start;
		
	}
	
	public static void printAllNodes(NodeInt node) {
		
		System.out.print("Node: ");
		while(node!=null) {
			
			if(node.next != null) {
				if(node.next.prev!=node)
					System.out.printf("%d -> ",node.data);
				else
					System.out.printf("%d <-> ",node.data);
			} else {
				System.out.printf("%d",node.data);
			}

			node = node.next;
		}
		System.out.println();

	}

}
