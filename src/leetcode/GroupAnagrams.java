/*
* Given an array of strings strs, group the anagrams together. You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.



Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
* */
package leetcode;

import java.util.*;

public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> stringToAnangram = new HashMap<>();

        for(int i=0;i<strs.length;i++){
            char[] strArr = strs[i].toCharArray();
            Arrays.sort(strArr);
            String sortedStr = String.valueOf(strArr);
            System.out.println("sorted str "+ sortedStr);

            if(stringToAnangram.containsKey(sortedStr)){
               List<String>  anagramList = stringToAnangram.get(sortedStr);
               anagramList.add(strs[i]);
               stringToAnangram.put(sortedStr,anagramList);
            }else{
                List<String> anagramList  =new ArrayList<>();
                anagramList.add(strs[i]);
                stringToAnangram.put(sortedStr,anagramList);
            }
        }

        List<List<String>> res  = new ArrayList<>();

        for(Map.Entry<String, List<String>> mapSet : stringToAnangram.entrySet()){
            res.add(mapSet.getValue());
        }
        return res;
    }

    public  static  void main(String[] a){
        String[] input = {"eat","tea","tan","ate","nat","bat"};
        //System.out.println(groupAnagrams(input));
        System.out.println(minSwaps("1110"));
        System.out.println(countAndPalindromize("111000"));
    }


    public long countPossibleSegment(int[] weights, int k) {
        long count=0;
        for (int i = 0; i < weights.length; i++) {
            int max = weights[i], min = weights[i];
            for (int j = i; j < weights.length; j++) {

                max = Math.max(max, weights[j]);
                min = Math.min(min, weights[j]);
               long res = Math.abs(max - min);
                if(res>=k)
                    count++;
            }
        }
       return count;
    }


    public static int minSwaps(String s) {
        int count = 0;
        char[] chars = s.toCharArray();
        int left = 0, right = chars.length - 1;
        while(left <= right) {
            if(chars[left] != chars[right])
                count++;
            left++;
            right--;
        }

        if(count % 2 == 1 && chars.length%2==1)
            return -1;

        return (count + 1) / 2;
    }
    public static int minSwaps1(String s) {
        int cntOne = 0, cntZero = 0;
        for (char c : s.toCharArray())
            if (c == '0') ++cntZero;
            else ++cntOne;
        if (Math.abs(cntOne - cntZero) > 1) // Invalid
            return -1;
        if (cntZero > cntOne)
            return countSwaps(s, '0');
        if (cntZero < cntOne)
            return countSwaps(s, '1');

        return Math.min(countSwaps(s, '0'), countSwaps(s, '1'));
    }
   static int countSwaps(String s, char start) {
        int cntWrongPos = 0;
        for (char c : s.toCharArray()) {
            if (c != start) ++cntWrongPos;
            start = (char) ('1' - start + '0');
        }
        return cntWrongPos / 2;
    }




    private static int countOnly(String input)
    {
        int n = input.length();
        int count = 0;
        char[] inputAsCharArray = input.toCharArray();
        for (int i = 0; i < n / 2; i++)
        {
            if (inputAsCharArray[i] != inputAsCharArray[n - i - 1])
            {
                count++;
            }
        }
        if (count % 2 == 1 && n % 2 == 0)
            return -1;
        return (count + 1) / 2;
    }
    private static int countAndPalindromize(String input)
    {
        int n = input.length();
        int swapsCount = 0;
        int swaps[] = new int[n/2];
        for(int i = 0; i < swaps.length; i++)
        {
            swaps[i] = -1;
        }
        char[] inputAsCharArray = input.toCharArray();
        int count = 0;
        for (int i = 0; i < n / 2; i++)
        {
            if (inputAsCharArray[i] != inputAsCharArray[n - i - 1])
            {
                count++;
                if (swaps[0] != -1)
                {
                    if (inputAsCharArray[i] != inputAsCharArray[swaps[0]])
                    {
                        char c = inputAsCharArray[i];
                        inputAsCharArray[i] = inputAsCharArray[swaps[0]];
                        inputAsCharArray[swaps[0]] = c;
                        for (int y = 1; y <= swapsCount; y++)
                        {
                            swaps[y - 1] = swaps[y];
                        }
                        swapsCount--;
                    }
                    else if (inputAsCharArray[n - i - 1] != inputAsCharArray[swaps[0]])
                    {
                        char c = inputAsCharArray[n - i - 1];
                        inputAsCharArray[n - i - 1] = inputAsCharArray[swaps[0]];
                        inputAsCharArray[swaps[0]] = c;
                        for (int y = 1; y <= swapsCount; y++)
                        {
                            swaps[y - 1] = swaps[y];
                        }
                        swapsCount--;
                    }
                    else
                    {
                        swaps[swapsCount++] = n - i - 1;
                    }
                }
                else
                {
                    swaps[swapsCount++] = n - i - 1;
                }
            }
        }

        if (count % 2 == 1 && n % 2 == 0)
            return -1;
        return (count + 1) / 2;
    }
}
