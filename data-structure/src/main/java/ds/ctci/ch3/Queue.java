package ds.ctci.ch3;

public class Queue {
	
	private class Node {
		int data;
		Node next;
		
		public Node(int data) {
			this.data = data;
		}
	}
	
	Node first = null;
	Node last = null;
	
	public void add(int item) {
		Node node = new Node(item);
		
		if(first == null){
			first = last = node;
			return;
		}

		last.next = node;
		last = node;

	}
	
	public int remove() {
		
		if(first == null)
			throw new RuntimeException("Empty queue exception");
		
		int item = first.data;
		first = first.next;
		
		if(first == null)
			last = null;
		
		return item;
	}
	
	public int peek() {
		if(first == null)
			throw new RuntimeException("Empty queue exception");
		
		return first.data;
		
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
	private static void printQueue(Queue queue) {
		
		Node head = queue.first;
		System.out.print("queue: (start->end) ");
		while(head!=null){
			System.out.printf("-> %d", head.data);
			head = head.next;
		}
		System.out.println();

	}

	public static void main(String[] args) {
		
		Queue q = new Queue();
		Queue.printQueue(q);
		//q.remove();
		
		q.add(1);
		q.add(2);
		Queue.printQueue(q);
		System.out.println("Removed : " + q.remove());
		System.out.println("peek : " + q.peek());
		Queue.printQueue(q);
		q.add(3);
		Queue.printQueue(q);
	}
}
