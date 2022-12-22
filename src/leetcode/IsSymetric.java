/**
 *
 * Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 *
 */
package leetcode;

import tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class IsSymetric {

    public static boolean symetricCheck(TreeNode lroot, TreeNode rroot){

        if((lroot==null && rroot!=null )||(lroot!=null && rroot==null))
            return false;
        if(lroot==null && rroot==null)
            return true;

        if(lroot.val!=rroot.val)
            return false;

        boolean frstHalf = symetricCheck(lroot.left, rroot.right);
        boolean scndHalf = symetricCheck(lroot.right, rroot.left);

        return frstHalf && scndHalf;

    }
    public static boolean isSymmetric(TreeNode root) {
        return symetricCheck(root,root);

    }

    public static void main(String[] a){
        TreeNode root = new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(2);
        root.left.left=new TreeNode(3);
        root.left.right=new TreeNode(4);

        root.right=new TreeNode(2);
        root.right.left=new TreeNode(4);
        //root.right.right=new TreeNode(3);

        System.out.println(isSymmetric(root));
    }
}
