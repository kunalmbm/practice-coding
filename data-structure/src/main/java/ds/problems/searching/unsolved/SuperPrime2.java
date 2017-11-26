package ds.problems.searching.unsolved;

import java.util.Scanner;

public class SuperPrime2 {

	private static Node first;
	private static Node last;
	private static int lastCount;
	

	private class Node {

		private int data;
		private boolean superPrime = false;
		private Node next = null;

		private Node(int data, boolean superPrime) {
			this.data = data;
			this.superPrime = superPrime;
		}

	}
	
	private void process() {

/*
2
5
44

 */
		last = first = new Node(3,false);
		lastCount = 0;
		
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0) {
			int N = sc.nextInt();
			int c = findCountOfSuperPrimes(N);
			System.out.println(c);
		}
		sc.close();
		
	}

	public int findCountOfSuperPrimes(int N) {
		
		if(N < 5)
			return 0;
		
		int c = 0;
		if(N <= (last.data + 1)) {
			//System.out.println("caseone found");
			Node node = first;
			while(node!=null && node.data <= N) {
				c += node.superPrime ? 1 : 0;
				node = node.next;
			}
			return c;
		}
		
		int num = last.data + 2;
		c = lastCount;
		while(num <= N) {
			checkSuperPrime(num, first);
			num+= 2;
		}
		
		/*Node node = first;
		while(node!=null) {
			
			if(node.superPrime)
				System.out.printf("(%d) ", node.data);
			else
				System.out.printf("%d ", node.data);
			
			node = node.next;
		}
		System.out.println("-----");*/
		return lastCount;
	}

	public void checkSuperPrime(int num, Node node) {
		
		Node prev = null;
		while(node!=null) {
			if(num%node.data == 0)
				return;

			prev = node;
			node = node.next;
		}
		
		// num is a prime number : 
		
		boolean flag = (prev!=null && num == (prev.data + 2)) ? true : false;
		last = prev.next = new Node(num,flag);
		lastCount += flag ? 1 : 0;

	}

	public static void main(String[] args) {
		SuperPrime2 obj = new SuperPrime2();
		obj.process();
	}
}

