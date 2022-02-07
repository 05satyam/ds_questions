/*
* LIke robbers problems
*
*
* You are given an integer array nums. You want to maximize the number of points you get by performing the following operation any number of times:

Pick any nums[i] and delete it to earn nums[i] points. Afterwards, you must delete every element equal to nums[i] - 1 and every element equal to nums[i] + 1.
Return the maximum number of points you can earn by applying the above operation some number of times.


 *
 *
 * Input: nums = [3,4,2]
Output: 6
Explanation: You can perform the following operations:
- Delete 4 to earn 4 points. Consequently, 3 is also deleted. nums = [2].
- Delete 2 to earn 2 points. nums = [].
You earn a total of 6 points.
*
*
*
* */
package leetcode;
import  java.util.*;

public class DeleteAndEarn {
    public static int deleteAndEarn(int[] nums) {
       int[] dp= new int[100001];
       for(int i=0;i<nums.length;i++)
           dp[nums[i]]+=nums[i];


       for(int i=2;i<dp.length;i++){
           dp[i] = Math.max(dp[i]+ dp[i-2], dp[i-1]);
       }

       return dp[dp.length-1];
    }

    public static void main(String[] a){
        int[] nums = {3,4,2};
        int[] nums1 = {2,2,3,3,3,4};
        System.out.println(deleteAndEarn(nums1));
    }
}

