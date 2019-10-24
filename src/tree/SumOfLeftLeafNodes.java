/***
 * this class print the sum of all the left nodes of bst 
 * 
 */

package tree;

public class SumOfLeftLeafNodes extends Tree {

	public static int sum = 0;

	protected static int sumOfLeftLeafsNodesBST(Tree root) {
		if (root == null)
			return 0;
		if (root.left != null)
			sumOfLeftLeafsNodesBST(root.left);
		if (root.left == null) {
			sum += root.data;
			System.out.println(sum + " " + root.data);
		}
		if (root.right != null && root.right.left != null)
			sumOfLeftLeafsNodesBST(root.right);

		return sum;

	}

	public static void main(String[] args) {
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
		System.out.println(sumOfLeftLeafsNodesBST(root));
	}

}
