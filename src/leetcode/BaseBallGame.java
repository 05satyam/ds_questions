/**
 * You are keeping score for a baseball game with strange rules. The game consists of several rounds, where the scores of past rounds may affect future rounds' scores.
 *
 * At the beginning of the game, you start with an empty record. You are given a list of strings ops, where ops[i] is the ith operation you must apply to the record and is one of the following:
 *
 * An integer x - Record a new score of x.
 * "+" - Record a new score that is the sum of the previous two scores. It is guaranteed there will always be two previous scores.
 * "D" - Record a new score that is double the previous score. It is guaranteed there will always be a previous score.
 * "C" - Invalidate the previous score, removing it from the record. It is guaranteed there will always be a previous score.
 * Return the sum of all the scores on the record. The test cases are generated so that the answer fits in a 32-bit integer.
 *
 *
 *
 * Example 1:
 *
 * Input: ops = ["5","2","C","D","+"]
 * Output: 30
 * Explanation:
 * "5" - Add 5 to the record, record is now [5].
 * "2" - Add 2 to the record, record is now [5, 2].
 * "C" - Invalidate and remove the previous score, record is now [5].
 * "D" - Add 2 * 5 = 10 to the record, record is now [5, 10].
 * "+" - Add 5 + 10 = 15 to the record, record is now [5, 10, 15].
 * The total sum is 5 + 10 + 15 = 30.
 */
package leetcode;

import java.util.ArrayList;
import java.util.List;

public class BaseBallGame {
        public int calPoints(String[] ops) {
            int totalSum=0;
            List<Integer> numList = new ArrayList<>();
            int k=-1;
            for(int i=0;i<ops.length;i++){
                switch(ops[i]){
                    case "+":
                        numList.add((numList.get(k) + numList.get(k-1)));
                        k++;
                        break;
                    case "D":
                        int doubleNum = numList.get(k) * 2;
                        //  totalSum += doubleNum;
                        numList.add(doubleNum);
                        k++;
                        break;
                    case "C":
                        //totalSum -= prevNum;
                        //prevNum = numList.get(k);
                        numList.remove(k);
                        k--;
                        break;
                    default:
                        // totalSum += Integer.valueOf(ops[i]);
                        //prevNum=Integer.valueOf(ops[i]);
                        numList.add(Integer.valueOf(ops[i]));
                        k++;
                        break;
                }
            }

            for(Integer num : numList){
                totalSum+=num;
            }
            return totalSum;
        }
}
