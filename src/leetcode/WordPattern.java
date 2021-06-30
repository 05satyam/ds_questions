/**
 * Given a pattern and a string s, find if s follows the same pattern.
 *
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.
 *
 *
 *
 * Example 1:
 *
 * Input: pattern = "abba", s = "dog cat cat dog"
 * Output: true
 * Example 2:
 *
 * Input: pattern = "abba", s = "dog cat cat fish"
 * Output: false
 */
package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> charToWord= new HashMap<>();
        Set<String> words = new HashSet<>();
        String[] sArr = s.split(" ");
        if(sArr.length!=pattern.length())
            return false;

        for(int i=0;i<pattern.length();i++){
            if(charToWord.containsKey(pattern.charAt(i))){
                String mVal = charToWord.get(pattern.charAt(i));
                String sWord = sArr[i];
                if(!mVal.equalsIgnoreCase(sWord))
                    return false;
            }else{
                if(words.contains(sArr[i]))
                    return false;
                words.add(sArr[i]);
                charToWord.put(pattern.charAt(i), sArr[i]);
            }
        }
        return true;
    }
}
