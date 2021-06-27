/**
 * Given a binary tree, find its minimum depth.
 *
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 *
 * Note: A leaf is a node with no children.
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 2
 * Example 2:
 *
 * Input: root = [2,null,3,null,4,null,5,null,6]
 * Output: 5
 */
package leetcode;

public class MinimumDepthOfBinaryTree {
    int minDepth = Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        if(root==null)
            return 0;
        findMinDepth(root, 0);
        return minDepth;
    }

    void findMinDepth(TreeNode root, int dpth){
        if(root==null)
            return;

        if(root.left==null && root.right==null){
            if(minDepth>dpth){
                minDepth=dpth;
                return;
            }
        }

        findMinDepth(root.left, dpth+1);
        findMinDepth(root.right, dpth+1);
    }
}
