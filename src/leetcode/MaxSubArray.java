/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 *
 * A subarray is a contiguous part of an array.
 *
 *
 *
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 *
 *
 */
package leetcode;

public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        if(nums.length==0)
            return 0;
        if(nums.length==1)
            return nums[0];
        int maxSum=nums[0];
        int maxRes =nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]+ nums[i-1]> nums[i]) {
                maxSum = nums[i] + nums[i-1];
                nums[i]=maxSum;
                if(maxRes<maxSum)
                    maxRes=maxSum;
            }else{
                if(maxRes<nums[i])
                    maxRes=nums[i];
            }

        }
        return maxRes;
    }
}
