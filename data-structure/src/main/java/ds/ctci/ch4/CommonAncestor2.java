package ds.ctci.ch4;

public class CommonAncestor2 {
	
	static int depth(TreeNode node) {
		if(node == null)
			return -1;

		int d = 0;
		while(node.parent!=null) {
			d++;
			node = node.parent;
		}
		return d;
	}
	
	static TreeNode findCommonAncestor(TreeNode tree, TreeNode n1, TreeNode n2) {
		int d1 = depth(n1);
		int d2 = depth(n2);
		
		while(d1 > d2) {
			n1 = n1.parent;
			d1--;
		}
		
		while(d2 > d1) {
			n2 = n2.parent;
			d2--;
		}
		
		while(n1!=n2) {
			n1 = n1.parent;
			n2 = n2.parent;
		}
		
		return n1;
	}
	
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(11); root.left.parent = root;
		root.right = new TreeNode(12);root.right.parent = root;
		
		root.left.left = new TreeNode(15); root.left.left.parent = root.left;
		root.left.right = new TreeNode(16); root.left.right.parent = root.left;
		
		root.right.left = new TreeNode(13);  root.right.left.parent = root.right;
		root.right.right = new TreeNode(14);  root.right.right.parent = root.right;

		root.left.right.left = new TreeNode(17);  root.left.right.left.parent = root.left.right;
		root.left.right.right = new TreeNode(18);  root.left.right.right.parent = root.left.right;

		root.left.right.left.left = new TreeNode(19); root.left.right.left.left.parent = root.left.right.left;
		root.left.right.left.right = new TreeNode(20); root.left.right.left.right.parent = root.left.right.left;

		root.left.right.right.right = new TreeNode(21); root.left.right.right.right.parent = root.left.right.right;
		
		root.left.right.left.left.left = new TreeNode(22); root.left.right.left.left.left.parent = root.left.right.left.left;
		root.left.right.left.left.right = new TreeNode(23); root.left.right.left.left.right.parent = root.left.right.left.left;
		
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
