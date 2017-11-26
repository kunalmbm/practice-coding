package ds.ctci.ch2;

import ds.ctci.Node;

public class ASample {

	public static void main(String[] args) {

		ASample obj = new ASample();
		
		int[] A = {1,2,3,4};
		Node head = Node.createList(A);
		Node.printList(head,"before");

		
	}
}
