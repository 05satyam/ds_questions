package leetcode.google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Test1 {
    private int MAX_ITR = 50;
    public int maxNumPair(int[] nums){
        Map<Integer, Integer> numFreqMap = new HashMap<>();
        for(int num: nums){
            numFreqMap.put(num, numFreqMap.getOrDefault(num, 0) + 1);
        }
        int maxPairCount = 0;
        for(int i = 0; i <= MAX_ITR * 2; i++){
            int curCount = 0;
            for(int j = 0; j <= i/2; j++){
                int k = i - j;
                int pairCount = Math.min(numFreqMap.getOrDefault(j, 0),  numFreqMap.getOrDefault(k, 0));
                if(j != k){
                    curCount +=  pairCount;
                }else {
                    curCount +=  pairCount / 2;
                }
            }
            maxPairCount = Math.max(curCount, maxPairCount);
        }

        return maxPairCount;
    }



    public static void generateParis(int[] arr) {
        HashMap<Integer, ArrayList> pairs = new HashMap<Integer, ArrayList>();
        int maxPair = 0;
        int currMaxVal = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int sum = arr[i] + arr[j];
                if (pairs.containsKey(sum)) {
                    ArrayList current = pairs.get(sum);
                    current.add(arr[i]);
                    current.add(arr[j]);
                    if(current.size() > maxPair) {
                        maxPair = current.size();
                        currMaxVal = sum;
                    }
                } else {
                    ArrayList list = new ArrayList();
                    list.add(arr[i]);
                    list.add(arr[j]);
                    pairs.put(arr[i] + arr[j], list);
                }

            }
        }
        System.out.println("MaxPair"+ pairs.get(currMaxVal));
    }
}
