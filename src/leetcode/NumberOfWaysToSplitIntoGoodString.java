/**
 * You are given a string s.
 *
 * A split is called good if you can split s into two non-empty strings sleft and sright where their concatenation is equal to s (i.e., sleft + sright = s) and the number of distinct letters in sleft and sright is the same.
 *
 * Return the number of good splits you can make in s.
 *
 * Input: s = "aacaba"
 * Output: 2
 * Explanation: There are 5 ways to split "aacaba" and 2 of them are good.
 * ("a", "acaba") Left string and right string contains 1 and 3 different letters respectively.
 * ("aa", "caba") Left string and right string contains 1 and 3 different letters respectively.
 * ("aac", "aba") Left string and right string contains 2 and 2 different letters respectively (good split).
 * ("aaca", "ba") Left string and right string contains 2 and 2 different letters respectively (good split).
 * ("aacab", "a") Left string and right string contains 3 and 1 different letters respectively.
 */

package leetcode;

import java.util.HashSet;
import java.util.Set;

public class NumberOfWaysToSplitIntoGoodString {
    static Set<Character> prfUniqueChar = new HashSet<>();
    public  static int prfUniqueChar(char s){
        if(prfUniqueChar.contains(s))
            return 0;
        prfUniqueChar.add(s);
        return prfUniqueChar.size()+1;
    }
    static Set<Character> sufUniqueChar = new HashSet<>();
    public static  int sufUniqueChar(char s){
        if(sufUniqueChar.contains(s))
            return 0;
        sufUniqueChar.add(s);
        return sufUniqueChar.size()+1;
    }
    public  static int numSplits(String s) {
        int cnt=0;
        int preUnqCnt[]= new int[s.length()];
        int sufUnqCnt[]= new int[s.length()];
        for(int i=0;i<s.length();i++){
            int uniqueCnt = prfUniqueChar(s.charAt(i));
            if(uniqueCnt==0)
                preUnqCnt[i]=preUnqCnt[i-1];
            else
                preUnqCnt[i]=uniqueCnt;
        }
        for(int i=s.length()-1;i>=0;i--){
            int uniqueCnt = sufUniqueChar(s.charAt(i));
            //System.out.println("i  in suf " + i + "   uniq cnt "+ uniqueCnt);
            if(uniqueCnt==0)
                sufUnqCnt[i]=sufUnqCnt[i+1];
            else
                sufUnqCnt[i]=uniqueCnt;
        }

        for(int i=0;i<s.length()-1;i++){
            int s1Cnt = preUnqCnt[i];
            int s2Cnt = sufUnqCnt[i+1];
            if(s1Cnt==s2Cnt)
                cnt++;
        }
        return cnt;
    }

    public static void main(String[] s){
        System.out.println(numSplits("aacaba"));
    }
}
