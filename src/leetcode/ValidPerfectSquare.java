/**
 * Given a positive integer num, write a function which returns True if num is a perfect square else False.
 *
 * Follow up: Do not use any built-in library function such as sqrt.
 *
 *
 *
 * Example 1:
 *
 * Input: num = 16
 * Output: true
 * Example 2:
 *
 * Input: num = 14
 * Output: false
 */
package leetcode;

public class ValidPerfectSquare {
    public static boolean isPerfectSquare(int num) {
        double sqrtRoot = Math.sqrt(num);
        int sqrtInt = (int)sqrtRoot;
        //System.out.println(sqrtInt + "   " + ((sqrtInt*sqrtInt)==num));
       return (sqrtInt*sqrtInt==num);
    }

    public static void main(String[] a){
        System.out.println(isPerfectSquare(13));
    }
}
