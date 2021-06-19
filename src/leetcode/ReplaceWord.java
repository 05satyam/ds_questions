/**
 * In English, we have a concept called root, which can be followed by some other word to form another longer word - let's call this word successor. For example, when the root "an" is followed by the successor word "other", we can form a new word "another".
 *
 * Given a dictionary consisting of many roots and a sentence consisting of words separated by spaces, replace all the successors in the sentence with the root forming it. If a successor can be replaced by more than one root, replace it with the root that has the shortest length.
 *
 * Return the sentence after the replacement.
 *
 *
 * Example 1:
 *
 */
package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ReplaceWord {
    public static String replaceWords(List<String> dictionary, String sentence) {
        StringBuilder sb  = new StringBuilder();
        HashSet<String> set = new HashSet<>(dictionary);
        String[] words = sentence.split(" ");
        for(int i=0;i<words.length;i++){
            StringBuilder sbStr = new StringBuilder();
            for(int j=0;j<words[i].length();j++){
                sbStr.append(words[i].charAt(j));
                if(set.contains(sbStr.toString())) {
                    break;
                }
            }
            sb.append(sbStr).append(" ");
        }
        return sb.toString().trim();
    }

    public static void main(String[] a){
        List<String> dict = new ArrayList<>();
        dict.add("cat");
        dict.add("bat");
        dict.add("rat");
        System.out.println(replaceWords(dict, "the cattle was rattled by the battery"));
    }
}
