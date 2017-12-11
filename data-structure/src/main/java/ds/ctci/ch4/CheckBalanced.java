package ds.ctci.ch4;

public class CheckBalanced {
	
	private class Result {
		int height;
		boolean isBalanced;
		public Result(int height, boolean isBalanced){
			this.height = height;
			this.isBalanced = isBalanced;
		}
	}
	
	public boolean checkBalanced(TreeNode tree) {
		Result res = checkBalancedDFS(tree);
		return res.isBalanced;
	}
	
	private Result checkBalancedDFS(TreeNode tree) {
		
		if(tree == null)
			return new Result(0,true);
		
		Result res1 = checkBalancedDFS(tree.left);
		if(!res1.isBalanced)
			return res1;
		
		Result res2 = checkBalancedDFS(tree.right);
		if(!res2.isBalanced)
			return res2;
		
		if(Math.abs(res1.height - res2.height)>1) {
			res1.isBalanced = false;
			return res1;
		}
		
		if(res2.height > res1.height)
			res1.height = res2.height;
		
		res1.height++;
		
		return res1;
	}
	
	
	public static void main(String[] args) {
		
		CheckBalanced obj = new CheckBalanced();
		
		TreeNode tree = new TreeNode(10);
		tree.left = new TreeNode(11);
		tree.right = new TreeNode(12);
		
		tree.left.left = new TreeNode(13);
		//tree.left.right = new TreeNode(13);
		tree.left.left.right = new TreeNode(13);
		
		tree.right.left = new TreeNode(12);

		
		System.out.println("isBalanced : " + obj.checkBalanced(tree));
	}

}
