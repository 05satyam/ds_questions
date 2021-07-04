/**
 * print preorder of binary tree
 *
 */
package leetcode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreorder {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        getPreorder(root, res);
        return res;
    }

    void getPreorder(TreeNode root, List<Integer> res){
        if(root==null)
            return;

        res.add(root.val);
        getPreorder(root.left, res);
        getPreorder(root.right, res);
    }
}
