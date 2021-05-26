/*
* Given an array arr of integers, check if there exists two integers N and M such that N is the double of M ( i.e. N = 2 * M).

More formally check if there exists two indices i and j such that :

i != j
0 <= i, j < arr.length
arr[i] == 2 * arr[j]


Example 1:

Input: arr = [10,2,5,3]
Output: true
Explanation: N = 10 is the double of M = 5,that is, 10 = 2 * 5.

* */

package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class NAndItsDouble {
    public static boolean checkIfExist(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (Integer num : arr) {
            if (set.contains(num * 2) || (num % 2 == 0 && set.contains(num / 2))) {
                return true;
            }
            set.add(num);
        }
        return false;
    }

    public static void main(String[] a){
        int arr[] = {-2,0,10,-19,4,6,-8};
        int arr1[] = {10,2,5,3};
        System.out.println(checkIfExist(arr1));
    }
}
