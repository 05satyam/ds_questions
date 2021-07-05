/**
 * You are given a string num, representing a large integer. Return the largest-valued odd integer (as a string) that is a non-empty substring of num, or an empty string "" if no odd integer exists.
 *
 * A substring is a contiguous sequence of characters within a string.
 *
 *
 *
 * Example 1:
 *
 * Input: num = "52"
 * Output: "5"
 * Explanation: The only non-empty substrings are "5", "2", and "52". "5" is the only odd number.
 */
package leetcode;

public class LargestOddNumberInString {
    public static String largestOddNumber(String num) {
        for(int i=num.length()-1;i>=0;i--){
            //System.out.println(i);
            if(Integer.valueOf(num.charAt(i))%2!=0)
                return num.substring(0,i+1);
            /*System.out.println(i);
            String sub = num.substring(0,i);
            System.out.println(sub);
            if(Long.valueOf(sub)%2!=0){
                return sub;*/
            }
        //}
        return "";
    }
    public static void main(String[] a){
        System.out.println("res "+ largestOddNumber("52"));
    }
}
