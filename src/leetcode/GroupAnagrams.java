/*
* Given an array of strings strs, group the anagrams together. You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.



Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
* */
package leetcode;

import java.util.*;

public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> stringToAnangram = new HashMap<>();

        for(int i=0;i<strs.length;i++){
            char[] strArr = strs[i].toCharArray();
            Arrays.sort(strArr);
            String sortedStr = String.valueOf(strArr);
            System.out.println("sorted str "+ sortedStr);

            if(stringToAnangram.containsKey(sortedStr)){
               List<String>  anagramList = stringToAnangram.get(sortedStr);
               anagramList.add(strs[i]);
               stringToAnangram.put(sortedStr,anagramList);
            }else{
                List<String> anagramList  =new ArrayList<>();
                anagramList.add(strs[i]);
                stringToAnangram.put(sortedStr,anagramList);
            }
        }

        List<List<String>> res  = new ArrayList<>();

        for(Map.Entry<String, List<String>> mapSet : stringToAnangram.entrySet()){
            res.add(mapSet.getValue());
        }
        return res;
    }

    public  static  void main(String[] a){
        String[] input = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(input));
    }
}
