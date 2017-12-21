package ds.ctci.ch4;

import java.util.Stack;

public class CommonAncestor {
	
	enum Type { L , R };

	static boolean findNode(TreeNode tree, TreeNode node, Stack<Type> s) {
		
		if(tree == null | node == null)
			return false;
		
		if(tree == node)
			return true;
		
		s.push(Type.L);
		if(findNode(tree.left,node,s))
			return true;
		s.pop();
		
		s.push(Type.R);
		if(findNode(tree.right,node,s))
			return true;
		s.pop();
		
		return false;
	}
	
	static TreeNode getCommon(TreeNode tree, Stack<Type> s1, Stack<Type> s2) {
		
		while(!s1.isEmpty() && !s2.isEmpty() && s1.peek() == s2.peek()) {
			tree = s1.pop() == Type.L ? tree.left : tree.right;
			s2.pop();
		}
		
		return tree;
	}
	
	static Stack<Type> reverseStack(Stack<Type> s) {
		
		Stack<Type> tmp = new Stack<Type>();
		while(!s.isEmpty())
			tmp.push(s.pop());
		
		return tmp;
	}
	
	static TreeNode findCommonAncestor(TreeNode tree, TreeNode n1, TreeNode n2) {
		
		Stack<Type> s1 = new Stack<Type>();
		Stack<Type> s2 = new Stack<Type>();
		
		if(!findNode(tree, n1, s1))
			return null;
		
		if(!findNode(tree, n2, s2))
			return null;
		
		s1 = reverseStack(s1);
		s2 = reverseStack(s2);
		
		return getCommon(tree, s1, s2);
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

