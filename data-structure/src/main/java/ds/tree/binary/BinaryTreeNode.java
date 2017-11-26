package ds.tree.binary;

public class BinaryTreeNode {

	private int data;
	private BinaryTreeNode left;
	private BinaryTreeNode right;

	public BinaryTreeNode(int data) {
		this.data = data;
	}

	public BinaryTreeNode() {
	}

	public int data() {
		return data;
	}

	public void data(int data) {
		this.data = data;
	}

	public BinaryTreeNode left() {
		return left;
	}

	public void left(BinaryTreeNode left) {
		this.left = left;
	}

	public BinaryTreeNode right() {
		return right;
	}

	public void right(BinaryTreeNode right) {
		this.right = right;
	}

}
