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

class Pair {
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
        Map<Character, Pair> map = new HashMap<>();

        for(int i=0; i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                Pair subMap = map.get(s.charAt(i));
                map.put(s.charAt(i), new Pair(subMap.getKey(), subMap.getValue()+1));
            }else{
                map.put(s.charAt(i), new Pair(i, 1));
            }

            System.out.println("map "+ map.get(s.charAt(i)).getKey() + "   " +   map.get(s.charAt(i)).getValue());
        }

        int minIdx = Integer.MAX_VALUE;
        int freq=-1;
        for(Map.Entry<Character, Pair> pair: map.entrySet()){
           Pair pairVal = pair.getValue();
           System.out.println("pair   " + pairVal.getKey() + "   " + pairVal.getValue());
           if(pairVal.getValue()==1 && pairVal.getKey()<minIdx)
               minIdx=pairVal.getKey();
        }

        return minIdx==Integer.MAX_VALUE? -1: minIdx;
    }

    public static void main(String[] a){
        System.out.println(firstUniqChar("aabb"));
    }
}
