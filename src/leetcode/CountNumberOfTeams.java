/*
* There are n soldiers standing in a line. Each soldier is assigned a unique rating value.

You have to form a team of 3 soldiers amongst them under the following rules:

Choose 3 soldiers with index (i, j, k) with rating (rating[i], rating[j], rating[k]).
A team is valid if: (rating[i] < rating[j] < rating[k]) or (rating[i] > rating[j] > rating[k]) where (0 <= i < j < k < n).
Return the number of teams you can form given the conditions. (soldiers can be part of multiple teams).



Example 1:

Input: rating = [2,5,3,4,1]
Output: 3
Explanation: We can form three teams given the conditions. (2,3,4), (5,4,1), (5,3,1).
* */
package leetcode;

public class CountNumberOfTeams {

    public int numTeams(int[] rating) {
        int length = rating.length;
        int [] dp = new int[length];
        int count = 0;
        for (int i=0; i<length; i++) {
            for (int j=i; j>=0; j--) {
                if (rating[i] < rating[j]) {
                    dp[i] += 1;
                    count += dp[j];
                }
            }
        }
        dp = new int[length];
        for (int i=0; i<length; i++) {
            for (int j=i; j>=0; j--) {
                if (rating[i] > rating[j]) {
                    dp[i] += 1;
                    count += dp[j];
                }
            }
        }
        return count;
    }
}
