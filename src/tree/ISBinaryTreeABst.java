/**
 * below class will return true is the binary tree is a bst and false if not a bst
 * 
 * time complexity: O(n) where n is the size of tree
 * */
package tree;

public class ISBinaryTreeABst extends Tree {

	private boolean isBst(Tree root, int min, int max) {

		if (root == null)
			return true;

		if (root.data < min || root.data > max)
			return false;

		return isBst(root.left, min, root.data) && isBst(root.right, root.data, max);
	}

	public static void main(String[] args) {
		ISBinaryTreeABst isBst = new ISBinaryTreeABst();
		Tree root = new Tree(10);
		root.left = new Tree(6);
		root.right = new Tree(15);
		root.left.left = new Tree(3);
		root.left.left.left = new Tree(1);
		root.left.right = new Tree(8);
		root.right.right = new Tree(21);
		root.right.left = new Tree(13);
		root.right.right.left = new Tree(18);
		root.right.right.right = new Tree(25);
		System.out.println(isBst.isBst(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
	}

}
