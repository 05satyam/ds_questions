/*
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

Note: A leaf is a node with no children.

Example:

Input: [1,2,3]
    1
   / \
  2   3
Output: 25
Explanation:
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.
 * */

package tree;

public class SumRootToLeaf extends Tree{

	public static int sum=0;
	   public static int sumNumbers(Tree root) {
		     
	        return helper(root,0,0);
	    }
	    
	    public static int helper(Tree root , int num, int sum1){
	        if(root==null){
	            return root.data;
	        }
	        
	        num = num*10+ root.data;
	        if(root.left!=null) {
	        	System.out.println("root.left= :" + sum);
	        	helper(root.left, num,sum1);
	        }
	        if(root.right!=null) {
	        	System.out.println("root.right= :" + sum);
	        	helper(root.right, num,sum1);
	        }
	        if(root.left==null && root.right==null) {
	        	sum+=num;
	        }
	        System.out.println(sum);
	        return sum;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tree root = new Tree(4);
		root.left = new Tree(9);
		root.right = new Tree(0);
		root.left.left = new Tree(5);
		root.left.right = new Tree(1);
			System.out.println(sumNumbers(root));
	}

}
