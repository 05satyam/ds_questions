/**
 *
 * We define the conversion array conver of an array arr as follows:
 *
 * conver[i] = arr[i] + max(arr[0..i]) where max(arr[0..i]) is the maximum value of arr[j] over 0 <= j <= i.
 * We also define the score of an array arr as the sum of the values of the conversion array of arr.
 *
 * Given a 0-indexed integer array nums of length n, return an array ans of length n where ans[i] is the score of the prefix nums[0..i].
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,3,7,5,10]
 * Output: [4,10,24,36,56]
 * Explanation:
 * For the prefix [2], the conversion array is [4] hence the score is 4
 * For the prefix [2, 3], the conversion array is [4, 6] hence the score is 10
 * For the prefix [2, 3, 7], the conversion array is [4, 6, 14] hence the score is 24
 * For the prefix [2, 3, 7, 5], the conversion array is [4, 6, 14, 12] hence the score is 36
 * For the prefix [2, 3, 7, 5, 10], the conversion array is [4, 6, 14, 12, 20] hence the score is 56
 */
package leetcode;

public class FindTheScoreOfAllPrefixesOfAnArray {
    public long[] findPrefixScore(int[] nums) {
        long res[] = new long[nums.length];

        long currMax = nums[0];
        long currSum = nums[0];
        res[0] = currSum + currMax;
        currSum =res[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]>currMax){
                currMax = nums[i];
            }

            long conver = nums[i] + currMax;
            currSum += conver;
            res[i] = currSum;
        }

        return res;
    }
}
