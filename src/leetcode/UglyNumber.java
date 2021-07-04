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

    public static void main(String[] a){
        System.out.println(isUgly(14));
    }
}
