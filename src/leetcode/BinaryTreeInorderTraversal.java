/**
 * Given the root of a binary tree, return the inorder traversal of its nodes' values.
 *
 *Input: root = [1,null,2,3]
 * Output: [1,3,2]
 */
package leetcode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        inorder(root, res);
        return res;
    }

    void inorder(TreeNode root, List<Integer> res){
        if(root==null)
            return;

        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }
}
