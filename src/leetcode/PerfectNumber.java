/**
 * A perfect number is a positive integer that is equal to the sum of its positive divisors, excluding the number itself. A divisor of an integer x is an integer that can divide x evenly.
 *
 * Given an integer n, return true if n is a perfect number, otherwise return false.
 *
 *
 * Input: num = 28
 * Output: true
 * Explanation: 28 = 1 + 2 + 4 + 7 + 14
 * 1, 2, 4, 7, and 14 are all divisors of 28.
 * Example 2:
 *
 * Input: num = 6
 * Output: true
 */
package leetcode;

public class PerfectNumber {
    public boolean checkPerfectNumber(int num) {
        if(num==1) return false;

        int i = 2;
        int sq =(int)Math.sqrt(num);
        int sum=1;
        while(i<=sq){
            if(num%i==0) {
                sum+=i;
                sum+=num/i;
            }
            i++;
        }
        if(sum==num) return true;

        return false;
    }
}
