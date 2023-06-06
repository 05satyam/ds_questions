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

    public static void main(String[] a){
        System.out.println(removeOccurrences("daabcbaabcbc", "abc"));
    }
}
