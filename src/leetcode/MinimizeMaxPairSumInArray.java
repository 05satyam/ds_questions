/**
 * The pair sum of a pair (a,b) is equal to a + b. The maximum pair sum is the largest pair sum in a list of pairs.
 *
 * For example, if we have pairs (1,5), (2,3), and (4,4), the maximum pair sum would be max(1+5, 2+3, 4+4) = max(6, 5, 8) = 8.
 * Given an array nums of even length n, pair up the elements of nums into n / 2 pairs such that:
 *
 * Each element of nums is in exactly one pair, and
 * The maximum pair sum is minimized.
 * Return the minimized maximum pair sum after optimally pairing up the elements.
 *
 * Input: nums = [3,5,2,3]
 * Output: 7
 * Explanation: The elements can be paired up into pairs (3,3) and (5,2).
 * The maximum pair sum is max(3+3, 5+2) = max(6, 7) = 7.
 */
package leetcode;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

public class MinimizeMaxPairSumInArray {
    public static int minPairSum(int[] nums) {
        Arrays.sort(nums);
        //PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int minSum=Integer.MIN_VALUE;
        for(int i=0, j=nums.length-1;i<(nums.length/2);i++,j--){
            int sum = nums[i]+nums[j];
            minSum = minSum<sum? sum: minSum;
        }
        return minSum;
    }

    public static void main(String[] a){
        int[] arr = new int[4];
        arr[0]=3; arr[1]=5; arr[2]=2; arr[3]=3;
        System.out.println(minPairSum(arr));


        int[] arr1 = new int[6];
        arr1[0]=3; arr1[1]=5; arr1[2]=4; arr1[3]=2; arr1[4]=4; arr1[5]=6;
        System.out.println(minPairSum(arr1));

    }
}
