/**
 * Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.
 *
 * Each letter in magazine can only be used once in ransomNote.
 *
 *
 *
 * Example 1:
 *
 * Input: ransomNote = "a", magazine = "b"
 * Output: false
 *
 *
 *
 * git
 */
package leetcode;

import java.util.Arrays;

public class RansomeNote {
    public boolean canConstruct(String ransomNote, String magazine) {
            int[] ch = new int[26];
            Arrays.fill(ch, 0);
            for(int i=0;i<magazine.length();i++){
                ch[magazine.charAt(i)-'a']++;
            }

            for(int i=0;i<ransomNote.length();i++){
                if(ch[ransomNote.charAt(i)-'a']==0){
                    return false;
                }
                if(ch[ransomNote.charAt(i)-'a']>0){
                    ch[ransomNote.charAt(i)-'a']--;
                }
            }
            return true;
    }
}
