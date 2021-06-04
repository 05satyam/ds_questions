/*
* Your friend is typing his name into a keyboard. Sometimes, when typing a character c, the key might get long pressed, and the character will be typed 1 or more times.

You examine the typed characters of the keyboard. Return True if it is possible that it was your friends name, with some characters (possibly none) being long pressed.



Example 1:

Input: name = "alex", typed = "aaleex"
Output: true
Explanation: 'a' and 'e' in 'alex' were long pressed.
*
* */
package leetcode;

import java.util.Arrays;

public class LongParsedName {
    public static boolean isLongPressedName(String name, String typed) {
        if(typed.length()< name.length())  return false;
        if(typed.length() == name.length()) return typed.equals(name);

        int nameIndex = 0;
        for(int i = 0; i< typed.length(); i++){
            if(nameIndex < name.length() && typed.charAt(i) == name.charAt(nameIndex)){
                nameIndex++;
            } else if(i>0 && typed.charAt(i) == typed.charAt(i-1)){
                continue;
            } else return false;
        }
        if(nameIndex == name.length())
            return true;
        else
            return false;
    }
    public static void main(String[] a){
      System.out.println(isLongPressedName("alexa", "aleexa"));
      System.out.println(isLongPressedName("leelee", "lleeelee"));
      System.out.println(isLongPressedName("laiden","laiden"));
      System.out.println(isLongPressedName("saeed","ssaaedd"));
    }
}
