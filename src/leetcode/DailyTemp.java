/**
 * Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.
 *
 *
 *
 * Example 1:
 *
 * Input: temperatures = [73,74,75,71,69,72,76,73]
 * Output: [1,1,4,2,1,1,0,0]
 *
 *
 */
package leetcode;

import java.util.*;

public class DailyTemp {
    public static int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        if(temperatures.length==0)
            return res;

        if(temperatures.length==1){
            res[0]=0;
            return res;
        }
        Stack<Integer> tmpSet = new Stack<>();
        Map<Integer, Stack<Integer>> tempIdx = new HashMap<>();
        int k=0;
        tmpSet.add(temperatures[0]);
        Stack<Integer> s = new Stack<>();
        s.add(0);
        tempIdx.put(temperatures[0], s);
        for(int i=1;i<temperatures.length;i++){

            if(temperatures[i]>tmpSet.peek()) {
                while (tmpSet.size()>0 && temperatures[i] > tmpSet.peek()) {
                    int top = tmpSet.pop();
                    Stack<Integer> topIdxx = tempIdx.get(top);
                    int idx = topIdxx.pop();
                    res[idx] = i - idx;

                }
            }
            tmpSet.add(temperatures[i]);
            if(!tempIdx.containsKey(temperatures[i])){
                Stack<Integer> idxStack = new Stack<>();
                idxStack.add(i);
              tempIdx.put(temperatures[i], idxStack);
            }else{
                Stack<Integer> idxStack = tempIdx.get(temperatures[i]);
                idxStack.add(i);
                tempIdx.put(temperatures[i], idxStack);
            }
        }

        res[res.length-1]=0;

        for(int i=0;i<res.length;i++){
            System.out.print(res[i] + "  ");
        }
        System.out.println();
        return res;
    }

    public static void main(String[] a){
        int[] arr={73,74,75,71,69,72,76,73};
        int[] arr2= {30,40,50,60};
        dailyTemperatures(arr2);
    }
}
