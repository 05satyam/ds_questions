/*
**Given an integer n, return the number of strings of length n that consist only of vowels (a, e, i, o, u) and are lexicographically sorted.

A string s is lexicographically sorted if for all valid i, s[i] is the same as or comes before s[i+1] in the alphabet.



Example 1:

Input: n = 1
Output: 5
Explanation: The 5 sorted strings that consist of vowels only are ["a","e","i","o","u"].

 * */
package leetcode;

public class CountSortedVowelString {
    public int countVowelStrings(int n) {
        int a = 1;
        int e = 1;
        int i = 1;
        int o = 1;
        int u = 1;
        while(n-- > 1){
            a = a + e + i + o + u;
            e = e + i + o + u;
            i = i + o + u;
            o = o + u;
            u = u;
        }
        return a + e + i + o + u;

    }


    //SOLUTION 2:
    public int countVowelStrings2(int n) {
        // create a dp array of size 6
        int [] dp = new int [6];
        // dp[0] must be 0 and the rest 1
        for (int i=1; i<dp.length; i++)
            dp[i] = 1;
        for (int i=1; i<=n; i++) {
            for (int k=1; k<=5; k++) {
                dp[k] += dp[k-1];
            }
        }
        return dp[5];
    }
}
