package ds.ctci.ch4;

public class CommonAncestor4 {
	
	static boolean covers(TreeNode tree, TreeNode node) {
		if(tree == null)
			return false;
		if(tree == node)
			return true;
		return covers(tree.left, node) || covers(tree.right, node);
		
	}
	
	
	static TreeNode findCommonAncestor(TreeNode tree, TreeNode p, TreeNode q) {
		
		if(!covers(tree, p) || !covers(tree, q))
			return null;
		
		if(covers(p, q))
			return p;
		
		if(covers(q, p))
			return q;
		
		boolean pIsOnLeft = false;
		boolean qIsOnLeft = false;
		while(true) {
			pIsOnLeft = covers(tree.left, p);
			qIsOnLeft = covers(tree.left, q);
			
			if(pIsOnLeft!=qIsOnLeft)
				return tree;
			
			tree = pIsOnLeft ? tree.left : tree.right;
		}
	}
	
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(11);
		root.right = new TreeNode(12);
		
		root.left.left = new TreeNode(15);
		root.left.right = new TreeNode(16);
		
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(14);

		root.left.right.left = new TreeNode(17);
		root.left.right.right = new TreeNode(18);

		root.left.right.left.left = new TreeNode(19);
		root.left.right.left.right = new TreeNode(20);

		root.left.right.right.right = new TreeNode(21);
		
		root.left.right.left.left.left = new TreeNode(22);
		root.left.right.left.left.right = new TreeNode(23);
		
		TreeNode another = new TreeNode(100);
		
		// 22, 23
		TreeNode n1 = root.left.right.left.left.left;
		TreeNode n2 = root.left.right.left.left.right;
		TreeNode n = findCommonAncestor(root, n1,n2);
		System.out.printf("%d,%d -> %d\n",n1.val,n2.val,(n == null ? -1 : n.val) );
		
		
		// 22, 20
		n1 = root.left.right.left.left.left;
		n2 = root.left.right.left.right;
		n = findCommonAncestor(root, n1,n2);
		System.out.printf("%d,%d -> %d\n",n1.val,n2.val,(n == null ? -1 : n.val) );
		
		// 22, 20
		n1 = root.left.right.left.left.left;
		n2 = root.left.right;
		n = findCommonAncestor(root, n1,n2);
		System.out.printf("%d,%d -> %d\n",n1.val,n2.val,(n == null ? -1 : n.val) );

		// 11, 12
		n1 = root.left;
		n2 = root.right;
		n = findCommonAncestor(root, n1,n2);
		System.out.printf("%d,%d -> %d\n",n1.val,n2.val,(n == null ? -1 : n.val) );
		
		n1 = root.left.right.left.left.left;
		n2 = another;
		n = findCommonAncestor(root, n1,n2);
		System.out.printf("%d,%d -> %d\n",n1.val,n2.val,(n == null ? -1 : n.val) );
		
}

}

