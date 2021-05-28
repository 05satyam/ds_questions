/*
* You have n boxes. You are given a binary string boxes of length n, where boxes[i] is '0' if the ith box is empty, and '1' if it contains one ball.

In one operation, you can move one ball from a box to an adjacent box. Box i is adjacent to box j if abs(i - j) == 1. Note that after doing so, there may be more than one ball in some boxes.

Return an array answer of size n, where answer[i] is the minimum number of operations needed to move all the balls to the ith box.

Each answer[i] is calculated considering the initial state of the boxes.



Example 1:

Input: boxes = "110"
Output: [1,1,3]
Explanation: The answer for each box is as follows:
1) First box: you will have to move one ball from the second box to the first box in one operation.
2) Second box: you will have to move one ball from the first box to the second box in one operation.
3) Third box: you will have to move one ball from the first box to the third box in two operations, and move one ball from the second box to the third box in one operation.
* */
package leetcode;

import java.util.Arrays;

//Solution 1: brute force
public class MinOperationToMoveAllBallsToEachBlock {
    public static int[] minOperations(String boxes) {

        char[] ch = boxes.toCharArray();
        int res[] = new int[ch.length];
        Arrays.fill(res, 0);
         for(int i=0;i<ch.length;i++){
            for(int j=0;j<ch.length;j++){
                if(ch[j]=='1'){
                    int diff = j-i;
                    diff= diff<0? (-1)*diff : diff;
                    res[i]+=diff;
                }
            }
        }
         return res;
    }

 //Solution 2 O(n+n)
 public static int[] minOperations2(String boxes) {
     int[] ans = new int[boxes.length()];
     int cnt = 0;
     int val = 0;
     for(int i = 0; i < boxes.length(); i++) {
         val += cnt;
         ans[i] += val;
         if(boxes.charAt(i) == '1') cnt++;
     }
     cnt = 0;
     val = 0;
     for(int i = boxes.length() - 1; i >= 0; i--) {
         val += cnt;
         ans[i] += val;
         if(boxes.charAt(i) == '1') cnt++;
     }
     return ans;
 }

    public static void main(String[] a){
        int arr[] = minOperations("001011");
        for (int i=0;i<arr.length;i++)
        System.out.println(arr[i]);
    }
}
