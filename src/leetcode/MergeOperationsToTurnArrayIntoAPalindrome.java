/**
 * ou are given an array nums consisting of positive integers.
 *
 * You can perform the following operation on the array any number of times:
 *
 * Choose any two adjacent elements and replace them with their sum.
 * For example, if nums = [1,2,3,1], you can apply one operation to make it [1,5,1].
 * Return the minimum number of operations needed to turn the array into a palindrome.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [4,3,2,1,2,3,1]
 * Output: 2
 * Explanation: We can turn the array into a palindrome in 2 operations as follows:
 * - Apply the operation on the fourth and fifth element of the array, nums becomes equal to [4,3,2,3,3,1].
 * - Apply the operation on the fifth and sixth element of the array, nums becomes equal to [4,3,2,3,4].
 * The array [4,3,2,3,4] is a palindrome.
 * It can be shown that 2 is the minimum number of operations needed.
 * Example 2:
 *
 * Input: nums = [1,2,3,4]
 * Output: 3
 * Explanation: We do the operation 3 times in any position, we obtain the array [10] at the end which is a palindrome.
 */
package leetcode;

public class MergeOperationsToTurnArrayIntoAPalindrome {
    public boolean isPalindrom(int start, int end, int[] arr){
        int i=start, j=end;
        while(i<j){
            if(arr[i]!=arr[j])
                return false;
            i++;
            j--;
        }

        if(i>j)
            return false;

        return true;
    }

    public int minimumOperations(int[] nums) {
        int i=0;
        int count=0;
        int n = nums.length;
        int j=n-1;
        for(;i<j;){
            if(isPalindrom(i,j,nums))
                return count;

            if(nums[i]==nums[j]){
                i++;
                j--;
                continue;
            }

            if(nums[i]>nums[j]){
                int sum = nums[j]+nums[j-1];
                nums[j-1]=sum;
                j--;
                count++;
                continue;
            }

            if(nums[i]<nums[j]){
                int sum = nums[i]+nums[i+1];
                nums[i+1]=sum;
                i++;
                count++;
                continue;
            }
        }
        return count;
    }
}
