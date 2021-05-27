/*
* Given an array of integers arr, write a function that returns true if and only if the number of occurrences of each value in the array is unique.

Example 1:

Input: arr = [1,2,2,1,1,3]
Output: true
Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1. No two values have the same number of occurrences.
* */
package leetcode;

import java.util.HashSet;
import java.util.Set;

public class UniqueNumberOfOccurence {
    public static boolean uniqueOccurrences(int[] arr) {
        int count=0;
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<arr.length;i++){
            count=1;
            for(int j=0;j<arr.length;j++){
                if((arr[i]==arr[j] )&& (i!=j) && arr[j]!=Integer.MAX_VALUE) {
                    count++;
                    arr[j]=Integer.MAX_VALUE;
                }
            }
            if(set.contains(count) && arr[i]!=Integer.MAX_VALUE){
                return false;
            }else if(arr[i]!=Integer.MAX_VALUE){
                set.add(count);
            }
        }
        return true;
    }
    public static void main(String[] a){
        int[] arr = {1,2,2,1,1,3};
        int[] arr1={-3,0,1,-3,1,1,1,-3,10,0};
        System.out.println(uniqueOccurrences(arr1));
    }
}
