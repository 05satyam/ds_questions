/**
 * below classw will return true/false after checking if two given trees are identical or not
 * 
 * time complexity: O(n) where n is the length of tree
 * */

package tree;

public class IsSameTree extends Tree {

	private boolean isSameTree(Tree root1, Tree root2) {
		if (root1 == null && root2 == null)
			return true;

		if (root1 == null || root2 == null)
			return false;

		if (root1.data != root2.data)
			return false;

		return isSameTree(root1.left, root2.left) && isSameTree(root1.right, root2.right);
	}

	public static void main(String[] args) {

		Tree root1 = new Tree(10);
		root1.left = new Tree(6);
		root1.right = new Tree(15);
		root1.left.left = new Tree(3);
		root1.left.left.left = new Tree(1);
		root1.left.right = new Tree(8);
		root1.right.right = new Tree(21);
		root1.right.left = new Tree(13);
		root1.right.right.left = new Tree(18);
		root1.right.right.right = new Tree(25);

		Tree root2 = new Tree(10);
		root2.left = new Tree(6);
		root2.right = new Tree(15);
		root2.left.left = new Tree(3);
		root2.left.left.left = new Tree(1);
		root2.left.right = new Tree(8);
		root2.right.right = new Tree(21);
		root2.right.left = new Tree(13);
		root2.right.right.left = new Tree(18);
		root2.right.right.right = new Tree(25);
		IsSameTree same = new IsSameTree();
		System.out.println(same.isSameTree(root1, root2));
	}

}
