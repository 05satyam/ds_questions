/*
You are given a string word that consists of digits and lowercase English letters.

You will replace every non-digit character with a space. For example, "a123bc34d8ef34" will become " 123  34 8  34". Notice that you are left with some integers that are separated by at least one space: "123", "34", "8", and "34".

Return the number of different integers after performing the replacement operations on word.

Two integers are considered different if their decimal representations without any leading zeros are different.
 Input: word = "a123bc34d8ef34"
Output: 3
Explanation: The three different integers are "123", "34", and "8". Notice that "34" is only counted once.
Example 2:

Input: word = "leet1234code234"
Output: 2
 */
package leetcode;

import java.util.HashSet;
import java.util.Set;

public class NumberOfDifferentIntegersInString {
    public static int numDifferentIntegers(String word) {
        boolean foundInt=false;
        int count=0;
        String num = "";
        Set<String> set = new HashSet<>();
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(ch-48>=0 && ch-48<=9){
                foundInt=true;
                if(ch-48 ==0 && num!=""){
                    num+=ch-48;
                }
                if(ch-48!=0 ){
                    num+=(ch-48);
                }
            }

            if(ch>='a' && ch<='z'){
                if(foundInt){
                    count++;
                    set.add((num));
                    num="";
                    foundInt=false;
                }
            }
        }
        if( foundInt)
            set.add((num));
        return set.size();
    }
    public static void main(String[] a){
        System.out.println(numDifferentIntegers("a123bc34d8ef34"));
        System.out.println(numDifferentIntegers("leet1234code234"));
        System.out.println(numDifferentIntegers("gi851a851q8510v"));
    }
}
