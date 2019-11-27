/**
 * QUESTION:
 * 
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
	Each element in the array represents your maximum jump length at that position.
	Determine if you are able to reach the last index.
 * 
 * */

package leetcode;

public class JumpGame {

	 public static boolean canJump(int[] arr) {
	        int n = arr.length;
	       int jumps[] = new int[n]; 
	        int i, j; 
	        if(n==1 && arr[0]==0)return true;
	        if (n == 0 || arr[0] == 0) 
	        jumps[0] = 0; 
	        for (i = 1; i < n; i++) { 
	            jumps[i] = Integer.MAX_VALUE; 
	            for (j = 0; j < i; j++) { 
	                if (i <= j + arr[j] && jumps[j] != Integer.MAX_VALUE) { 
	                    jumps[i] = Math.min(jumps[i], jumps[j] + 1); 
	                    break; 
	                } 
	            } 
	        } 
	        return jumps[n - 1]!=Integer.MAX_VALUE?true:false; 
	    }
	public static void main(String[] args) {
		int arr[] = new int[] { 2,3,1,1,4 };
		System.out.println(canJump(arr));
	}

}
