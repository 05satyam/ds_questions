/*
* Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.



Example 1:

Input: s = "leetcode"
Output: 0
*
* */
package leetcode;

import java.util.*;

public class FirstNonRepeatingChar {

    public int firstUniqChar(String s) {
        LinkedHashMap<Character, Integer> map= new LinkedHashMap<>();
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i)))
                map.put(s.charAt(i), -1);
            else{
                map.put(s.charAt(i), i);
            }
        }

        for(Map.Entry<Character, Integer> m: map.entrySet()){
            System.out.println(m.getKey() + "   "+ m.getValue());
            if(m.getValue()>=0)
                return m.getValue();
        }
        return -1;
    }
}
