package ds.ctci.ch3;

public class StackOfPlates {
	
	Stack[] A = null;
	Stack stack = null;
	int arraySize = 0, stackSize = 0, threshold = 3, ci = 0;
	
	public StackOfPlates(int initPlates, int threshold) {
		arraySize = initPlates;
		this.threshold = threshold;
		A = new Stack[arraySize];
		A[0] = stack = new Stack();
	}
	
	private void resizeArray() {
		Stack[] A2 = new Stack[arraySize * 2];
		for(int i =0; i<arraySize;i++)
			A2[i] = A[i];
		
		A=A2;
		arraySize*=2;
	}
	
	public int peak() {
		return stack.peak();
	}
	
	public void push(int item) {
		if(stackSize >= threshold) {
			if(ci >= A.length-1)
				resizeArray();
			A[++ci] = stack = new Stack();
			stackSize = 0;
		}
		
		stack.push(item);
		stackSize++;
	}
	
	public int pop() {
		int item = stack.pop();
		stackSize--;
		
		if(stack.isEmpty() && ci > 0) {
			stack = A[--ci];
			stackSize = threshold;
		}

		return item;
	}
	
	public int popAt(int index) {
		
		if(index < 0 || index > ci)
			throw new RuntimeException("invalid index");
		
		if(index == ci)
			return pop();
		
		Stack stack = A[index];
		int item = stack.pop();
		shiftLeft(index);
		return item;
	}
	
	private void shiftLeft(int index) {
		
		if(index == ci) {
			stackSize--;
			if(stack.isEmpty() && ci > 0) {
				stack = A[--ci];
				stackSize = threshold;
			}
			return;
		}
		
		A[index].push(A[index+1].popBottom());
		
		shiftLeft(index+1);

	}
	
	public void printStack() {
		
		System.out.println("-----------------------------------");
		for(int i=0;i<=ci; i++) {
			System.out.printf("Index : %d : ", i);
			A[i].printStack();
		}
		System.out.println("-----------------------------------");
	}

	public static void main(String[] args) {
		
		StackOfPlates stack = new StackOfPlates(2, 3);
		stack.printStack();
		//System.out.println("Stack : Empty : " + stack.isEmpty());
		
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
		stack.push(208);
		
		stack.printStack();
		
		System.out.println("Stack : popAt(1) : " + stack.popAt(1));
		stack.printStack();
		System.out.println("Stack : popAt(2) : " + stack.popAt(2));
		stack.printStack();
		System.out.println("Stack : popAt(1) : " + stack.popAt(1));
		stack.printStack();

	}

}

