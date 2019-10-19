/**
 * this is the base class of tree and consist of all the common utilities
 * **/

package tree;

import com.sun.javafx.iio.common.RoughScaler;

public class Tree {
	protected int data;
	protected Tree left;
	protected Tree right;

	protected void createNewNode(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}

	Tree() {

	}

	Tree(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}

	protected void printInOrder(Tree root) {
		if (root == null) {
			return;
		}

		printInOrder(root.left);
		System.out.print(root.data + " ");
		printInOrder(root.right);
	}

	protected void preOrder(Tree root) {
		if (root == null) {
			return;
		}
		System.out.print(root.data + " ");

		preOrder(root.left);
		preOrder(root.right);
	}

	protected void postOrder(Tree root) {
		if (root == null) {
			return;
		}

		preOrder(root.left);
		preOrder(root.right);
		System.out.print(root.data + " ");
	}

	protected int heightOfTree(Tree root) {
		if (root == null)
			return 0;
		int leftHeight = heightOfTree(root.left);
		int rigtHeight = heightOfTree(root.right);
		return leftHeight > rigtHeight ? leftHeight + 1 : rigtHeight + 1;
	}

	protected int diameterOfTree(Tree root) {
		if (root == null)
			return 0;
		int lheight = heightOfTree(root.left);
		int rheight = heightOfTree(root.right);

		int ldiameter = diameterOfTree(root.left);
		int rdiameter = diameterOfTree(root.right);

		return Math.max(lheight + rheight + 1, Math.max(ldiameter, rdiameter));
	}
}
