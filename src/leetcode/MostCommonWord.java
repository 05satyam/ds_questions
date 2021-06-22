package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MostCommonWord {
    public static String mostCommonWord(String paragraph, String[] banned) {
        String[] words = paragraph.split(" ");
        List<String> bannedList = Arrays.asList(banned);
        Map<String, Integer> countFrq  = new HashMap<>();
        for(int i=0;i<words.length;i++){

            System.out.println(words[i]);
            if(bannedList.contains(words[i]))
                continue;

            countFrq.put(words[i], countFrq.containsKey(words[i])?countFrq.get(words[i])+1: 1);
        }
        int min=Integer.MIN_VALUE;
       StringBuilder res = new StringBuilder();
        for(Map.Entry<String, Integer> map: countFrq.entrySet()){
            System.out.println(map.getKey() + "  " + map.getValue());
            if(min<map.getValue()) {
                min = map.getValue();
                res = new StringBuilder(map.getKey());
            }
        }
        return res.toString();
    }


    public static void main(String[] a){
        String[] arr = new String[1];
        arr[0]="hit";
       System.out.println(mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", arr));
    }
}
