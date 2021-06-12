/**
 * Given a string s of '(' and ')' parentheses, we add the minimum number of parentheses ( '(' or ')', and in any positions ) so that the resulting parentheses string is valid.
 *
 * Formally, a parentheses string is valid if and only if:
 *
 * It is the empty string, or
 * It can be written as AB (A concatenated with B), where A and B are valid strings, or
 * It can be written as (A), where A is a valid string.
 * Given a parentheses string, return the minimum number of parentheses we must add to make the resulting string valid.
 *
 * Example 1:
 *
 * Input: s = "())"
 * Output: 1
 * Example 2:
 *
 * Input: s = "((("
 * Output: 3
 * Example 3:
 *
 * Input: s = "()"
 * Output: 0
 * Example 4:
 *
 * Input: s = "()))(("
 * Output: 4
 */
package leetcode;

public class MinimumAddToMakeParanthesisValid {
    public static int minAddToMakeValid(String s) {
        int openParanthesis = 0, closeParanthesis=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                openParanthesis++;
            }

            if(s.charAt(i)==')'){
                if(openParanthesis>0){
                    openParanthesis--;
                }else{
                    closeParanthesis--;
                }
            }
        }

        return (openParanthesis) + (Math.abs(closeParanthesis)) ;
    }
    public static void main(String[] a){
        System.out.println(minAddToMakeValid("())"));

        System.out.println(minAddToMakeValid("((("));
        System.out.println(minAddToMakeValid("()"));
        System.out.println(minAddToMakeValid("()))(("));
        System.out.println(minAddToMakeValid(")()"));
    }
}
