/*
* Given a binary tree, return the sum of values of nodes with even-valued grandparent.  (A grandparent of a node is the parent of its parent, if it exists.)

If there are no nodes with an even-valued grandparent, return 0.
* Input: root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
Output: 18
Explanation: The red nodes are the nodes with even-value grandparent while the blue nodes are the even-value grandparents.
* */
package leetcode;

import tree.Tree;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class SumOfNodesWithEvenValuedGranParents {
    public static int sum = 0;
    public static int sumEvenGrandparent(TreeNode root) {
        sumEvenUtil(root);
        return sum;
    }



    public static void sumEvenUtil(TreeNode root) {
        if (root == null)
            return;
        if (root.val % 2 == 0) {
            if (root.left != null) {
                if (root.left.left != null) {
                    sum += root.left.left.val;
                }
                if (root.left.right != null) {
                    sum += root.left.right.val;
                }

            }
            if (root.right != null) {
                if (root.right.left != null)
                    sum = sum + root.right.left.val;
                if (root.right.right != null)
                    sum = sum + root.right.right.val;
            }
        }
        sumEvenUtil(root.left);
        sumEvenUtil(root.right);
    }

    public static void main(String[] a) {
        TreeNode treeNode = new TreeNode(6, null, null);

        treeNode.left = new TreeNode(7, null, null);
        treeNode.right = new TreeNode(5, null, null);
        treeNode.left.left = new TreeNode(2, null, null);
        treeNode.left.right = new TreeNode(4, null, null);
        treeNode.right.left = new TreeNode(8, null, null);
        treeNode.right.right = new TreeNode(4, null, null);
        System.out.println(treeNode.left.val + "  " + treeNode.right.val);
        System.out.println(sumEvenGrandparent(treeNode));
    }
}
