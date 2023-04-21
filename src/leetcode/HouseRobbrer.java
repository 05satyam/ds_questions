/**
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 *
 * Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 * Total amount you can rob = 1 + 3 = 4.
 *
 */
package leetcode;

public class HouseRobbrer {
    public int rob(int[] nums) {
        if(nums.length==1)
            return nums[0];

        int max =   nums[0]>nums[1]? nums[0]:nums[1];
        for(int i=2;i<nums.length;i++){
            if(i==2){
                max = max>(nums[i]+nums[i-2])?max: nums[i]+nums[i-2];
                nums[i]=max;
            }else{
                int a = nums[i]+nums[i-2]    >   nums[i]+nums[i-3]?
                        (nums[i]+nums[i-2]):(nums[i]+nums[i-3]) ;
                max = max>a?max: a;
                nums[i]=max;
            }
        }
        return max;
    }
}
