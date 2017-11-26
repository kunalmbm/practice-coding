package ds.problems.searching.unsolved;

import java.util.Scanner;

public class SuperPrime {

	private static Node node;

	private class Node {

		int data;
		boolean superPrime = false;
		Node next = null;

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
		node = new Node(3,false);

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0) {
			int N = sc.nextInt();
			int c = foundNumberOFSuperPrime(N);
			System.out.println(c);
		}
		sc.close();
		
	}

	public int foundNumberOFSuperPrime(int N) {
		
		if(N < 5)
			return 0;

		int c = 0;
		int num = 5;
		while(num <= N) {
			c+=isSuperPrime(num, node);
			num+= 2;
		}
		
		/*while(node!=null) {
			
			if(node.superPrime)
				System.out.printf("(%d) ", node.data);
			else
				System.out.printf("%d ", node.data);
			
			node = node.next;
		}
		System.out.println("-----");*/
		
		return c;
	}

	public int isSuperPrime(int num, Node node) {
		
		Node prev = null;
		while(node!=null) {
			if(num%node.data == 0)
				return 0;
			
			prev = node;
			node = node.next;
		}
		
		boolean flag = false;
		if(prev!=null && num == (prev.data + 2))
			flag = true;
		
		prev.next = new Node(num,flag);
		
		return flag ? 1 : 0;

	}

	public static void main(String[] args) {
		SuperPrime obj = new SuperPrime();
		obj.process();
	}
}
