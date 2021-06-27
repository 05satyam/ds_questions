/**
 * Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.
 *
 * A leaf is a node with no children.
 *
 * Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
 * Output: true
 */
package leetcode;

public class PathSum {

    public boolean hasPathSum(TreeNode root, int targetSum) {
     int sum=0;
     return pathSum(root, targetSum, sum);
    }

    boolean pathSum(TreeNode root, int targerSum, int sum){
        if(root==null)
            return false;
        sum+=root.val;
        if(root.right==null && root.left==null){
            if(targerSum==sum)
                return true;

            return false;
        }

        if(pathSum(root.right, targerSum, sum))
            return true;

        if(pathSum(root.left, targerSum, sum))
            return true;

        return false;
    }
}
