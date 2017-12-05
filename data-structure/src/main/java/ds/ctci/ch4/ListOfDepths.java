package ds.ctci.ch4;
import java.util.*;

public class ListOfDepths {
	

	public ArrayList<ArrayList<TreeNode>> getListOfDepths(TreeNode tree) {
		
		ArrayList<ArrayList<TreeNode>> result = new ArrayList<ArrayList<TreeNode>>();
		prepareDFS(tree,0,result);
		return result;
		
	}
	
	public ArrayList<ArrayList<TreeNode>> getListOfDepthsBFS(TreeNode tree) {
		ArrayList<ArrayList<TreeNode>> result = new ArrayList<ArrayList<TreeNode>>();
		ArrayList<TreeNode> current = new ArrayList<TreeNode>();
		if(tree!=null)
			current.add(tree);
		
		while(current.size()>0) {
			result.add(current);
			ArrayList<TreeNode> parents = current;
			current = new ArrayList<TreeNode>();
			for(TreeNode parent : parents) {
				if(parent.left!=null)
					current.add(parent.left);
				if(parent.right!=null)
					current.add(parent.right);
			}
		}
		
		return result;
	}
	
	private void prepareDFS(TreeNode tree, int d, ArrayList<ArrayList<TreeNode>> result) {
		
		if(tree == null)
			return;

		ArrayList<TreeNode> list;
		if(d == result.size()) {
			list = new ArrayList<TreeNode>();
			result.add(list);
		} else 
			list = result.get(d);
		
		list.add(tree);
		prepareDFS(tree.left,d+1,result);
		prepareDFS(tree.right,d+1,result);
	}
	
	public static void main(String[] args) {
		
		ListOfDepths obj = new ListOfDepths();
		
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(10);
		root.left.right = new TreeNode(15);
		root.left.right.right = new TreeNode(76);
		root.left.right.right.left = new TreeNode(35);
		
		root.right = new TreeNode(25);
		root.right.left = new TreeNode(50);
		root.right.right = new TreeNode(16);
		
		ArrayList<ArrayList<TreeNode>> result = obj.getListOfDepths(root);
		//result = obj.getListOfDepthsBFS(root);
		for(ArrayList<TreeNode> list : result) {
			System.out.println(list);
		}
	}

}
