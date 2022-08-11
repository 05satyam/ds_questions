/**
 * Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.
 *
 * Return the sum of the three integers.
 *
 * You may assume that each input would have exactly one solution.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [-1,2,1,-4], target = 1
 * Output: 2
 * Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
package leetcode;

import java.util.Arrays;

public class ThreeSumCloset {
    public int threeSumClosest(int[] nums, int target) {
        if(nums.length==3){
            return nums[0]+nums[1]+ nums[2];
        }
        Arrays.sort(nums);
        int closet = Integer.MAX_VALUE;
        for(int i=0;i<=nums.length-3;i++){
            int start=i+1;
            int end=nums.length-1;

            while(start<end){
                int threeSum  = nums[i]+ nums[start]+ nums[end];

                if(threeSum<target){
                    start++;
                }else if(threeSum>threeSum){
                    end--;
                }

                if(threeSum==target)
                    return threeSum;
                if(Math.abs(threeSum-target)< Math.abs(closet-target)){
                    closet=threeSum;
                }


            }
        }
        return closet;
    }
}
