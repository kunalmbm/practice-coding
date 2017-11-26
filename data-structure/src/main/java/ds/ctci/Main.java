package ds.ctci;

public class Main {
	
	public int getKthFromLast(Node head, int k) {
		Node curr = head, fast = head;
		while(--k>0)
			fast = fast.next;
		while(fast.next !=null) {
			fast = fast.next;
			curr = curr.next;
		}
		return curr.data;
	}
	
	public static void main(String[] args) {
		
	}

}
