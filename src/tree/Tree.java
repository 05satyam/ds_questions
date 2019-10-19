package tree;

public class Tree {
	protected int data;
	protected Tree left;
	protected Tree right;

	protected void createNewNode(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
	
	protected void printInOrder(Tree root) {
		if(root== null) {
			return ;
		}
		
		printInOrder(root.left);
		System.out.print(root.data + " ");
		printInOrder(root.right);
	}
}
