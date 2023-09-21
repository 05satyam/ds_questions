/***
 * You have a keypad with 9 buttons, numbered from 1 to 9, each mapped to lowercase English letters. You can choose which characters each button is matched to as long as:
 *
 * All 26 lowercase English letters are mapped to.
 * Each character is mapped to by exactly 1 button.
 * Each button maps to at most 3 characters.
 * To type the first character matched to a button, you press the button once. To type the second character, you press the button twice, and so on.
 *
 * Given a string s, return the minimum number of keypresses needed to type s using your keypad.
 *
 * Note that the characters mapped to by each button, and the order they are mapped in cannot be changed.
 *
 * Input: s = "apple"
 * Output: 5
 * Explanation: One optimal way to setup your keypad is shown above.
 * Type 'a' by pressing button 1 once.
 * Type 'p' by pressing button 6 once.
 * Type 'p' by pressing button 6 once.
 * Type 'l' by pressing button 5 once.
 * Type 'e' by pressing button 3 once.
 * A total of 5 button presses are needed, so return 5.
 *
 *
 */
package leetcode;

import java.util.*;

public class MinNumberOfKeyPress {
    public int minimumKeypresses_1(String s) {
        Map<Character, Integer> charCnt = new HashMap<>();
        int n = s.length();

        for(int i=0;i<n ;i++){
            charCnt.put(s.charAt(i), charCnt.getOrDefault(s.charAt(i), 0)+1);
        }

        List<Map.Entry<Character, Integer> > list =
                new LinkedList<Map.Entry<Character, Integer> >(charCnt.entrySet());

        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<Character, Integer> >() {
            public int compare(Map.Entry<Character, Integer> o1,
                               Map.Entry<Character, Integer> o2)
            {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });
        HashMap<Character, Integer> temp = new LinkedHashMap<Character, Integer>();
        for (Map.Entry<Character, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }

        int[] charArr = new int[26];
        Arrays.fill(charArr, 0);
        int k=1;
        for(Map.Entry<Character, Integer> m : temp.entrySet()){
            char key = m.getKey();
            int idx = key-'a';
            charArr[idx] = k;
            k++;
        }

        for(Integer ii : charArr){
            System.out.print(ii + "  ");
        }

        int cnt=0;
        for(int iii=0;iii<n;iii++){
            char aa = s.charAt(iii);
            int idxVal = charArr[aa-'a'];
            if(idxVal<=9)
                cnt++;

            else if(idxVal>9 && idxVal<=18)
                cnt+=2;
            else if(idxVal>0)
                cnt+=3;
        }
        return cnt;
    }

    public int minimumKeypresses_2(String s) {
        int result = 0;
        Integer[] count = new Integer[26];
        Arrays.fill(count, 0);
        for(int i=0; i<s.length(); i++) {
            count[s.charAt(i)-'a']++;
        }
        Arrays.sort(count, (a,b)->b-a);
        for(int i=0; i<26; i++) {
            if(i<9) {
                result += count[i];
            } else if(i<18) {
                result += 2*count[i];
            } else {
                result += 3*count[i];
            }
        }
        return result;
    }
}
