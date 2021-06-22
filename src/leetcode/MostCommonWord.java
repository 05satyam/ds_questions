package leetcode;

import java.util.*;

public class MostCommonWord {
    public static String mostCommonWord(String paragraph, String[] banned) {
        String[] words = paragraph.replaceAll("[^A-Za-z]"," ").toLowerCase().split(" ");
        List<String> bannedList = new ArrayList<>();
        for(int i = 0; i<banned.length;i++)
            bannedList.add(banned[i].toLowerCase());
        Map<String, Integer> countFrq  = new HashMap<>();
        for(int i=0;i<words.length;i++){
            if(bannedList.contains(words[i]) || words[i].equalsIgnoreCase(" ") || words[i].equalsIgnoreCase(""))
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
        String[] arr = new String[2];
        arr[0]="hit";
        arr[1]="Bob";
       System.out.println(mostCommonWord("Bob. hIt, baLl", arr));
    }
}
