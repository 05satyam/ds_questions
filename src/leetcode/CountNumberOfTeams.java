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
