package ds.ctci.ch3;

public class Stack {
	
	private class Node {
		int data;
		Node next;
		
		public Node(int data) {
			this.data = data;
		}
	}
	
	Node top = null;
	
	public void push(int item) {
		Node node = new Node(item);
		node.next = top;
		top = node;
	}
	
	public int popBottom() {
		if(top == null)
			throw new RuntimeException("Empty stack exception");

		if(top.next == null) {
			int item = top.data;
			top = null;
			return item;
		}
		
		Node node = top;
		while(node.next.next!=null){
			node = node.next;
		}
		
		int item = node.next.data;
		node.next = null;
		
		return item;

	}
	
	public int pop() {
		
		if(top == null)
			throw new RuntimeException("Empty stack exception");
		
		int item = top.data;
		top = top.next;
		
		return item;
	}
	
	public int peak() {
		if(top == null)
			throw new RuntimeException("Empty stack exception");
		
		return top.data;
		
	}
	
	public boolean isEmpty() {
		return top == null;
	}
	
	public void printStack() {
		
		Node head = top;
		System.out.print("top ");
		while(head!=null){
			System.out.printf("-> %d", head.data);
			head = head.next;
		}
		System.out.println();

	}

	public static void main(String[] args) {

		Stack stack = new Stack();
		System.out.println(stack.isEmpty());
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		
		stack.printStack();
		System.out.println(stack.pop());
		
		stack.printStack();
		System.out.println(stack.peak());
		stack.printStack();
		
		System.out.println(stack.isEmpty());
	}
}
