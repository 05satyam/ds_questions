/**
 * Given an array of integers arr, a lucky integer is an integer which has a frequency in the array equal to its value.
 *
 * Return a lucky integer in the array. If there are multiple lucky integers return the largest of them. If there is no lucky integer return -1.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = [2,2,3,4]
 * Output: 2
 * Explanation: The only lucky number in the array is 2 because frequency[2] == 2.
 * Example 2:
 *
 * Input: arr = [1,2,2,3,3,3]
 * Output: 3
 * Explanation: 1, 2 and 3 are all lucky numbers, return the largest of them.
 */
package leetcode;

public class LuckyIntegerInArray {
    public int findLucky(int[] arr) {
        int[] nums = new int[501];
        for(int a : arr) nums[a]++;
        for(int i = 500;i>0;i--)
            if(nums[i]==i) return i;
        return -1;
    }
}
