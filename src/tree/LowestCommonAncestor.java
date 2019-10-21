package tree;

import java.util.ArrayList;
import java.util.List;

public class LowestCommonAncestor extends Tree {

	public int lowestCommonAncestorBST(Tree root, int a, int b) {

		if (root == null)
			return -1;

		if (root.data > a && root.data < b)
			return root.data;

		if (a < root.data && b < root.data) {
			return lowestCommonAncestorBST(root.left, a, b);
		} else if (root.data < a && root.data < b) {
			return lowestCommonAncestorBST(root.right, a, b);
		} else if (root.data == a || root.data == b) {
			return root.data;
		}
		return -1;
	}

	/***
	 * 
	 * @param root
	 * @param a
	 * @param b
	 * @return
	 * 
	 * Solution 1: find path to both the nodes with data a, b from root and then find the common intersection node in them
	 */
    private List<Integer> path1 = new ArrayList<>(); 
    private List<Integer> path2 = new ArrayList<>(); 
  
    int lowestCommonAncestorInBinaryTree(Tree root,int n1, int n2) { 
        path1.clear(); 
        path2.clear(); 
        return findLCAInternal(root, n1, n2); 
    } 
  
    private int findLCAInternal(Tree root, int n1, int n2) { 
  
        if (!findPath(root, n1, path1) || !findPath(root, n2, path2)) { 
            System.out.println((path1.size() > 0) ? "n1 is present" : "n1 is missing"); 
            System.out.println((path2.size() > 0) ? "n2 is present" : "n2 is missing"); 
            return -1; 
        } 
        int i; 
        for (i = 0; i < path1.size() && i < path2.size(); i++) { 
              
            if (!path1.get(i).equals(path2.get(i))) 
                break; 
        } 
        return path1.get(i-1); 
    } 
      
    private boolean findPath(Tree root, int n, List<Integer> path) 
    { 
        if (root == null) { 
            return false; 
        } 
        path.add(root.data); 
  
        if (root.data == n) { 
            return true; 
        } 
  
        if (root.left != null && findPath(root.left, n, path)) { 
            return true; 
        } 
  
        if (root.right != null && findPath(root.right, n, path)) { 
            return true; 
        } 
        path.remove(path.size()-1); 
  
        return false; 
    } 
    /****
     * 
     * solution 2: using single traversal ... solution not coded here.
     */
    
    
    
    
	public static void main(String[] args) {
		Tree root = new Tree(10);
		root.left = new Tree(6);
		root.right = new Tree(15);
		root.left.left = new Tree(3);
		root.left.right = new Tree(8);
		root.right.right = new Tree(21);
		root.right.left = new Tree(13);
		root.right.right.right = new Tree(25);
		LowestCommonAncestor nca = new LowestCommonAncestor();
		System.out.println(nca.lowestCommonAncestorBST(root, 3, 6));
	}

}
