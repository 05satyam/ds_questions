package leetcode;

public class SecondMinimumNodeinBinaryTree {
    HashSet<Integer> hs = new  HashSet<Integer>();
    public int findSecondMinimumValue(TreeNode root)
    {
        pre(root);
        ArrayList<Integer> al = new ArrayList<Integer>(hs);
        Collections.sort(al);
        if(al.size()==1)
            return -1;
        return al.get(1);
    }
    public void pre(TreeNode root)
    {
        if(root==null)
            return ;
        pre(root.left);
        hs.add(root.val);
        pre(root.right);
    }
}
