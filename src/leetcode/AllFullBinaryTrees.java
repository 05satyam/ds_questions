package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

 /*class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
*/
public class AllFullBinaryTrees {

     public List<TreeNode> allPossibleFBT(int n) {
         HashMap<Integer, List<TreeNode>> map = new HashMap<>();
         // mapping of no. of Node left -> structure of Trees
         // number -> tree1, tree2, tree3 ....

         if(n % 2 == 0) return new ArrayList<>();

         for(int i = 0; i <= n+1; i++) {
             map.put(i, new ArrayList<>());
         }

         // intially tree with 1 node has only one way
         map.get(1).add(new TreeNode(0));

         for(int i = 3; i <= n; i+=2) {
             for(int left = 1; left < i-1; left += 2) {
                 int right = i - left - 1;
                 for(TreeNode leftSubTreeNode : map.get(left)) {
                     for(TreeNode rightSubTreeNode : map.get(right)) {
                         // for every above combination create new tree
                         // root of new tree
                         TreeNode root = new TreeNode(0);
                         root.left = leftSubTreeNode;
                         root.right = rightSubTreeNode;
                         // no need to clone as nodes are not altered and just
                         // used to point from newly created root as above
                         map.get(i).add(root); // saving without cloning
                     }
                 }
             }
         }
         return map.get(n);
     }
}
