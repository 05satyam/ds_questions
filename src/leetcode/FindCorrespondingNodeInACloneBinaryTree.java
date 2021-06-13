/**
 * Given two binary trees original and cloned and given a reference to a node target in the original tree.
 *
 * The cloned tree is a copy of the original tree.
 *
 * Return a reference to the same node in the cloned tree.
 *
 * Note that you are not allowed to change any of the two trees or the target node and the answer must be a reference to a node in the cloned tree.
 *
 * Follow up: Solve the problem if repeated values on the tree are allowed.
 *
 * Input: tree = [7,4,3,null,null,6,19], target = 3
 * Output: 3
 * Explanation: In all examples the original and cloned trees are shown. The target node is a green node from the original tree. The answer is the yellow node from the cloned tree.
 *
 *
 *
 *
 * Input: tree = [8,null,6,null,5,null,4,null,3,null,2,null,1], target = 4
 * Output: 4
 *
 *
 */
package leetcode;

class TreeNode1111 {
      int val;
      TreeNode1111 left;
      TreeNode1111 right;
      TreeNode1111(int x) { val = x; }
  }
public class FindCorrespondingNodeInACloneBinaryTree {
    private static TreeNode1111 res = null;
    public static final TreeNode1111 getTargetCopy(final TreeNode1111 original, final TreeNode1111 cloned, final TreeNode1111 target) {
        getTargetNode(original, cloned, target);
        return res;
    }

    public static void getTargetNode(TreeNode1111 original, TreeNode1111 cloned, TreeNode1111 target){
        if(original== null || cloned==null)
            return;

        if(cloned.val == target.val){
            res = cloned;
            return;
        }

        getTargetCopy(original.left, cloned.left, target);
        getTargetCopy(original.right, cloned.right, target);
    }

}
