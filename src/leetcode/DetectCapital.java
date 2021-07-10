/**
 * We define the usage of capitals in a word to be right when one of the following cases holds:
 *
 * All letters in this word are capitals, like "USA".
 * All letters in this word are not capitals, like "leetcode".
 * Only the first letter in this word is capital, like "Google".
 * Given a string word, return true if the usage of capitals in it is right.
 *
 *
 *
 * Example 1:
 *
 * Input: word = "USA"
 * Output: true
 */
package leetcode;

public class DetectCapital {
    public boolean detectCapitalUse(String word) {
        boolean cap=false;
        boolean small=false;
        int capCnt=0, smallCnt=0;
        for(int i=0;i<word.length();i++){
            if(word.charAt(i)>='A' && word.charAt(i)<='Z'){
                if(small==true)
                    return false;
                if(smallCnt>1)
                    return false;
                cap=true;
                capCnt++;
            }else if(word.charAt(i)>='a' && word.charAt(i)<='z'){
                small=true;
                if(capCnt>1)
                    return false;

                smallCnt++;
            }
        }
        return true;
    }
}
