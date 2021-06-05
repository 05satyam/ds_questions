/**
 * Given two equal-size strings s and t. In one step you can choose any character of t and replace it with another character.
 *
 * Return the minimum number of steps to make t an anagram of s.
 *
 * An Anagram of a string is a string that contains the same characters with a different (or the same) ordering.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "bab", t = "aba"
 * Output: 1
 * Explanation: Replace the first 'a' in t with b, t = "bba" which is anagram of s.
 */

package leetcode;

import java.util.HashMap;
import java.util.Map;

public class MinimumNumberOfStepsToMakeTwoStringAnagram {

    //SOLUTION 1
    public static int minSteps(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        int step=0;
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }


        for(int i=0; i<t.length(); i++){
            char c = t.charAt(i);

            if(map.containsKey(c) && map.get(c)>0){
                map.put(c, map.get(c)-1);
            }
            else step++;
        }

        return step;
    }

    //SOLUTION 2:
    public static int minStep2(String s, String t){
        int[] count = new int[26];
        int no = 0;

        for(char c : s.toCharArray()) count[c - 'a']++;

        for(char b : t.toCharArray()) count[b - 'a']--;

        for(int i=0; i<26; i++) {
            if(count[i] > 0)
                no += count[i];
        }
        return no;
    }

    public static void main(String[] a){
        System.out.println(minSteps("leetcode" ,"practice"));
    }
}
