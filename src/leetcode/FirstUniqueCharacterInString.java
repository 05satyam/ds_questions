/**
 *Given a string s, return the first non-repeating character in it and return its index. If it does not exist, return -1.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "leetcode"
 * Output: 0
 */
package leetcode;



import java.util.HashMap;
import java.util.Map;

class Pair<S, I extends Number> {
    int key;
    int value;

    public int getKey(){
        return this.key;
    }
    public int getValue(){
        return this.value;

    }

    public void setKey(int key){
        this.key=key;
    }
    public void setValue(int value){
        this.value=value;
    }

    Pair(int key, int value){
        this.key=key;
        this.value=value;
    }
    Pair(){}
}
public class FirstUniqueCharacterInString {
    public static int firstUniqChar(String s) {
        Map<Character, Pair<S, Number>> map = new HashMap<>();

        for(int i=0; i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                Pair<S, Number> subMap = map.get(s.charAt(i));
                map.put(s.charAt(i), new Pair<S, Number>(subMap.getKey(), subMap.getValue()+1));
            }else{
                map.put(s.charAt(i), new Pair<S, Number>(i, 1));
            }

            System.out.println("map "+ map.get(s.charAt(i)).getKey() + "   " +   map.get(s.charAt(i)).getValue());
        }

        int minIdx = Integer.MAX_VALUE;
        int freq=-1;
        for(Map.Entry<Character, Pair<S, Number>> pair: map.entrySet()){
           Pair<S, Number> pairVal = pair.getValue();
           System.out.println("pair   " + pairVal.getKey() + "   " + pairVal.getValue());
           if(pairVal.getValue()==1 && pairVal.getKey()<minIdx)
               minIdx=pairVal.getKey();
        }

        return minIdx==Integer.MAX_VALUE? -1: minIdx;
    }



    //SOLUTION 2:
    public int firstUniqChar2(String s) {
        for(char c : s.toCharArray()){
            int index = s.indexOf(c);
            int lastIndex = s.lastIndexOf(c);
            if(index == lastIndex)
                return index;
        }
        return -1;
    }

    //SOLUTION 3:

    public int firstUniqChar3(String s) {

        int freq[] = new int[26];
        for(char i: s.toCharArray()) freq[i-'a']++;
        for(int i = 0; i < s.length(); i++) if(freq[s.charAt(i)-'a'] == 1) return i;
        return -1;
    }


    public static void main(String[] a){
        System.out.println(firstUniqChar("aabb"));
    }
}
