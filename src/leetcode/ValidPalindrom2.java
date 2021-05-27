/*
* Given a string s, return true if the s can be palindrome after deleting at most one character from it.



Example 1:

Input: s = "aba"
Output: true
* */
package leetcode;

public class ValidPalindrom2 {
    public boolean validPalindromeUtil(String s, int start, int end){
        while(start<=end){
            if(s.charAt(start)!= s.charAt(end)){
                return false;
            }
            start++; end--;
        }
        return true;
    }

    public boolean validPalindrome(String s) {
        int len = s.length();
        int start =0; int end = len-1;
        while(start<=end){
            if(s.charAt(start)!= s.charAt(end)){
                return validPalindromeUtil(s,start,end-1) || validPalindromeUtil(s,start+1,end);
            }
            start++; end--;
        }
        return true;
    }
}
