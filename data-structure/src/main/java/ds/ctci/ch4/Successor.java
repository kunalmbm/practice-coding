package ds.ctci.ch4;

public class Successor {
	
	static TreeNode leftMostNode(TreeNode node){
		if(node == null)
			return null;
		
		while(node.left!=null)
			node = node.left;
		
		return node;
	}
	
	static TreeNode firstParentOfLeftChild(TreeNode node) {
		if(node == null)
			return null;
		
		while(node.parent!=null && node.parent.right == node)
			node = node.parent;
		
		return node.parent;
		
	}
	
	static TreeNode findSuccessor(TreeNode node) {
		if(node == null)
			return null;
		
		if(node.right != null) 
			return leftMostNode(node.right);
		
		if(node.parent == null)
			return null;
		
		if(node.parent.left == node)
			return node.parent;
		
		return firstParentOfLeftChild(node);
		
	}
	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.left.parent = root;
		
		root.left.left = new TreeNode(4);
		root.left.left.parent = root.left;

		root.left.right = new TreeNode(7);
		root.left.right.parent = root.left;
		
		root.left.right.left = new TreeNode(6);
		root.left.right.left.parent = root.left.right;
		
		root.left.right.right = new TreeNode(9);
		root.left.right.right.parent = root.left.right;
		
		root.left.right.right.left = new TreeNode(8);
		root.left.right.right.left.parent = root.left.right.right;
		
		root.right = new TreeNode(13);
		root.right.parent = root;

		root.right.left = new TreeNode(12);
		root.right.left.parent = root.right;
		
		root.right.left.left = new TreeNode(11);
		root.right.left.left.parent = root.right.left;

		root.right.right = new TreeNode(15);
		root.right.right.parent = root.right;

		root.right.right.left = new TreeNode(14);
		root.right.right.left.parent = root.right.right;

		TreeNode node = null;
		
		node = findSuccessor(root);
		System.out.printf("Successor of %d is %d\n",root.val,(node == null ? -1 : node.val));
		
		node = findSuccessor(root.right.right);
		System.out.printf("Successor of %d is %d\n",root.right.right.val,(node == null ? -1 : node.val));

		node = findSuccessor(root.right.left.left);
		System.out.printf("Successor of %d is %d\n",root.right.left.left.val,(node == null ? -1 : node.val));

		node = findSuccessor(root.left.right.right);
		System.out.printf("Successor of %d is %d\n",root.left.right.right.val,(node == null ? -1 : node.val));

	}

}
