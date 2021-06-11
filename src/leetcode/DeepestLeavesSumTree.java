package leetcode;

 class TreeNode11 {
      int val;
      TreeNode11 left;
      TreeNode11 right;
      TreeNode11() {}
      TreeNode11(int val) { this.val = val; }
      TreeNode11(int val, TreeNode11 left, TreeNode11 right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
public class DeepestLeavesSumTree {
    private static int maxLevel=0;
    private static int maxLevelNodeSum=0;
    //SOLUTION 1:-----------------------------
    public static int deepestLeavesSum(TreeNode11 root) {
        deepestLevel(root, 0);
        System.out.println(maxLevel);

        findDeepestLevelSun(root, 0);
        return maxLevelNodeSum;
    }
    public static void deepestLevel(TreeNode11 root, int nodeNumber){
        if(root==null)
            return;
        System.out.println("nodeNumber "+ nodeNumber);
        if(root!=null && root.left==null && root.right==null){
           maxLevel =  maxLevel<nodeNumber?nodeNumber: maxLevel;
            return ;
        }

        deepestLevel(root.left, nodeNumber+1);
        deepestLevel(root.right, nodeNumber+1);
    }

    public static void findDeepestLevelSun(TreeNode11 root, int nodeCount){
        if(root==null)
            return;
        System.out.println("node count "+ nodeCount);
        if(root!=null && root.left==null && root.right==null){
            if(nodeCount>=maxLevel)
                maxLevelNodeSum+= root.val;
            return;
        }

        findDeepestLevelSun(root.left, nodeCount+1);
        findDeepestLevelSun(root.right,nodeCount+1);
    }


    //SOLUTION 2:-------------------------------
    private int maxLevel1 = 0;
    private int sum = 0;

    public int deepestLeavesSum(TreeNode root) {
        if(root == null) return 0;
        calculateSumAtLevel(root,0);
        return sum;

    }

    private void calculateSumAtLevel(TreeNode root,int level){

        if(root == null) return;
        if(level > maxLevel1){
            sum = 0;
            maxLevel1 = level;
        }
        if(level == maxLevel1){
            sum = sum + root.val;
        }
        calculateSumAtLevel(root.left,level+1);
        calculateSumAtLevel(root.right,level+1);
    }
    //----------------------
    public static void main(String[] a){
        TreeNode11 root = new TreeNode11(6);
        root.left= new TreeNode11(7);
        root.right= new TreeNode11(8);
        root.left.left = new TreeNode11(2);
        root.left.right= new TreeNode11(7);
        root.left.left.left= new TreeNode11(9);
        root.left.right.left= new TreeNode11(1);
        root.left.right.right= new TreeNode11(4);

        root.right.left = new TreeNode11(1);
        root.right.right = new TreeNode11(3);
        root.right.right.right = new TreeNode11(5);
        System.out.println(deepestLeavesSum(root));
    }
}
