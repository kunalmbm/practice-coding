package ds.list.doubly;

public class NodeFloat {


	private float data;
	private NodeFloat next;
	private NodeFloat prev;
	
	public NodeFloat(float data) {
		this.data = data;
	}
	
	public NodeFloat() {
	}
	
	public float data() {
		return data;
	}
	public void data(float data) {
		this.data = data;
	}

	public NodeFloat next() {
		return next;
	}
	public void next(NodeFloat next) {
		this.next = next;
	}
	public NodeFloat prev() {
		return prev;
	}
	public void prev(NodeFloat prev) {
		this.prev = prev;
	}
	
	public void addNext(NodeFloat newNode) {
		
		this.next = newNode;
		newNode.prev = this;

	}
	
	public static NodeFloat addLast(NodeFloat node, NodeFloat newNode) {

		if(node == null)
			return newNode;
		
		NodeFloat start = node;
		while(node.next() != null) 
			node = node.next();
		
		node.next = newNode;
		newNode.prev = node;
		
		return start;
		
	}
	
	public static void printAllNodes(NodeFloat node) {
		
		System.out.print("Node: ");

		while(node!=null) {
			
			if(node.next != null) {
				if(node.next.prev!=node)
					System.out.printf("%.4f -> ",node.data);
				else
					System.out.printf("%.4f <-> ",node.data);
			} else {
				System.out.printf("%.4f",node.data);
			}

			node = node.next;
		}
		System.out.println();

	}


}
