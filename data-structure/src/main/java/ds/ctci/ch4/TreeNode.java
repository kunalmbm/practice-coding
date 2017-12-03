package ds.ctci.ch4;

public class TreeNode {
	
	int val;
	TreeNode left,right;
	public TreeNode(int value) {
		val = value;
	}

	public void printInOrderTraversal() {
		System.out.print("InOrder: ");
		printInOrderTraversal(this);
		System.out.println();
	}
	
	private void printInOrderTraversal(TreeNode node) {
		if(node == null)
			return;
		
		printInOrderTraversal(node.left);
		System.out.printf("%d ",node.val);
		printInOrderTraversal(node.right);
	}

	public void printPreOrderTraversal() {
		System.out.print("PreOrder: ");
		printPreOrderTraversal(this);
		System.out.println();
	}

	private void printPreOrderTraversal(TreeNode node) {
		if(node == null)
			return;
		
		System.out.printf("%d ",node.val);
		printPreOrderTraversal(node.left);
		printPreOrderTraversal(node.right);
	}

	public void printPostOrderTraversal() {
		System.out.print("PostOrder: ");
		printPostOrderTraversal(this);
		System.out.println();
	}
	
	private void printPostOrderTraversal(TreeNode node) {
		if(node == null)
			return;
		
		printPostOrderTraversal(node.left);
		printPostOrderTraversal(node.right);
		System.out.printf("%d ",node.val);
	}
	
	public void printAllTraveral() {
		printInOrderTraversal();
		printPreOrderTraversal();
		printPostOrderTraversal();
		
	}
}
