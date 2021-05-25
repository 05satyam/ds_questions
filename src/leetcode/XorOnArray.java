/*
* Given an integer n and an integer start.

Define an array nums where nums[i] = start + 2*i (0-indexed) and n == nums.length.

Return the bitwise XOR of all elements of nums.
* */

package leetcode;

public class XorOnArray {
    public static int[] createArray(int n, int start){
        int res[] = new int[n];
        for(int i=0;i<n;i++){
            int a  = start + (2*i);
            res[i]=a;

        }
        return res;
    }

    public static int getXor(int res[]){
        int xor=0;
        for(int i=0;i<res.length;i++){
            xor =xor^res[i];
        }
        return xor;
    }
    public static void main(String[] arg){
        int[] arr = createArray(5,0);
        System.out.println(getXor(arr));
    }
}
