/**
 * Given a binary tree with the following rules:
 *
 * root.val == 0
 * If treeNode.val == x and treeNode.left != null, then treeNode.left.val == 2 * x + 1
 * If treeNode.val == x and treeNode.right != null, then treeNode.right.val == 2 * x + 2
 * Now the binary tree is contaminated, which means all treeNode.val have been changed to -1.
 *
 * Implement the FindElements class:
 *
 * FindElements(TreeNode* root) Initializes the object with a contaminated binary tree and recovers it.
 * bool find(int target) Returns true if the target value exists in the recovered binary tree.
 *
 * Input
 * ["FindElements","find","find","find"]
 * [[[-1,-1,-1,-1,-1]],[1],[3],[5]]
 * Output
 * [null,true,true,false]
 * Explanation
 * FindElements findElements = new FindElements([-1,-1,-1,-1,-1]);
 * findElements.find(1); // return True
 * findElements.find(3); // return True
 * findElements.find(5); // return False
 */
package leetcode;

import java.util.HashSet;
import java.util.Set;

public class FindElementsInAContaminatedBinaryTree {

    Set<Integer> treeElem = new HashSet<>();
    public FindElementsInAContaminatedBinaryTree(TreeNode root) {
        TreeNode newRoot = new TreeNode();
        newRoot.val=0;
        buildNewTree(newRoot);
    }
    public void buildNewTree(TreeNode root){
        if(root.left!=null){
            treeElem.add(2*(root.val)+1);
            root.left.val = 2*(root.val)+1;
            buildNewTree(root.left);
        }
        if(root.right!=null){
            treeElem.add(2*(root.val)+2);
            root.right.val = 2*(root.val)+2;
            buildNewTree(root.right);
        }
    }
    public boolean find(int target) {
        return treeElem.contains(target);
    }
}
