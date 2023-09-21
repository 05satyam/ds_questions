package leetcode;

import java.util.HashSet;
import java.util.Set;

public class MaximumSumDistinctSubarraysLengthK {
    public static long maximumSubarraySum(int[] nums, int k) {
        long eleSum = 0, totalMaxSum = 0;
        int i = 0, j = 0;
        Set<Integer> eleSet = new HashSet<>();
        while(j < nums.length){
            if(j - i < k && eleSet.size() < k){
                while(eleSet.size()>0 && eleSet.contains(nums[j])){
                    eleSum -= nums[i];
                    eleSet.remove(nums[i++]);
                }
                eleSum+=nums[j];
                eleSet.add(nums[j]);
                j++;
            }else{
                if(j - i == k && eleSet.size() == k){
                    totalMaxSum = Math.max(totalMaxSum , eleSum);

                }
                eleSum-=nums[i];
                eleSet.remove(nums[i]);
                i++;
            }

        }

        if(j - i == k && eleSet.size() == k){
            totalMaxSum = Math.max(totalMaxSum, eleSum);
        }

        return totalMaxSum;
    }
    public static void main(String[] a){
        int[] arr = {1,5,4,2,9,9,9};
        //int[] arr = {1}; k=3
        //int[] arr = {1,1,2}; k =2
        System.out.println(maximumSubarraySum(arr,3));
    }
}
