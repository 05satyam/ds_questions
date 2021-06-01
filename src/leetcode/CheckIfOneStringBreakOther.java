/*
*
* Given two strings: s1 and s2 with the same size, check if some permutation of string s1 can break some permutation of string s2 or vice-versa. In other words s2 can break s1 or vice-versa.

A string x can break string y (both of size n) if x[i] >= y[i] (in alphabetical order) for all i between 0 and n-1.



Example 1:

Input: s1 = "abc", s2 = "xya"
Output: true
Explanation: "ayx" is a permutation of s2="xya" which can break to string "abc" which is a permutation of s1="abc".
* */

package leetcode;

import java.util.Arrays;

public class CheckIfOneStringBreakOther {
    public static boolean checkIfCanBreak(String s1, String s2) {
        char[] s1Arr = s1.toCharArray();
        Arrays.sort(s1Arr);
        char[] s2Arr = s2.toCharArray();
        Arrays.sort(s2Arr);
        int count=0, count2=0;
        for(int i=0;i< s1Arr.length;i++){
            if(s1Arr[i]<=s2Arr[i])
                count++;
        if(s1Arr[i]>=s2Arr[i])
            count2++;
        }

        return  (count==s1Arr.length) || (count2== s1Arr.length)? true: false;
    }
    public static void main(String[] a){
        System.out.println(checkIfCanBreak("szy" , "cid"));
    }
}
