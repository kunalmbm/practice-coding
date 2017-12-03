package ds.ctci.ch4;

public class ListOfDepths {
	
	ListNode[] A = new ListNode[0];
	
	void ensureSize(int size) {
		if(size > A.length) {
			ListNode[] A2 = new ListNode[size];
			for(int i =0; i < A.length ; i++)
				A2[i] = A[i];
			A = A2;
		}
	}
	
	private void addToList(int d, int val) {
		ListNode node = new ListNode(val);
		ensureSize(d+1);
		node.next = A[d];
		A[d] = node;
		return;
	}
	
	public ListNode[] getListOfDepths(TreeNode tree) {
		prepare(tree,0);
		return A;
		
	}
	
	private void prepare(TreeNode tree, int d) {
		
		if(tree == null)
			return;
		
		prepare(tree.right,d+1);
		prepare(tree.left,d+1);
		addToList(d,tree.val);
		
	}
	
	public static void main(String[] args) {
		
		ListOfDepths obj = new ListOfDepths();
		
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(10);
		root.left.right = new TreeNode(15);
		root.left.right.right = new TreeNode(76);
		root.left.right.right.left = new TreeNode(35);
		
		root.right = new TreeNode(25);
		root.right.left = new TreeNode(50);
		root.right.right = new TreeNode(16);
		
		ListNode[] A = obj.getListOfDepths(root);
		for(ListNode node : A)
			ListNode.printList(node);
	}

}
