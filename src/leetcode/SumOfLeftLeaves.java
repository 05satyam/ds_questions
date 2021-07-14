package leetcode;

public class SumOfLeftLeaves {
    int sum=0;
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        int sum = 0;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            sum += root.left.val;
        } else {
            sum += sumOfLeftLeaves(root.left);
        }
        sum += sumOfLeftLeaves(root.right);
        return sum;
    }

    //solution2
    public int sumOfLeftLeaves2(TreeNode root) {
        return sumOfLefts(root, false);
    }

    private int sumOfLefts(TreeNode node, boolean leftChild) {
        if(node == null)
            return 0;
        if(leftChild && node.left == null && node.right == null)
            return node.val;
        else
            return sumOfLefts(node.left, true) + sumOfLefts(node.right, false);
    }


}
