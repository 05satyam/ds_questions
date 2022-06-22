/**
 * Given an integer array nums and an integer k, return the kth largest element in the array.
 *
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 *
 * Example 1:
 *
 * Input: nums = [3,2,1,5,6,4], k = 2
 * Output: 5
 */
package leetcode;

import java.util.Arrays;
import java.util.Collections;

//  [3,2,3,1,2,4,5,5,6]
//  1,2,2,3,3,4,5,5,6   4
public class KthLargestElementOfArray {
    public int findKthLargest(int[] nums, int k) {

        if (nums.length==1)
            return nums[0];


        Arrays.sort(nums);
        int count=0;
        k=k-1;
        for(int i=nums.length-1;i>=0;i--){
            if(k==1)
                return nums[i];

            if(k>0)
                k--;
        }
        return -1;
    }
}
