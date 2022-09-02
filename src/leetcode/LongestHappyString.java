/**
 * A string s is called happy if it satisfies the following conditions:
 *
 * s only contains the letters 'a', 'b', and 'c'.
 * s does not contain any of "aaa", "bbb", or "ccc" as a substring.
 * s contains at most a occurrences of the letter 'a'.
 * s contains at most b occurrences of the letter 'b'.
 * s contains at most c occurrences of the letter 'c'.
 * Given three integers a, b, and c, return the longest possible happy string. If there are multiple longest happy strings, return any of them. If there is no such string, return the empty string "".
 *
 * A substring is a contiguous sequence of characters within a string.
 *
 *
 *
 * Example 1:
 *
 * Input: a = 1, b = 1, c = 7
 * Output: "ccaccbcc"
 * Explanation: "ccbccacc" would also be a correct answer.
 */
package leetcode;

import java.util.Collections;
import java.util.PriorityQueue;

public class LongestHappyString {
    public String longestDiverseString(int a, int b, int c) {

        int A=0,B=0,C=0, size=a+b+c;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<size;i++){
            if((c>=a && c>=b && C!=2) ||  (B == 2 && c > 0) || (A == 2 && c > 0)){
                sb.append("c");
                C++;
                A=0;
                B=0;
                c--;
            }else if((a>=b && a>=c && A!=2) ||  (B == 2 && a > 0) || (C == 2 && a > 0)){
                sb.append("a");
                A++;
                C=0;
                B=0;
                a--;
            }else if((b>=a && b>=c && B!=2) ||  (A == 2 && b > 0) || (C == 2 && b > 0)){
                sb.append("b");
                B++;
                A=0;
                C=0;
                b--;
            }
        }
        return sb.toString();
    }
}
