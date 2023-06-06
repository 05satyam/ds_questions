/**
 * Given two strings s and part, perform the following operation on s until all occurrences of the substring part are removed:
 *
 * Find the leftmost occurrence of the substring part and remove it from s.
 * Return s after removing all occurrences of part.
 *
 * A substring is a contiguous sequence of characters in a string.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "daabcbaabcbc", part = "abc"
 * Output: "dab"
 * Explanation: The following operations are done:
 * - s = "daabcbaabcbc", remove "abc" starting at index 2, so s = "dabaabcbc".
 * - s = "dabaabcbc", remove "abc" starting at index 4, so s = "dababc".
 * - s = "dababc", remove "abc" starting at index 3, so s = "dab".
 * Now s has no occurrences of "abc".
 */
package leetcode;


public class RemoveOccurancesFromString {
    public static String removeOccurrences(String s, String part) {

        while(s.length()>0 && s.indexOf(part)!=-1){
            System.out.println(s.indexOf(part));
                s = s.substring(0, s.indexOf(part)) + s.substring(s.indexOf(part) + part.length());
       }

        return s;
    }

    //sliding window
    public static String removeOccurrences2(String s, String part) {

        int i=0,j=0;
        if(s.equalsIgnoreCase(part))
            return "";

        if(s.length()<part.length())
            return s;

        while(i<s.length() && j<s.length()){
            if(j-i+1< part.length()){
                j++;
            }else{
                String tmp = s.substring(i,j+1);
                if(tmp.equalsIgnoreCase(part)){
                    s = s.substring(0,i)+ s.substring(j+1);
                    i=0;j=0;
                }else{
                    i++;
                    j++;
                }
            }
        }
        return s;
    }


    public static void main(String[] a){
        System.out.println(removeOccurrences2("daabcbaabcbc", "abc"));
    }
}
