package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<Integer> level = new ArrayList<>();
        List<List<Integer>> traverse = new ArrayList<>();
        LinkedList<Integer> q = new LinkedList<>();
        LinkedList<TreeNode> q1 = new LinkedList<>();
        q.add(root.val);
        //level.add(q);
        level.add(q.poll());
        q.add(-1);
        q1.add(root);
        //level.add(Integer.MAX_VALUE);
        while(q1.size() != 0){
            if(q.peek()==Integer.MAX_VALUE){
                traverse.add(level);
                level= new ArrayList<>();
            }

            q.add(root.left.val);
            q.add(root.right.val);
            q.add(Integer.MAX_VALUE);
            level.add(q.poll());
        }
        return traverse;
    }
}
