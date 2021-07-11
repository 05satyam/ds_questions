/**
 * Given the root of a binary tree, construct a string consists of parenthesis and integers from a binary tree with the preorder traversing way, and return it.
 *
 * Omit all the empty parenthesis pairs that do not affect the one-to-one mapping relationship between the string and the original binary tree.
 */
package leetcode;

public class ConstructStringFromBinaryTree {
    public String tree2str(TreeNode t) {
        if(t == null) {
            return  "";
        }
        StringBuilder sb = new StringBuilder();
        build(t, sb);
        return sb.toString();
    }

    public void build(TreeNode node, StringBuilder sb) {
        sb.append(node.val);
        if(node.left != null) {
            sb.append("(");
            build(node.left, sb);
            sb.append(")");
        } else if(node.right != null) {
            sb.append("()");
        }


        if(node.right != null){
            sb.append("(");
            build(node.right, sb);
            sb.append(")");
        }

    }
}
