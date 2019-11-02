/**
 * Object of this class is to return the max number of nodes in a binary tree from 
 * a tree which is largest bst in the whole tree
 * 
 * I am following post order to complete the task
 * 
 * Time complexity: O(n) where n is the size of binary tree
 * */

package tree;

public class LargestBstInBinaryTree extends Tree {

	public int largestBST(Tree root) {
		MinMax m = largest(root);
		return m.size;
	}

	private MinMax largest(Tree root) {
		if (root == null) {
			return new MinMax();
		}
		MinMax leftMinMax = largest(root.left);
		MinMax rightMinMax = largest(root.right);

		MinMax m = new MinMax();
		if (leftMinMax.isBST == false || rightMinMax.isBST == false
				|| (leftMinMax.max > root.data || rightMinMax.min <= root.data)) {
			m.isBST = false;
			m.size = Math.max(leftMinMax.size, rightMinMax.size);
			return m;
		}
		m.isBST = true;
		m.size = leftMinMax.size + rightMinMax.size + 1;
		m.min = root.left != null ? leftMinMax.min : root.data;
		m.max = root.right != null ? rightMinMax.max : root.data;

		return m;
	}

	public static void main(String args[]) {
		LargestBstInBinaryTree lbi = new LargestBstInBinaryTree();
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
		int largestBSTSize = lbi.largestBST(root);
		System.out.println("Size of largest BST  is " + largestBSTSize);
		assert largestBSTSize == 8;
	}
}

/**
 * Object of this class holds information which child passes back to parent
 * node.
 */
class MinMax {
	int min;
	int max;
	boolean isBST;
	int size;

	MinMax() {
		min = Integer.MAX_VALUE;
		max = Integer.MIN_VALUE;
		isBST = true;
		size = 0;
	}
}