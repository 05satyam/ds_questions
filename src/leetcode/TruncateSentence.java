/**
 * A sentence is a list of words that are separated by a single space with no leading or trailing spaces. Each of the words consists of only uppercase and lowercase English letters (no punctuation).
 *
 * For example, "Hello World", "HELLO", and "hello world hello world" are all sentences.
 * You are given a sentence s​​​​​​ and an integer k​​​​​​. You want to truncate s​​​​​​ such that it contains only the first k​​​​​​ words. Return s​​​​​​ after truncating it.
 *
 * Input: s = "Hello how are you Contestant", k = 4
 * Output: "Hello how are you"
 * Explanation:
 * The words in s are ["Hello", "how" "are", "you", "Contestant"].
 * The first 4 words are ["Hello", "how", "are", "you"].
 * Hence, you should return "Hello how are you".
 *
 * Input: s = "What is the solution to this problem", k = 4
 * Output: "What is the solution"
 * Explanation:
 * The words in s are ["What", "is" "the", "solution", "to", "this", "problem"].
 * The first 4 words are ["What", "is", "the", "solution"].
 * Hence, you should return "What is the solution".
 */
package leetcode;

public class TruncateSentence {
    public String truncateSentence(String s, int k) {
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<k;i++){
            sb.append(words[i]) ;
            if(i<k-1)
            sb.append(" ");
        }
        return sb.toString();
    }
}
