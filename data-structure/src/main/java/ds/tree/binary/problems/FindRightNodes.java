package ds.tree.binary.problems;

import ds.tree.binary.BinaryTreeNode;
import ds.util.ArrayUtility;
import ds.util.BinaryTreeUtility;
import ds.util.ReadInputUtility;

public class FindRightNodes {
	
	public static void main(String[] args) {
		
		int[][] data = {{10,1,2,3,4,-1,5, -1, -1, -1, -1, -1, -1}};
		data = ReadInputUtility.readBinaryTreeTestData("/test-input/BinaryTree.txt");
		
		for (int[] arr : data) {
			int n = arr.length;
			int[] dArr = new int[1];

			ArrayUtility.printArray(arr, n, "input arr : ");
			BinaryTreeNode node = BinaryTreeUtility.convertToBinaryTree(arr, n);
			BinaryTreeUtility.updateBinaryTreeDepth(node, 0, dArr);
			BinaryTreeUtility.printBinaryTree(node);
			System.out.println(" - tree depth : " + dArr[0]);
			
			
			int depth = dArr[0];
			int[] out = new int[depth];
			BinaryTreeUtility.findRightNodes(0, node, depth, out);
			ArrayUtility.printArray(out, depth, "right nodes : ");
		}
	}

}
