/**
 * The letter value of a letter is its position in the alphabet starting from 0 (i.e. 'a' -> 0, 'b' -> 1, 'c' -> 2, etc.).
 *
 * The numerical value of some string of lowercase English letters s is the concatenation of the letter values of each letter in s, which is then converted into an integer.
 *
 * For example, if s = "acb", we concatenate each letter's letter value, resulting in "021". After converting it, we get 21.
 * You are given three strings firstWord, secondWord, and targetWord, each consisting of lowercase English letters 'a' through 'j' inclusive.
 *
 * Return true if the summation of the numerical values of firstWord and secondWord equals the numerical value of targetWord, or false
 *
 *
 * Input: firstWord = "acb", secondWord = "cba", targetWord = "cdb"
 * Output: true
 * Explanation:
 * The numerical value of firstWord is "acb" -> "021" -> 21.
 * The numerical value of secondWord is "cba" -> "210" -> 210.
 * The numerical value of targetWord is "cdb" -> "231" -> 231.
 * We return true because 21 + 210 == 231.
 */
package leetcode;

public class CheckIfWordEqualsSummationOfTwoWords {
    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        int fCount=0;
        for(int i=0;i<firstWord.length();i++){
            int idx = firstWord.charAt(i)-'a';
            fCount = fCount*10+ idx;
        }

        int sCount=0;
        for(int i=0;i<secondWord.length();i++){
            int idx = secondWord.charAt(i)-'a';
            sCount = sCount*10+ idx;
        }


        int tCount=0;
        for(int i=0;i<targetWord.length();i++){
            int idx = targetWord.charAt(i)-'a';
            tCount = tCount*10+ idx;
        }

        return  fCount+sCount == tCount;
    }
}
