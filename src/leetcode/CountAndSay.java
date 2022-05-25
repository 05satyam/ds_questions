/**
 * The count-and-say sequence is a sequence of digit strings defined by the recursive formula:
 *
 * countAndSay(1) = "1"
 * countAndSay(n) is the way you would "say" the digit string from countAndSay(n-1), which is then converted into a different digit string.
 * To determine how you "say" a digit string, split it into the minimal number of substrings such that each substring contains exactly one unique digit. Then for each substring, say the number of digits, then say the digit. Finally, concatenate every said digit.
 *
 * For example, the saying and conversion for digit string "3322251":
 */
package leetcode;

import java.util.HashMap;
import java.util.Map;

public class CountAndSay {


    public static String countAndSay(int n) {
        String res = new String();
        String s = "1";
        for(int i=1;i<n;i++){
            s = count(s);
        }

        return  s;
    }

    public static String count(String s){

        StringBuilder sb = new StringBuilder();
        int count=1;
        char ch = s.charAt(0);
        System.out.println("ch "+ ch);
        for(int i=1;i<s.length();i++){
            if (ch == s.charAt(i))
                count++;
            else{
                sb.append(count);
                sb.append(ch);
                count=1;
                ch = s.charAt(i);
            }
        }
        sb.append(count);
        sb.append(ch);
        System.out.println("sb "+ sb.toString());
        return sb.toString();
    }
    public static void main(String[] a){
        System.out.println(countAndSay(4));
    }

}
