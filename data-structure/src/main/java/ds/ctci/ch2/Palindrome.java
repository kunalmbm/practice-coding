package ds.ctci.ch2;

import java.util.Stack;

import ds.ctci.Node;

public class Palindrome {
	
	private class Result {
		Node head;
		boolean flag = true;
	}

	private boolean palindromeCheckRecursive(Node head) {
		int n = Node.sizeOf(head);
		boolean odd = n%2 == 1;
		
		Result res = palindromeCheckRecursiveCall(head,n/2,odd);
		return res.flag;
		
	}
	
	private Result palindromeCheckRecursiveCall(Node head, int n, boolean odd) {
		Result res = null;
		
		if(n > 0)
			res = palindromeCheckRecursiveCall(head.next, n-1, odd);
		
		if(n == 0) {
			if(odd)
				head = head.next;
			
			res = new Result();
			res.head = head;
			return res;
		}
		
		if(!res.flag)
			return res;
		
		if(head.data!=res.head.data) {
			res.flag = false;
			return res;
		}
		
		res.head = res.head.next;
		return res;
		
	}
	
	private boolean palindromeCheckStackWithRunner(Node head) {
		Node slow = head, fast = head;
		Stack<Integer> stack = new Stack<Integer>();
		while(fast!=null && fast.next!=null) {
			stack.push(slow.data);
			slow = slow.next;
			fast = fast.next.next;
		}
		
		if(fast!=null)
			slow = slow.next;
		
		while(slow!=null) {
			if(slow.data != stack.pop()) 
				return false;
			
			slow = slow.next;
		}
		return true;
	}
	
	private boolean palindromeCheckStack(Node head) {
		int n = Node.sizeOf(head);
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i = 0; i < n/2 ; i++) {
			stack.push(head.data);
			head = head.next;
		}
		
		if(n%2 == 1)
			head = head.next;
		
		while(head!=null) {
			if(head.data != stack.pop())
				return false;
			head = head.next;
		}
		
		return true;
	}
	
	private boolean palindromeCheckSplit(Node head) {
		int n = Node.sizeOf(head);
		
		if(n==1)
			return true;
		
		Node second = split(head,n/2);
		Node first = Node.reverse(head);
		if(n%2 == 1)
			second = second.next;
		
		while(first!=null && second!=null) {
			if(first.data != second.data)
				return false;
			first = first.next;
			second = second.next;
			
		}
		return true;
	}
	
	private Node split(Node head, int n) {
		
		while(--n>0)
			head = head.next;
		
		Node second = head.next;
		head.next = null;
		return second;
	}
	
	

	private boolean palindromeCHeck(Node head) {
		// return palindromeCheckSplit(head);
		//return palindromeCheckStack(head);
		return palindromeCheckStackWithRunner(head);
		//return palindromeCheckRecursive(head);
	}

	public static void main(String[] args) {

		Palindrome obj = new Palindrome();
		
		int[] A = {1};
		Node head = Node.createList(A);
		Node.printList(head,"before");
		System.out.println(obj.palindromeCHeck(head));
		
		int[] A2 = {1,2,3,4,4,3,2,1};
		head = Node.createList(A2);
		Node.printList(head,"before");
		System.out.println(obj.palindromeCHeck(head));
		
		int[] A3 = {1,2,3,4,5,4,3,2,1};
		head = Node.createList(A3);
		Node.printList(head,"before");
		System.out.println(obj.palindromeCHeck(head));
		
		int[] A4 = {1,43,3,4,5,3,2,1};
		head = Node.createList(A4);
		Node.printList(head,"before");
		System.out.println(obj.palindromeCHeck(head));
		
	}
}
