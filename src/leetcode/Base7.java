/*
* Given an integer num, return a string of its base 7 representation.



Example 1:

Input: num = 100
Output: "202"
* */
package leetcode;

public class Base7 {
    public static String convertToBase7(int num) {
        if (num == 0) return "0";
        StringBuilder sb = new StringBuilder();
        boolean isNeg = false;

        if (num < 0) {
            num = -num;
            isNeg = true;
        }

        while (num > 0) {
            sb.append(num % 7);
            num = num / 7;
        }
        if (isNeg) sb.append('-');
        return sb.reverse().toString();

    }
    public static void main(String[] a){
        System.out.println(convertToBase7(7));
    }
}
