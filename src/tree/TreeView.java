package tree;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class TreeView extends Tree {

	private static int max_level = 0;

	public static void printLeftView(Tree root) {
		printLeftViewUtil(root, 1);
	}

	public static void printLeftViewUtil(Tree root, int level) {
		if (root == null)
			return;

		if (max_level < level) {
			System.out.print(root.data + " ");
			max_level = level;
		}

		printLeftViewUtil(root.left, level + 1);
		printLeftViewUtil(root.right, level + 1);
	}

	public static void printRightView(Tree root) {
		printRightViewUtil(root, 1);
	}

	public static void printRightViewUtil(Tree root, int level) {
		if (root == null)
			return;

		if (max_level < level) {
			System.out.print(root.data + " ");
			max_level = level;
		}

		printLeftViewUtil(root.right, level + 1);
		printLeftViewUtil(root.left, level + 1);
	}

	public static void printTopView(Tree root) {
		if (root == null)
			return;
		Tree temp = null;
		Queue<TreeView.Pair> q = new LinkedList<TreeView.Pair>();
		Map<Integer, Integer> mp = new TreeMap<Integer, Integer>();
		q.add(new Pair(root, 0));
		while (q.size() > 0) {
			temp = q.peek().first;
			int d = q.peek().second;
			q.remove();

			if (mp.get(d) == null) {
				mp.put(d, temp.data);
			}

			if (temp.left != null) {
				q.add(new Pair(temp.left, d - 1));
			}
			if (temp.right != null) {
				q.add(new Pair(temp.right, d + 1));
			}
		}

		System.out.print("Top view: ");
		for (Integer data : mp.values()) {
			System.out.print(data + " ");
		}
	}

	public static void printBottomView(Tree root) {
		if (root == null)
			return;
		Tree temp = null;
		Queue<TreeView.Pair> q = new LinkedList<TreeView.Pair>();
		Map<Integer, Integer> mp = new TreeMap<Integer, Integer>();
		q.add(new Pair(root, 0));
		while (q.size() > 0) {
			temp = q.peek().first;
			int d = q.peek().second;
			q.remove();
			mp.put(d, temp.data);
			if (temp.left != null) {
				q.add(new Pair(temp.left, d - 1));
			}
			if (temp.right != null) {
				q.add(new Pair(temp.right, d + 1));
			}
		}
		System.out.print("Bottom view: ");
		for (Integer data : mp.values()) {
			System.out.print(data + " ");
		}
	}

	public static void main(String[] args) {
		Tree root = new Tree(1);
        root.left = new Tree(2); 
        root.right = new Tree(3); 
        root.left.left = new Tree(4); 
        root.left.right = new Tree(5); 
        root.right.right = new Tree(6); 
        root.right.left = new Tree(7); 
        root.right.right.left = new Tree(8); 
  
		System.out.print("Left view: ");
		printLeftView(root);
		System.out.println();
		System.out.print("Right view: ");
		max_level=0;
		printRightView(root);
		System.out.println();
		printTopView(root);
		System.out.println();
		printBottomView(root);
	}

	static class Pair {
		Tree first;
		int second;

		Pair(Tree t, int a) {
			this.first = t;
			this.second = a;
		}
	}
}
