package leetcode;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

public class MinimizeMaxPairSumInArray {
    public static int minPairSum(int[] nums) {
        Arrays.sort(nums);
        //PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int minSum=Integer.MIN_VALUE;
        for(int i=0, j=nums.length-1;i<(nums.length/2);i++,j--){
            int sum = nums[i]+nums[j];
            minSum = minSum<sum? sum: minSum;
        }
        return minSum;
    }

    public static void main(String[] a){
        int[] arr = new int[4];
        arr[0]=3; arr[1]=5; arr[2]=2; arr[3]=3;
        System.out.println(minPairSum(arr));


        int[] arr1 = new int[6];
        arr1[0]=3; arr1[1]=5; arr1[2]=4; arr1[3]=2; arr1[4]=4; arr1[5]=6;
        System.out.println(minPairSum(arr1));

    }
}
