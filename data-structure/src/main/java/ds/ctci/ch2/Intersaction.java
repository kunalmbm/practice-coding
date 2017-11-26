package ds.ctci.ch2;

import ds.ctci.Node;

public class Intersaction {

	private Node findIntersaction(Node one, Node two) {
		Node hOne = one, hTwo = two;
		
		while(one!=null || two!=null) {
			
			if(one == null)
				one = hTwo;
			
			if(two == null)
				two = hOne;

			
			if(one == two)
				return one;
			
			one = one.next;
			two = two.next;
			
		}
		
		return null;
	}
	public static void main(String[] args) {

		Intersaction obj = new Intersaction();
		
		int[] A = {1,2,3,4,5,6};
		Node one = Node.createList(A);
		Node.printList(one,"before");

		int[] A2 = {2,3};
		Node two = Node.createList(A2);
		Node.printList(two,"before");
		
		//two.next.next = one.next.next.next;
		
		Node found = obj.findIntersaction(one, two);
		System.out.println(found == null ? "null" : found.data);
		
	}
}
