package ds.util;

import ds.tree.binary.BinaryTreeNode;

public class BinaryTreeUtility {

	/**
	 * Negative numbers (-1) denote the null element 
	 * @param arr
	 * @param n
	 * @return
	 */
	public static BinaryTreeNode convertToBinaryTree(int[] arr, int n) {
		BinaryTreeNode[] bArr = new BinaryTreeNode[n];

		BinaryTreeNode node = new BinaryTreeNode(arr[0]);
		bArr[0] = node;
		int c=1;
		for(int r = 0; r <n ; r++) {
			if(arr[r] < 1)
				continue;
			
			node = bArr[r];
			node.left(createChildNode(c++,arr,bArr));
			node.right(createChildNode(c++,arr,bArr));

		}
		
		return bArr[0];
	}
	
	private static BinaryTreeNode createChildNode(int i, int[] arr, BinaryTreeNode[] bArr) {
		
		if(arr[i] < 1)
			return null;
		
		BinaryTreeNode node = new BinaryTreeNode(arr[i]);
		bArr[i] = node;
		
		return node;
		
	}
 

	public static void printBinaryTree(BinaryTreeNode node) {
		
		if(node == null) {
			System.out.print("N");
			return;
		}
		
		System.out.printf("%d (", node.data());
		printBinaryTree(node.left());
		System.out.printf(", ");
		printBinaryTree(node.right());
		System.out.printf(")");
	}
	
	public static void updateBinaryTreeDepth(BinaryTreeNode node, int level, int[] arr) {
		
		if(node == null)
			return;
		
		level++;
		if(arr[0] < level)
			arr[0] = level;
		
		BinaryTreeNode[] tmp = {node.right(),node.left()};
		for (BinaryTreeNode cNode : tmp) {
			updateBinaryTreeDepth(cNode, level, arr);
		}
	}
	
	
	public static void findRightNodes(int level, BinaryTreeNode node, int depth, int[] arr) {
		
		if(level>=depth)
			return;
		
		if(arr[level] == 0)
			arr[level] = node.data();

		BinaryTreeNode[] tmp = {node.right(),node.left()};
		for (BinaryTreeNode cNode : tmp) {
			if(cNode == null)
				continue;
			findRightNodes(level+1, cNode, depth, arr);
		}
		
	}
}
