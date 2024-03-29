/*
Given an integer n (in base 10) and a base k, return the sum of the digits of n after converting n from base 10 to base k.
After converting, each digit should be interpreted as a base 10 number, and the sum should be returned in base 10.

Example 1:

Input: n = 34, k = 6
Output: 9
Explanation: 34 (base 10) expressed in base 6 is 54. 5 + 4 = 9.
* */
package leetcode;

import java.util.HashSet;
import java.util.Set;

public class SumOfDigitsKBase {
    public static int sumBase(int n, int k) {

        return sumBaseCalc(n/k, k,n%k);
    }
    public static int sumBaseCalc(int n, int k, int reminder){
        if(n<k){
            return n+reminder;
        }

        int sumDig = reminder+(n%k);



        Set<Integer> test = new HashSet<>();
        return sumBaseCalc(n/k, k, sumDig);

    }
    public static void main(String[] a){
        System.out.println(sumBase(10, 10));
    }
}
