/**
 * You are given an integer array nums where the largest integer is unique.
 *
 * Determine whether the largest element in the array is at least twice as much as every other number in the array. If it is, return the index of the largest element, or return -1 otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [3,6,1,0]
 * Output: 1
 * Explanation: 6 is the largest integer.
 * For every other number in the array x, 6 is at least twice as big as x.
 * The index of value 6 is 1, so we return 1.
 */
package leetcode;

import java.util.Arrays;

public class LargestNumberAsTwiceOfOther {
    public static int dominantIndex(int[] nums) {

        int k = nums.length-1;
        int maxNumIdx = getMaxNumIdx(nums);



        Arrays.sort(nums);
        int maxNum = nums[nums.length-1];
        System.out.println("max idx "+ maxNumIdx + " max num "+ maxNum );
        for(int i=0;i<nums.length-1;i++){
            if(maxNum==0 && nums[i]==0)
                return -1;

            if(nums[i]==0)
                continue;;
            if(maxNum/nums[i]>=2){
                continue;
            }else
                return -1;
        }
        return maxNumIdx;
    }

    public static int getMaxNumIdx(int[] num){
        int max= Integer.MIN_VALUE;
        int idx=-1;
        for(int i=0;i<num.length;i++){

            if(num[i]>max){
                idx=i;
                max=num[i];
            }
        }
        return idx;
    }
    public static void main(String[] a){

        int[] arr = {3,6,1,0};
        System.out.println(dominantIndex(arr));
    }
}
