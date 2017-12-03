package ds.ctci.ch3;

public class StackWithMin extends Stack {
	
	Stack min = new Stack();
	
	public void push(int item) {
		if(min() > item) {
			min.push(item);
		}
		super.push(item);
	}
	
	public int pop() {
		int val = super.pop();
		if(val ==  min())
			min.pop();
		return val;
	}
	
	public int min() {
		return isEmpty() ? Integer.MAX_VALUE : min.peak(); 
	}
	
	@Override
	public void printStack() {
		super.printStack();
		System.out.println("Min Stack");
		min.printStack();
		
		System.out.println("------- "+ min() + " -----------");
	}
	
	public static void main(String[] args) {
		
		StackWithMin stack = new StackWithMin();
		
		stack.push(13);
		stack.printStack();
		stack.push(15);
		stack.printStack();
		stack.push(2);
		stack.printStack();
		stack.push(10);
		stack.printStack();
		stack.push(14);
		stack.printStack();
		stack.push(1);
		stack.printStack();
		
		stack.pop();
		stack.printStack();

		stack.pop();
		stack.printStack();

		stack.pop();
		stack.printStack();

		stack.pop();
		stack.printStack();

	}

}
