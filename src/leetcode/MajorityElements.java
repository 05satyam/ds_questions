/*
Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.



Example 1:

Input: nums = [3,2,3]
Output: 3
 */
package leetcode;

import java.util.Arrays;

public class MajorityElements {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int totalLen = nums.length;
        int count=1;
        int maxCnt = 0;
        int num=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]==nums[i-1]){
                count++;

            }else {
                if(maxCnt<count) {
                    maxCnt=count;
                    num=nums[i-1];

                }
                count=1;
            }

        }
        if(maxCnt<count) {
            maxCnt=count;
            num=nums[totalLen-1];

        }
       // maxCnt = maxCnt>count? maxCnt:count;
        //if(nums[totalLen-1]==)
        return num;
    }
}
