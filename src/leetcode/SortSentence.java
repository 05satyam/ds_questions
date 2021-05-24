/*
* A sentence is a list of words that are separated by a single space with no leading or trailing spaces. Each word consists of lowercase and uppercase English letters.

A sentence can be shuffled by appending the 1-indexed word position to each word then rearranging the words in the sentence.

For example, the sentence "This is a sentence" can be shuffled as "sentence4 a3 is2 This1" or "is2 sentence4 This1 a3".
* */

package leetcode;

import java.util.ArrayList;

public class SortSentence {
    public static String sortSentence(String s) {
        String[] words = s.split(" ");
        String[] resSent = new String[words.length];
        for(int i=0;i<words.length;i++){
            String word = words[i];
            int idx = Integer.valueOf(word.charAt(word.length()-1)-48);
            resSent[idx-1]=word.substring(0,word.length()-1);
        }

        String res = "";
        for(int i=0;i<resSent.length;i++){
            res+=resSent[i];
            res+=" ";
        }
        return res.substring(0,res.length()-1);
    }
    public static void  main(String[] arg){
        System.out.println(sortSentence("is2 sentence4 This1 a3"));
    }
}
