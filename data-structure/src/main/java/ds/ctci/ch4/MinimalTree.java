package ds.ctci.ch4;

public class MinimalTree {
	
	public TreeNode convertToMinimalTree(int[] A) {
		return makeMinimalTree(A,0,A.length-1);
	}
	
	private TreeNode makeMinimalTree(int[] A, int lo, int hi) {
		if(lo>hi)
			return null;
		int m = (lo+hi)/2;
		if((lo+hi)%2 == 1)
			m++;
		
		TreeNode node = new TreeNode(A[m]);
		node.left = makeMinimalTree(A,lo,m-1);
		node.right = makeMinimalTree(A,m+1,hi);
		
		return node;
	}
	
	public static void main(String[] args) {
		
		MinimalTree obj = new MinimalTree();
		
		int[] A = {2,3,5,7,8,15,16,50};
		TreeNode tree = obj.convertToMinimalTree(A);
		tree.printAllTraveral();
		
	}

}
