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
	
	public int pop() {
		
		if(top == null)
			throw new RuntimeException("Empty stack exception");
		
		int item = top.data;
		top = top.next;
		
		return item;
	}
	
	public int peek() {
		if(top == null)
			throw new RuntimeException("Empty stack exception");
		
		return top.data;
		
	}
	
	public boolean isEmpty() {
		return top == null;
	}
	
	private static void printStack(Stack stack) {
		
		Node head = stack.top;
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
		
		Stack.printStack(stack);
		System.out.println(stack.pop());
		
		Stack.printStack(stack);
		System.out.println(stack.peek());
		Stack.printStack(stack);
		
		System.out.println(stack.isEmpty());
	}
}
