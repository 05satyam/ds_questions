/*
*
* Question1: Write a function

class Solution { public String solution(String S); }

which, given a string S consisting of lowercase letters of the English alphabet, returns the longest consistent fragment of S which begins and ends with the same letter. If there are many possible answers you should return the one starting at the earliest position.

Examples:

1. Given S = "cbaabaab", your function should return "baabaab".

2. Given S = "performance", your function should return "erformance".

3. Given S = "cat", your function should return "c".

Write an efficient algorithm for the following assumptions:

the length of S is within the range [1..100,000];
string S consists only of lowercase letters (a−z).
*
*
*
*
*
*
*
*
* question 2:
* You are given an array of integers. Your task is to create pairs of them, such that every created pair has the same sum. This sum is not specified, but the number of created pairs should be the maximum possible. Each array element may belong to one pair only.

Write a function:

class Solution { public int solution(int[] A); }

that, given an array A consisting of N integers, returns the maximum possible number of pairs with the same sum.

Examples:

1. Given A = [1, 9, 8, 100, 2], the function should return 2. The pairs are (A[0], A[1]) and (A[2], A[4]); the sum of each pair is 10.

2. Given A = [2, 2, 2, 3], the function should return 1. Although, for instance, A[0]+A[1] = A[0]+A[2], the pairs (A[0], A[1]) and (A[0], A[2]) cannot exist at the same time, because they both contain a common element, A[0].

3. Given A = [5, 5], the function should return 1.

Assume that:

N is an integer within the range [2..50];

each element of array A is an integer within the range [1..1,000].

In your solution, focus on correctness. The performance of your solution will not be the focus of the assessment.
*
* */
package leetcode.google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GoogleTest {

    public static String longestConsistentString(String s){
        

        Map<Character, ArrayList<Integer>> charIdxDiff = new HashMap<>();
        char[] ch = s.toCharArray();
        int maxCnt = 0;
        int startIdx=0;
        int lastIdx=0;
        StringBuilder resSub = new StringBuilder();
        for(int i=0;i<ch.length;i++){
            if(charIdxDiff.containsKey(ch[i])) {
                ArrayList<Integer> previousDiffArr = charIdxDiff.get(ch[i]);
                int previousIdx = previousDiffArr.get(0);
                int peviousDiff = previousDiffArr.get(1);
                int currDiff = i-previousIdx;
                if(currDiff>peviousDiff) {
                    startIdx=previousIdx;
                    lastIdx=i;
                    previousDiffArr.add(1, currDiff);
                    charIdxDiff.put(ch[i], previousDiffArr);
                    if(currDiff>maxCnt)
                        maxCnt=currDiff;
                }
            }else{
                System.out.println("ch  "+ ch[i]);
                ArrayList<Integer> newArr  = new ArrayList<>();
                newArr.add(i);
                newArr.add(0);
                charIdxDiff.put(ch[i], newArr);

            }

        }

        System.out.println("startidx "+ startIdx + "    endidx " +lastIdx );
      return s.substring(startIdx,lastIdx+1);
    }

    public static void main(String[] s){
        System.out.println(longestConsistentString("ca"));
    }
}
