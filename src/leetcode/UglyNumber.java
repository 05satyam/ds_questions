/**
 * An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.
 *
 * Given an integer n, return true if n is an ugly number.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 6
 * Output: true
 * Explanation: 6 = 2 × 3
 */
package leetcode;

public class UglyNumber {
    public static boolean isUgly(int n) {
        if(n==0)
            return false;
        if( n==1)
            return true;

        System.out.println(n);
        if(n%2==0) {
            return isUgly(n/2);
        }
        if(n%3==0) {
            return isUgly(n/3);
        }

        if(n%5==0){
            return isUgly(n/5);
        }

        return false;
    }


    // solution 2
    public boolean isUgly2(int num) {
        for (int i=2; i<6 && num>0; i++)
            while (num % i == 0)
                num /= i;
        return num == 1;
    }


    /*
    *
    *  get Nth ugly number
    *
    * Input: n = 10
Output: 12
Explanation: [1, 2, 3, 4, 5, 6, 8, 9, 10, 12] is the sequence of the first 10 ugly numbers.
    *
    * */
    public int getNthUglyNumber(int n){

        int i=0,j=0,k=0;
        int dp[] = new int[n];
            dp[0]=1;
        int factor2 = 2, factor3 = 3, factor5 = 5;

        for(int ii=1;ii<n;ii++){
            int min = Math.min(Math.min(factor2, factor3), factor5);
            dp[ii]=min;
            if(min==factor2){
                factor2= 2* dp[++i];

            }
            if(min==factor3)
                factor3 = 3* dp[++j];
            if(min==factor5)
                factor5 = 5* dp[++k];
        }

        return dp[n-1];

    }

    public static void main(String[] a){
        System.out.println(isUgly(14));
    }
}
