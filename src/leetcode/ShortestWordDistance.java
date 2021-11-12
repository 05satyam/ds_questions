/*
Given an array of strings wordsDict and two different strings that already exist in the array word1 and word2, return the shortest distance between these two words in the list.



Example 1:

Input: wordsDict = ["practice", "makes", "perfect", "coding", "makes"], word1 = "coding", word2 = "practice"
Output: 3
 */
package leetcode;

import java.util.*;

public class ShortestWordDistance {
    public static int shortestDistance(String[] wordsDict, String word1, String word2) {
        Map<String, List<Integer>> map = new HashMap<>();
        for(int i=0;i< wordsDict.length;i++){
            if(wordsDict[i].equalsIgnoreCase(word1))
                if(map.containsKey(word1)){
                    List<Integer> w1 = map.get(word1);
                    w1.add(i);
                    map.put(word1, w1);
                }else{
                    map.put(word1, new ArrayList<Integer>(Arrays.asList(i)));
                }



            if(wordsDict[i].equalsIgnoreCase(word2))
                if(map.containsKey(word2)){
                    List<Integer> w1 = map.get(word2);
                    w1.add(i);
                    map.put(word2, w1);
                }else{
                    map.put(word2, new ArrayList<Integer>(Arrays.asList(i)));
                }

        }
        System.out.println("list sizes , w1 "+ map.get(word1).size() + "     w2   " +  map.get(word2).size() );
        int min=Integer.MAX_VALUE;
        for(Integer x: map.get(word1)){

            for(Integer y: map.get(word2)){

                int dist  = Math.abs(x-y);
                System.out.println("dist " +  dist    +  "    min   "+  min);
                if(min>dist)
                    min=dist;
            }
        }

        return min;
    }


    //solution2
    public int shortestDistance2(String[] words, String word1, String word2) {
        int p1 = -1, p2 = -1, min = Integer.MAX_VALUE;

        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1))
                p1 = i;

            if (words[i].equals(word2))
                p2 = i;

            if (p1 != -1 && p2 != -1)
                min = Math.min(min, Math.abs(p1 - p2));
        }

        return min;
    }


    public static void main(String[] na){
        String[] s= {"practice", "makes", "perfect", "coding", "makes"};
        System.out.println(shortestDistance(s,"makes", "coding" ));
    }
}
