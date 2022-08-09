package leetcode;

import java.util.Arrays;

public class MinimumDifferenceBetweenLargestAndMinimumElement {
    public int minDifference(int[] nums) {

        Arrays.sort(nums);
        int len  = nums.length;
        nums[len-1]=nums[0];
        nums[len-2]=nums[0];
        nums[len-3]=nums[0];
        Arrays.sort(nums);
        return nums[len-1]-nums[0];
    }
}
