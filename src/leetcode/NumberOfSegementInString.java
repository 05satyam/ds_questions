/**
 * You are given a string s, return the number of segments in the string.
 *
 * A segment is defined to be a contiguous sequence of non-space characters.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "Hello, my name is John"
 * Output: 5
 * Explanation: The five segments are ["Hello,", "my", "name", "is", "John"]
 */
package leetcode;

public class NumberOfSegementInString {
    public static  int countSegments(String s) {
        if(s.equalsIgnoreCase(""))
            return 0;
        int count=0;
        String[] words  =s.split(" ");
        for(int i=0;i<words.length;i++){
            if(words[i].isEmpty())
                continue;

            count++;

        }

        return count;
    }

    public static void main(String[] a){
        System.out.println(countSegments(" "));
    }
}
