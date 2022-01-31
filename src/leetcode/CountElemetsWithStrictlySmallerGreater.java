/*
* Given an integer array nums, return the number of elements that have both a strictly smaller and a strictly greater element appear in nums.
*
* Input: nums = [11,7,2,15]
Output: 2
Explanation: The element 7 has the element 2 strictly smaller than it and the element 11 strictly greater than it.
Element 11 has element 7 strictly smaller than it and element 15 strictly greater than it.
In total there are 2 elements having both a strictly smaller and a strictly greater element appear in nums.
*
*
* */
package leetcode;

import java.util.Arrays;

public class CountElemetsWithStrictlySmallerGreater {
    public int countElements(int[] nums) {
        if(nums.length==1)
            return 0;

        if(nums.length==2){
            return 0;
        }
        Arrays.sort(nums);
        int count=0;
        int smallest=nums[0];
        int maxVal= nums[nums.length-1];
        for(int i=1;i<nums.length-1;i++){
            if(nums[i]>smallest && nums[i]<maxVal)
                count++;
        }
        return count;
    }
}
