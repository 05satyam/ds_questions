/*
* For a string sequence, a string word is k-repeating if word concatenated k times is a substring of sequence. The word's maximum k-repeating value is the highest value k where word is k-repeating in sequence. If word is not a substring of sequence, word's maximum k-repeating value is 0.
* */

package leetcode;

public class MaximumRepeatingSubstring {

    private int maxCountRepeatingSubstring(String sequence, String word){
       StringBuilder sb = new StringBuilder();
        int len = -1;
        while(sequence.contains(sb.toString())){
            len++;
            sb.append(word);
        }

        return len;
    }

    public static void main(String a[]){
        MaximumRepeatingSubstring mrs = new MaximumRepeatingSubstring();
        System.out.print(mrs.maxCountRepeatingSubstring("ababc", "ac"));
    }
}
