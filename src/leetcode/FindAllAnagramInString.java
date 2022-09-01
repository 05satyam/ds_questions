/**
 * 438. Find All Anagrams in a String
 * Medium
 *
 * 8541
 *
 * 269
 *
 * Add to List
 *
 * Share
 * Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "cbaebabacd", p = "abc"
 * Output: [0,6]
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 * Example 2:
 *
 * Input: s = "abab", p = "ab"
 * Output: [0,1,2]
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 *
 *
 *
 */
package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagramInString {
    public static List<Integer> findAnagrams(String s, String p) {
        int pHash[] = new int[26];
        int hash[] = new int[26];
        List<Integer> resList = new ArrayList<>();
        Arrays.fill(pHash,0);
        Arrays.fill(hash,0);
        for(int i=0;i<p.length();i++){
            pHash[p.charAt(i)-'a']++;
        }
        int window = p.length();
        int count=0;
        int right=window;
        int left=0;
        boolean notEqual=false;
        int equalCnt = 0;
        for(int i=0;i<s.length();){
            if(count<window){
                System.out.println("s.charAt(i) "+ s.charAt(i)+ "    s.charAt(i)-a " + (s.charAt(i)-'a'));
                hash[s.charAt(i)-'a']++;
                count++;
                //System.out.println("count "+ count);

                if(i==s.length()-1){
                    for(int ii=0;ii<26;ii++){
                        System.out.println(" hash[ii] "+ hash[ii] + "   pHash[ii] "+ pHash[ii]);
                        if(hash[ii]!=pHash[ii]){
                            notEqual=true;
                            //break;
                        }
                    }
                    if(!notEqual){
                        resList.add(i-(window-1));
                        System.out.println("i-(window) "+ (i-(window)));

                    }
                }
                i++;
            }else{

                for(int ii=0;ii<26;ii++){
                    System.out.println(" hash[ii] "+ hash[ii] + "   pHash[ii] "+ pHash[ii]);
                    if(hash[ii]!=pHash[ii]){
                       notEqual=true;
                       //break;
                    }
                }
                if(!notEqual){
                    resList.add(i-(window));
                    System.out.println("i-(window) "+ (i-(window)));

                } notEqual=false;
                //System.out.println("i "+ i + " window "+ window);
                char charToBeRemoved = s.charAt(i-(window));
                System.out.println("charToBeRemoved  "+ charToBeRemoved);
                //System.out.println("hash[left] "+ hash[left] + "   left "+ left);
               // System.out.println("char to be removed frequency "+  hash[charToBeRemoved-'a']);
                System.out.println();
                hash[charToBeRemoved-'a']--;
               // left++;
                count--;
            }

            //System.out.println("count "+ count);
        }
        return resList;
    }
    public static void main(String[] a){
        List<Integer> res = findAnagrams("abab", "ab");
        System.out.println(res);
    }
}
