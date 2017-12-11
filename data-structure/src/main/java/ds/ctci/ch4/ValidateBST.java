package ds.ctci.ch4;

public class ValidateBST {
	
	boolean validate(TreeNode tree, Integer min, Integer max) {
		
		if(tree == null)
			return true;
		
		if(min!=null && tree.val <= min)
			return false;
		
		if(max!=null && tree.val > max)
			return false;
		
		if(!validate(tree.left,min,tree.val))
			return false;

		return validate(tree.right,tree.val,max);
	}
	
	boolean validateBST(TreeNode tree) {
		return validate(tree,null,null);
	}
	
	private static Integer last = null;
	
	boolean validateInOrder(TreeNode tree) {
		
		if(tree == null)
			return true;
		
		if(!validateInOrder(tree.left))
			return false;
		
		if(last!=null && tree.val <= last)
			return false;
		
		last = tree.val;
		
		return validateInOrder(tree.right);
	}

	public static void main(String[] args) {
		
		ValidateBST obj = new ValidateBST();
		
		TreeNode tree = new TreeNode(20);
		tree.left = new TreeNode(12);
		tree.right = new TreeNode(26);
		
		tree.left.left = new TreeNode(10);
		tree.left.right = new TreeNode(15);
		tree.left.right.left = new TreeNode(13);
		tree.left.right.right = new TreeNode(21);
		
		
		System.out.println("ValidateBST : "+obj.validateBST(tree));
		System.out.println("validateInOrder : "+obj.validateInOrder(tree));
	}
}
