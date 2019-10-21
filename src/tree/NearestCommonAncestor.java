package tree;

public class NearestCommonAncestor extends Tree {

	public int nearestCommonAncestorBST(Tree root, int a, int b) {

		if (root == null)
			return -1;

		if (root.data > a && root.data < b)
			return root.data;

		if (a < root.data && b < root.data) {
			return nearestCommonAncestorBST(root.left, a, b);
		} else if (root.data < a && root.data < b) {
			return nearestCommonAncestorBST(root.right, a, b);
		} else if (root.data == a || root.data == b) {
			return root.data;
		}
		return -1;
	}

	public static void main(String[] args) {
		Tree root = new Tree(10);
		root.left = new Tree(6);
		root.right = new Tree(15);
		root.left.left = new Tree(3);
		root.left.right = new Tree(8);
		root.right.right = new Tree(21);
		root.right.left = new Tree(13);
		root.right.right.right = new Tree(25);
		NearestCommonAncestor nca = new NearestCommonAncestor();
		System.out.println(nca.nearestCommonAncestorBST(root, 3, 6));
	}

}
