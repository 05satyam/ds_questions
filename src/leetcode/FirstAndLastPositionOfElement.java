/*
* Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.



Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
* */

package leetcode;

public class FirstAndLastPositionOfElement {
    public int[] searchRange(int[] nums, int target) {
        int res[]  = new int[2];
        int start=-1, end=-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]== target && start==-1){
                start=i;
            }
            if(nums[i]==target && start!=-1){
                end=i;
            }
        }

        res[0]=start;
        res[1]=end;
        return res;
    }
}
