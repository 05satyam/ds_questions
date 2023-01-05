/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 *
 *
 *
 * Example 1:
 *
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 *
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 *
 *
 */
package leetcode;

import java.util.HashSet;
import java.util.Set;

public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        Set<Character> set = new HashSet<>();
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<strs[0].length();i++){
            for(int j=1;j<strs.length;j++){
                if(strs[j].length()<=i || strs[j-1].length()<=i ){
                    return sb.toString();
                }
                    if(strs[j].charAt(i)!=strs[j-1].charAt(i))
                        return sb.toString();

            }

                System.out.println(strs[0].charAt(i));
                sb.append(strs[0].charAt(i));

        }
        return sb.length()==0?"":sb.toString();
    }

    public static void main(String[] a){
        String[] s= new String[3];
        s[0]="flow";
        s[1]= "fl";
        s[2]= "fliwerww";
        System.out.println(longestCommonPrefix(s));
    }
}
