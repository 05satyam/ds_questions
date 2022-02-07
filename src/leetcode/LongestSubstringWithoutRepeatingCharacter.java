/**
 *Given a string s, find the length of the longest substring without repeating characters.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 */
package leetcode;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacter {
    public static int lengthOfLongestSubstring(String s) {
        if(s.length()==1){
            return 1;
        }
        Set<Character> uniqCharSet = new HashSet<>();
        int maxLen=0;
        int currLen=0;
        for(int i=0;i<s.length();i++){
            if(uniqCharSet.contains(s.charAt(i))){
                maxLen= maxLen<currLen? currLen:maxLen;
                i=i-currLen;
                currLen=0;
                uniqCharSet.clear();
            }else{
                uniqCharSet.add(s.charAt(i));
                currLen++;
            }
        }
        if(uniqCharSet.size()>0){
            maxLen=maxLen<uniqCharSet.size()? uniqCharSet.size():maxLen;
        }

        return maxLen;
    }

    public static void main(String[] a){
        System.out.println(lengthOfLongestSubstring("abcabcabc"));
    }
}
