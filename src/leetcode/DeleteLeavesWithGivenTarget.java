/**
 * Given a binary tree root and an integer target, delete all the leaf nodes with value target.
 *
 * Note that once you delete a leaf node with value target, if it's parent node becomes a leaf node and has the value target, it should also be deleted (you need to continue doing that until you can't).
 *
 * Input: root = [1,2,3,2,null,2,4], target = 2
 * Output: [1,null,3,null,4]
 * Explanation: Leaf nodes in green with value (target = 2) are removed (Picture in left).
 * After removing, new nodes become leaf nodes with value (target = 2) (Picture in center).
 */
package leetcode;

import tree.Tree;

public class DeleteLeavesWithGivenTarget {

    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if(root == null) return root;
        root.left = removeLeafNodes(root.left,target);
        root.right = removeLeafNodes(root.right,target);
        if(root.val == target && root.left == null && root.right == null) return null;
        return root;
    }
}
