/**
 * Given a zero-based permutation nums (0-indexed), build an array ans of the same length where ans[i] = nums[nums[i]] for each 0 <= i < nums.length and return it.
 *
 * A zero-based permutation nums is an array of distinct integers from 0 to nums.length - 1 (inclusive).
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [0,2,1,5,3,4]
 * Output: [0,1,2,4,5,3]
 * Explanation: The array ans is built as follows:
 * ans = [nums[nums[0]], nums[nums[1]], nums[nums[2]], nums[nums[3]], nums[nums[4]], nums[nums[5]]]
 *     = [nums[0], nums[2], nums[1], nums[5], nums[3], nums[4]]
 *     = [0,1,2,4,5,3]
 *
 *
 */
package leetcode;

public class BuildAnArrayFromPermutation {
    public int[] buildArray(int[] nums) {
        int res[] = new int[nums.length];

        for(int i=0;i<nums.length;i++){
            res[i] = nums[nums[i]];;
        }
        return res;
    }

    public static int numberOfVowelsInString(String s){
        int count=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='a' ||s.charAt(i)=='e' ||s.charAt(i)=='i' ||s.charAt(i)=='o' ||s.charAt(i)=='u')
                count++;
        }
        return count;
    }
    public static void main(String[] a){
        System.out.print(numberOfVowelsInString("This is a strings"));
    }
}
