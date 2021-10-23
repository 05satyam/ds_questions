package leetcode;

import java.util.*;

public class SortCharacterByFrequence {
    public String frequencySort(String s) {
        Map<Character ,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
                if(map.containsKey(s.charAt(i)))
                    map.put(s.charAt(i),map.get(s.charAt(i))+1);
                else
                    map.put(s.charAt(i) , 1);
        }
        List<Map.Entry<Character, Integer>> list = new LinkedList<Map.Entry<Character, Integer>>(map.entrySet());;
        Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>()
        {
            public int compare(Map.Entry<Character, Integer> o1,
                               Map.Entry<Character, Integer> o2) {
                    return o2.getValue().compareTo(o1.getValue());
            }
        });

        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> sortedMap = new LinkedHashMap<Character, Integer>();
        for (Map.Entry<Character, Integer> entry : list)
        {
            int k=entry.getValue();
            while(k-->0)
                sb.append(entry.getKey());
            //sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sb.toString();
    }
}
