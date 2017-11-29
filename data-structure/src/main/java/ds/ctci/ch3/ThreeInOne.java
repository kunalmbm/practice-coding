package ds.ctci.ch3;

public class ThreeInOne {

	private static final int ONE = 0;
	private static final int TWO = 1;
	private static final int THREE = 2;

	private static class Stack {

		private class Node {
			public int data;
			public Node next;

			public Node(int data) {
				this.data = data;
			}
		}

		private class Result {
			int val;
			int top;

			public Result(int val, int top) {
				this.val = val;
				this.top = top;
			}
		}

		private int top1 = -1, top2 = -1, top3 = -1, top = -1;
		Node free = null;
		int size = 9;
		int[] A;

		public Stack(int stackCapacity) {
			size = stackCapacity * 3;
			A = new int[size];
		}

		private int pushGeneric(int topx, int item) {

			int index = top;
			if (free != null) {
				index = free.data;
				free = free.next;
			}

			if (free == null && (index + 2) >= size)
				resizeArray();

			A[++index] = topx;
			A[++index] = item;
			topx = index;

			if (free == null)
				top += 2;

			return topx;

		}

		public void push(int sid, int item) {

			switch (sid) {

			case ONE:
				top1 = pushGeneric(top1, item);
				break;

			case TWO:
				top2 = pushGeneric(top2, item);
				break;

			case THREE:
				top3 = pushGeneric(top3, item);
				break;

			default:
				throw new RuntimeException("invalid stack id");
			}
		}

		private void resizeArray() {
			int[] A2 = new int[size * 2];
			for (int i = 0; i < size; i++)
				A2[i] = A[i];

			A = A2;
			size *= 2;

		}

		private Result popValue(int top) {

			if (top == -1)
				throw new RuntimeException("Empty stack excpetion");

			int index = top;
			Result res = new Result(A[index--], A[index--]);

			Node node = new Node(index);
			node.next = free;
			free = node;

			return res;

		}

		private int pop(int sid) {

			Result res = null;
			switch (sid) {

			case ONE:
				res = popValue(top1);
				top1 = res.top;
				break;

			case TWO:
				res = popValue(top2);
				top2 = res.top;
				break;
			
			case THREE:
				res = popValue(top3);
				top3 = res.top;
				break;
			
			default:
				throw new RuntimeException("invalid stack id");

			}

			return res.val;
		}
		
		private int peakValue(int top) {
			
			if(top == -1)
				throw new RuntimeException("Empty stack excpetion");
			
			return A[top];
		}
		
		public int peak(int sid) {
			
			int val = 0;
			
			switch (sid) {

			case ONE:
				val = peakValue(top1);
				break;

			case TWO:
				val = peakValue(top2);
				break;
			
			case THREE:
				val = peakValue(top3);
				break;
			
			default:
				throw new RuntimeException("invalid stack id");

			}

			return val;
		}

		public boolean isEmpty(int sid) {
			
			boolean flag = false;
			
			switch (sid) {

			case ONE:
				flag = top1 == -1;
				break;

			case TWO:
				flag = top2 == -1;
				break;
			
			case THREE:
				flag = top3 == -1;
				break;
			
			default:
				throw new RuntimeException("invalid stack id");

			}

			return flag;
		}
		
		public void printAllStacks() {
			System.out.println("------------ All Stacks --------------");
			printStack(ONE);
			printStack(TWO);
			printStack(THREE);
			System.out.println("------------ All Stacks --------------");
		}
		
		private void printSingleStack(int top) {
			while(top >= 0) {
				System.out.printf(" -> %d",A[top]);
				top = A[top-1];
			}
			System.out.println();
		}
		
		public void printStack(int sid) {

			switch (sid) {

			case ONE:
				System.out.print("S1: ");
				printSingleStack(top1);
				break;

			case TWO:
				System.out.print("S2: ");
				printSingleStack(top2);
				break;
			
			case THREE:
				System.out.print("S3: ");
				printSingleStack(top3);
				break;
			
			default:
				throw new RuntimeException("invalid stack id");

			}

		}
	}
	
	public static void main(String[] args) {
		
		Stack stack = new Stack(4);

		stack.printAllStacks();
		
		System.out.println("S1: isEmpty : " + stack.isEmpty(ONE));
		System.out.println("S2: isEmpty : " + stack.isEmpty(TWO));
		System.out.println("S3: isEmpty : " + stack.isEmpty(THREE));

		stack.push(ONE, 10);
		stack.push(ONE, 11);
		stack.printAllStacks();
		
		stack.push(TWO, 20);
		stack.push(TWO, 21);
		stack.push(TWO, 22);
		System.out.println("S1: pop : " + stack.pop(ONE));
		stack.printAllStacks();
		
		stack.push(THREE, 30);
		stack.push(THREE, 31);
		stack.push(THREE, 32);
		System.out.println("S2: pop : " + stack.pop(TWO));
		stack.printAllStacks();

		System.out.println("S1: peak : " + stack.peak(ONE));
		System.out.println("S2: peak : " + stack.peak(TWO));
		System.out.println("S3: peak : " + stack.peak(THREE));

		stack.printAllStacks();

		System.out.println("S1: isEmpty : " + stack.isEmpty(ONE));
		System.out.println("S2: isEmpty : " + stack.isEmpty(TWO));
		System.out.println("S3: isEmpty : " + stack.isEmpty(THREE));

	}

}
