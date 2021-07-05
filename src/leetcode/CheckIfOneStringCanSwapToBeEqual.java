/**
 * You are given two strings s1 and s2 of equal length. A string swap is an operation where you choose two indices in a string (not necessarily different) and swap the characters at these indices.
 *
 * Return true if it is possible to make both strings equal by performing at most one string swap on exactly one of the strings. Otherwise, return false.
 *
 *
 *
 * Example 1:
 *
 * Input: s1 = "bank", s2 = "kanb"
 * Output: true
 * Explanation: For example, swap the first character with the last character of s2 to make "bank".
 */
package leetcode;

import java.util.Arrays;

public class CheckIfOneStringCanSwapToBeEqual {
    public static boolean areAlmostEqual(String s1, String s2) {
        int[] s1Array = new int[26];
        int[] s2Array = new int[26];
        int counter = 0;
        for(int i = 0;i<s1.length();i++){
            char s = s1.charAt(i);
            char ss = s2.charAt(i);
            if(s != ss)
                counter++;
            if(counter > 2)
                return false;
            s1Array[s -'a']++;
            s2Array[ss -'a']++;
        }
        return Arrays.equals(s1Array, s2Array);
    }

    public static void main(String[] a){
        System.out.println(areAlmostEqual("bank", "kanb"));
    }
}
