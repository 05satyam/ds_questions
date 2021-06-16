/**
 *
 * Given a binary tree root, a node X in the tree is named good if in the path from root to X there are no nodes with a value greater than X.
 *
 * Return the number of good nodes in the binary tree.
 *
 * Input: root = [3,1,4,3,null,1,5]
 * Output: 4
 * Explanation: Nodes in blue are good.
 * Root Node (3) is always a good node.
 * Node 4 -> (3,4) is the maximum value in the path starting from the root.
 * Node 5 -> (3,4,5) is the maximum value in the path
 * Node 3 -> (3,1,3) is the maximum value in the path.
 */
package leetcode;

import java.util.*;

public class CountGoodNodesInBinaryTree {
    private static int count=0;
    public static  int goodNodes(TreeNode root) {
        PriorityQueue<Integer> pathList = new PriorityQueue<>(Collections.reverseOrder());
        if(root==null)
            return 0;

        //pathList.add(root.val);
        goodNodesUtil(root, pathList);
        return count;
    }

    private static  void goodNodesUtil(TreeNode root, PriorityQueue<Integer> pathList){

        if(root==null){
            return;
        }
        System.out.println("root "+ root.val + " pathlist size "+ pathList.size());
        pathList.add(root.val);
        System.out.println("pathlist size again "+ pathList.size() + "pathList.peek()," + pathList.peek() + "   root.val " +root.val);
        if(pathList.peek()<=root.val){
            count++;
        }
        System.out.println("count "+ count);
        goodNodesUtil(root.left, pathList);
        pathList.remove(root.val);
        goodNodesUtil(root.right, pathList);
    }

    //SOLUTION 2:

    int good;
    public int goodNodes1(TreeNode root) {
        good = 0;
        cal(root, Integer.MIN_VALUE);
        return good;
    }
    void cal(TreeNode root, int max){
        if(root == null) return;
        if(root.val >= max) good++;
        max = Math.max(max, root.val);
        cal(root.left, max);
        cal(root.right, max);
    }


    public static void main(String[] a){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(3);
        root.left.left= new TreeNode(4);

        root.left.right = new TreeNode(2);
        root.right= null;
        //root.right.left = new TreeNode(1);
        System.out.println(goodNodes(root));
    }
}
