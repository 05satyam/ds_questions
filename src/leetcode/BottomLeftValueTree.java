/**
 * Given the root of a binary tree, return the leftmost value in the last row of the tree.
 *
 *
 *
 * Example 1:
 * Input: root = [2,1,3]
 * Output: 1
 */
package leetcode;

public class BottomLeftValueTree {
    static int leftMost = 0;
    static int maxLevel = 0;
    public static int findBottomLeftValue(TreeNode root) {
        leftMost = root.val;
         fingBootomVal(root, 0);

         return leftMost;
    }

    private static void fingBootomVal(TreeNode root, int currentLevel){
        if(root==null)
            return ;
        System.out.println("max level "+ maxLevel + " current level "+ currentLevel + " root.val "+ root.val);
        if(maxLevel<currentLevel){
            leftMost=root.val;
            maxLevel=currentLevel;
            System.out.println("maxlevel "+ maxLevel);
        }
        fingBootomVal(root.left, currentLevel+1);
        fingBootomVal(root.right, currentLevel+1);

    }
    public static void main(String [] a){
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right= new TreeNode(3);

        System.out.println(findBottomLeftValue(root));
    }
}
