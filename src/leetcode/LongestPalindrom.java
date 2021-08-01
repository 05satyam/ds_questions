/**
 * Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that can be built with those letters.
 *
 * Letters are case sensitive, for example, "Aa" is not considered a palindrome here.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abccccdd"
 * Output: 7
 * Explanation:
 * One longest palindrome that can be built is "dccaccd", whose length is 7.
 * Example 2:
 *
 * Input: s = "a"
 * Output: 1
 */
package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestPalindrom {
    public static int longestPalindrome(String s) {
        if(s==null || s.length()==0) return 0;
        Set<Character> set = new HashSet<>();
        int count = 0;
        char[] chars = s.toCharArray();
        for(char c: chars) {
            if(set.remove(c)) {
                count++;
            } else {
                set.add(c);
            }
        }
        return set.isEmpty() ? count*2 : count*2+1;
    }

    public static void main(String[] s){
        System.out.print(longestPalindrome("ccc"));
    }
}
