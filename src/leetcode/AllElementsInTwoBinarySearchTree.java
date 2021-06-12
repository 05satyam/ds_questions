/**
 * Given two binary search trees root1 and root2.
 *
 * Return a list containing all the integers from both trees sorted in ascending order.
 *
 * Input: root1 = [2,1,4], root2 = [1,0,3]
 * Output: [0,1,1,2,3,4]
 * Example 2:
 *
 * Input: root1 = [0,-10,10], root2 = [5,1,7,0,2]
 * Output: [-10,0,0,1,2,5,7,10]
 */
package leetcode;

import java.util.*;
import java.util.stream.Collectors;

class TreeNode111 {
      int val;
      TreeNode111 left;
      TreeNode111 right;
      TreeNode111() {}
      TreeNode111(int val) { this.val = val; }
      TreeNode111(int val, TreeNode111 left, TreeNode111 right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
public class AllElementsInTwoBinarySearchTree {
    public static List<Integer> getAllElements(TreeNode111 root1, TreeNode111 root2) {
        List<Integer> resList = new ArrayList<>();
        if (root1 == null && root2 == null)
            return resList;
        Queue<Integer> pq = new PriorityQueue<>((x, y) -> Integer.compare(x,y));
        traverseTree(root1, pq);
        traverseTree(root2, pq);

        while(!pq.isEmpty())
            resList.add(pq.poll());
        return  resList;
    }
    private static void traverseTree(TreeNode111 root, Queue<Integer> pq){
        if(root==null)
            return;;

        traverseTree(root.left, pq);
        pq.add(root.val);
        traverseTree(root.right, pq);
    }
    public static void main(String[] a){
        TreeNode111 root1  = new TreeNode111(2);
        root1.left  = new TreeNode111(1);
        root1.right = new TreeNode111(4);

        TreeNode111 root2  = new TreeNode111(1);
        root2.left  = new TreeNode111(0);
        root2.right = new TreeNode111(3);
        System.out.println(Arrays.toString(getAllElements(root1, root2).toArray()));


    }
}
