/*
THIS SOLUTION OS FROM GEEKS FOR GEEKS ----done for practice work only

Given a string s, return the longest
palindromic

substring
 in s.



Example 1:

Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.
 */
package leetcode;

public class LongestPalindromicSubstring {
    static int count=0;
    static String ss=null;
    public static String longestPalindrome(String s) {
        int n = s.length();
        boolean dp[][] = new boolean[n][n];
        int maxLength = 1;
        for(int i=0;i<n;i++)
            dp[i][i]= true;

        int start = 0;
        for(int i=0;i<n-1;i++){
            if(s.charAt(i)==s.charAt(i+1)) {
                dp[i][i + 1] = true;
                start = i;
                maxLength = 2;
            }
        }

        for(int k=3;k<=n;k++){
            for( int i=0;i<n-k+1;++i){
                int j = i+k-1;

                if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]){
                    dp[i][j] = true;

                    if (k > maxLength) {
                        start = i;
                        maxLength = k;
                    }
                }
            }
        }

        return s.substring(start, start+maxLength);
    }
    static String printSubStr(
            String str, int low, int high)
    {

               return str.substring(
                        low, high + 1);
    }
    public static void main(String[] a){
        System.out.println(longestPalindrome("baab"));
    }
}
