package ds.ctci.ch4;

public class ListNode {
	
	int data;
	ListNode next;
	public ListNode(int value) {
		data = value;
	}
	
	public static void printList(ListNode node) {
		
		System.out.print("ListNode: ");
		while(node!=null){
			System.out.printf("-> %d", node.data);
			node = node.next;
		}
		System.out.println();

	}


}
