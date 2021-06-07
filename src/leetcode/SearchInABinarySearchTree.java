/**
 * You are given the root of a binary search tree (BST) and an integer val.
 *
 * Find the node in the BST that the node's value equals val and return the subtree rooted with that node. If such a node does not exist, return null.
 *
 * Input: root = [4,2,7,1,3], val = 2
 * Output: [2,1,3]
 */
package leetcode;

public class SearchInABinarySearchTree {
    public static TreeNode searchBST(TreeNode root, int val) {
            if(root==null)
                return null;
            if(root.val==val)
                return root;

            TreeNode subTree = searchBST(root.left, val);
            if(subTree!=null)
                return subTree;


        subTree = searchBST(root.right,val);
        if(subTree!=null)
            return subTree;

        return null;


    }

    public static void  main(String[] a){
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        System.out.println(searchBST(root,  5));


        System.out.println(searchBST(root,  2).val);
    }
}
