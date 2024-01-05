/**
 * 1456. Maximum Number of Vowels in a Substring of Given Length
 * Solved
 * Medium
 * Topics
 * Companies
 * Hint
 * Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.
 *
 * Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abciiidef", k = 3
 * Output: 3
 * Explanation: The substring "iii" contains 3 vowel letters.
 * Example 2:
 *
 * Input: s = "aeiou", k = 2
 * Output: 2
 * Explanation: Any substring of length 2 contains 2 vowels.
 * Example 3:
 *
 * Input: s = "leetcode", k = 3
 * Output: 2
 * Explanation: "lee", "eet" and "ode" contain 2 vowels.
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 105
 * s consists of lowercase English letters.
 * 1 <= k <= s.length
 */
package leetcode;


class MaxNumVowvelsInGivenSubstring {
    public boolean find(char c){
        return c=='a' || c=='e' || c=='i' || c=='o' || c=='u';
    }

    public int maxVowels(String s, int k) {
        int n = s.length();
        char[] cc = s.toCharArray();
        int maxV = Integer.MIN_VALUE;
        int[] pre = new int[n];

        if(find(cc[0]))
            pre[0]=1;

        for(int i=1;i<n;i++){
            pre[i] = find(cc[i])? pre[i-1]+1 : pre[i-1];
        }

        k--;
        for(int i=k;i<n;i++){

            int pree =  pre[i]-pre[i-k];

            if(find(cc[i-k])){
                pree +=1;
            }
            maxV = maxV <= pree ? pree : maxV;
        }

        return maxV;
    }
}