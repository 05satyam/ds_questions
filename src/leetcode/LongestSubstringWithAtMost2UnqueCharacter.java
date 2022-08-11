/**
 * Given a string s, return the length of the longest substring that contains at most two distinct characters.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "eceba"
 * Output: 3
 * Explanation: The substring is "ece" which its length is 3.
 */
package leetcode;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithAtMost2UnqueCharacter {
    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        int maxLen = Integer.MIN_VALUE;
        for(int i=0;i<s.length();i++){
            Set<Character> charCount = new HashSet<>();
            int len=0;
            for(int j=i;j<s.length() && charCount.size()<=2;j++){
                    //System.out.println(" set size   "+ charCount.size());
                    charCount.add(s.charAt(j));
                    if(!charCount.contains(s.charAt(j)) && charCount.size()<=2)     {
                        len++;

                       // System.out.println("char at k "+ s.charAt(j));
                    }else if(charCount.contains(s.charAt(j)) && charCount.size()<=2){
                        len++;
                    }
                    //System.out.println("len "+ len);
                    if(maxLen<len)
                        maxLen=len;
            }
        }
        return maxLen;
    }
    public static void main(String[] a){
        System.out.println(lengthOfLongestSubstringTwoDistinct("eceba"));
    }
}
