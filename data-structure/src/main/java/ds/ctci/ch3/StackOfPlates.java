package ds.ctci.ch3;

public class StackOfPlates {
	
	private static class Stack {
		
		private class Node {
			int data;
			Node next;
			
			public Node(int data) {
				this.data = data;
			} 
		}
		
		int size = 3, threshold = 3;
		int curCap = 0, index = 0;
		Node top = null;
		Node[] A = null;
				
		public Stack(int initPlates, int threshold) {
			size = initPlates;
			A = new Node[size];
		}
		
		private void resizeArray() {
			Node[] A2 = new Node[size * 2];
			for(int i =0; i<size;i++)
				A2[i] = A[i];
			
			A=A2;
			size*=2;
		}
		
		public void push(int item) {
			
			Node node = new Node(item);
			node.next = top;
			top = node;
			curCap++;
			
			if(curCap >= threshold) {
				if(index>=size)
					resizeArray();
				
				A[index++] = top;
				top = null;
				curCap = 0;
			}
			
		}
		
		public int pop() {

			while(top == null && index > 0) {
				top = A[--index];
				A[index] = null;
				curCap = threshold;
			}

			if(isEmpty())
				throw new RuntimeException("Empty Stack");
			
			int item = top.data;
			top = top.next;

			curCap--;

			if(top == null && index > 0) {
				top = A[--index];
				curCap = threshold;
			}
			
			return item;
				
		}
		
		public int peak() {
			if(isEmpty())
				throw new RuntimeException("Empty Stack");
			
			int item = (top == null) ? A[index-1].data : top.data;
			return item;
		}
		
		public boolean isEmpty() {
			return top == null && index == 0;
		}
		
		public void printStack() {
			
			System.out.printf("######### Stack Plates : threshold %d \n", threshold);
			
			int i = index;
			Node node = top;
			while(true) {
				
				if(node == null && i <= 0)
					break;

				System.out.printf("S%d ",i);
				while(node!=null) {
					System.out.printf(" -> %d",node.data);
					node = node.next;
				}
				System.out.println();
				i--;
				if(i>=0)
					node = A[i];
					
			}
			
			System.out.println("######### Stack Plates  ");
			
		}
		public int popAt(int subStackId) {
			if(subStackId > index || subStackId < 0)
				throw new RuntimeException("Wrong Stack Plate Id");
			
			if(subStackId == index)
				return pop();
			
			Node node = A[subStackId];
			if(node == null)
				throw new RuntimeException("Empty stack plate");
			
			int item = node.data;
			A[subStackId] = node = node.next;
			return item;
		}

	}
	
	
	public static void main(String[] args) {
		
		Stack stack = new Stack(2, 3);
		stack.printStack();
		System.out.println("Stack : Empty : " + stack.isEmpty());
		
		stack.push(100);
		stack.push(101);
		stack.push(102);
		stack.push(103);
		stack.push(104);
		stack.push(105);
		stack.push(106);
		
		stack.printStack();
		
		System.out.println("Stack : peak : " + stack.peak());
		System.out.println("Stack : pop : " + stack.pop());
		System.out.println("Stack : pop : " + stack.pop());
		System.out.println("Stack : pop : " + stack.pop());
		System.out.println("Stack : pop : " + stack.pop());
		System.out.println("Stack : pop : " + stack.pop());
		
		stack.printStack();
		
		stack.push(202);
		stack.push(203);
		stack.push(204);
		stack.push(205);
		stack.push(206);
		stack.push(207);
		
		stack.printStack();
		
		System.out.println("Stack : popAt : " + stack.popAt(2));
		System.out.println("Stack : popAt : " + stack.popAt(1));
		System.out.println("Stack : popAt : " + stack.popAt(1));
		System.out.println("Stack : popAt : " + stack.popAt(1));
		System.out.println("Stack : popAt : " + stack.popAt(0));
		
		stack.printStack();
		
		System.out.println("Stack : pop : " + stack.pop());
		System.out.println("Stack : pop : " + stack.pop());
		
		stack.printStack();
		
		stack.push(208);
		stack.push(209);
		stack.push(210);
		
		stack.printStack();
	}

}

