/**
 *
 * Given the root of a binary tree, return the bottom-up level order traversal of its nodes' values. (i.e., from left to right, level by level from leaf to root).
 *
 *
 *
 * Example 1:
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[15,7],[9,20],[3]]
 */
package leetcode;

import tree.Tree;

import java.util.*;

public class BinaryTreeLevelOrderTraversal2 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);
        q.add(new TreeNode(Integer.MIN_VALUE));
        List<List<Integer>> res = new LinkedList<>();

        List<Integer> subList = new LinkedList<>();
        subList.add(root.val);
        res.add(subList);
        int i=1;
        while(q.size()>1){
            System.out.println("inside first while loop");
            subList = new LinkedList<>();

            while(true){
                TreeNode dummy = q.poll();

                System.out.println("dummy val "+ dummy.val);
//                if(i==6)
//                    break;
                if(dummy.val==Integer.MIN_VALUE){
                    if(subList.size()>0)
                        res.add(subList);
                    subList= new LinkedList<>();

                    break;
                }

                if(dummy.left!=null){
                    subList.add(dummy.left.val);
                    q.add(dummy.left);
                }
                if(dummy.right!=null){
                    subList.add(dummy.right.val);
                    q.add(dummy.right);
                }
            }
            System.out.println("q size "+ q.size());
            q.add(new TreeNode(Integer.MIN_VALUE));
            //q.poll();
//            if(i==6) break;
//            i++;
        }
        Collections.reverse(res);
        return res;
    }

    public static void main(String[] a){
        BinaryTreeLevelOrderTraversal2 obj = new BinaryTreeLevelOrderTraversal2();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right= new TreeNode(20);


        root.right.left = new TreeNode(15);
        root.right.right= new TreeNode(7);




        List<List<Integer>> res = obj.levelOrderBottom(root);

        for(List<Integer> list1: res){
            for(Integer val: list1)
                System.out.print(val +"  ");
            System.out.println();
        }

    }
}
