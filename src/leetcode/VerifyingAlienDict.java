/**
 * In an alien language, surprisingly, they also use English lowercase letters, but possibly in a different order. The order of the alphabet is some permutation of lowercase letters.
 *
 * Given a sequence of words written in the alien language, and the order of the alphabet, return true if and only if the given words are sorted lexicographically in this alien language.
 *
 *
 *
 * Example 1:
 *
 * Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
 * Output: true
 * Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.
 */
package leetcode;

import java.util.HashMap;
import java.util.Map;

public class VerifyingAlienDict {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> dict = new HashMap<>();
        for(int i=0;i<order.length();i++){
            dict.put(order.charAt(i), i);
        }

        for(int i=1;i< words.length;i++){
            String a = words[i-1];
            String b = words[i];

            for(int j=0;j<a.length();j++) {
                if (j == b.length())
                    return false;


                char a1 = a.charAt(j);
                char b1 = b.charAt(j);

                if(dict.get(a1)>dict.get(b1))
                    return false;

                if(a1!=b1)
                    break;
            }
        }
        return true;
    }
}
