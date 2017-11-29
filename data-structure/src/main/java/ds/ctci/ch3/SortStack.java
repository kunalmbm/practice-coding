package ds.ctci.ch3;

public class SortStack {
	
	public static void sortStack(Stack stack) {
		
		Stack tmp = new Stack();
		boolean flag = true;
		do {
			flag = false;
			while(!stack.isEmpty()) {
				int item = stack.pop();
				while(!stack.isEmpty() && stack.peak() < item) {
					tmp.push(stack.pop());
					flag = true;
				}
				
				tmp.push(item);
			}
			// reshuffle
			while(!tmp.isEmpty()) 
				stack.push(tmp.pop());
		} while(flag);
		
	}
	
	public static void main(String[] args) {
		Stack stack = new Stack();
		stack.push(12);
		stack.push(15);
		stack.push(10);
		stack.push(5);
		stack.push(25);
		stack.push(134);
		stack.push(99);
		
		Stack.printStack(stack);
		sortStack(stack);
		Stack.printStack(stack);
	}

}
