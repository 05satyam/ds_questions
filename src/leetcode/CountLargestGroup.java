/**
 *
 * Given an integer n. Each number from 1 to n is grouped according to the sum of its digits.
 *
 * Return how many groups have the largest size.
 *
 *
 * Input: n = 13
 * Output: 4
 * Explanation: There are 9 groups in total, they are grouped according sum of its digits of numbers from 1 to 13:
 * [1,10], [2,11], [3,12], [4,13], [5], [6], [7], [8], [9]. There are 4 groups with largest size.
 */
package leetcode;

import java.util.HashMap;
import java.util.Map;

public class CountLargestGroup {
    public static  int countLargestGroup(int n) {
        int largestSize=0;
        Map<Integer, Integer> numFreqCnt = new HashMap<>();
        for(int i=1;i<=n;i++){
            int sum=0;
            int j=i;

            while(j>0){
               // System.out.print(i + "   ");
                sum+=j%10;
                j = j/10;
            }
           // System.out.println("sum "+ sum);
            int frq = numFreqCnt.containsKey(sum)? numFreqCnt.get(sum)+1: 1;
            largestSize = largestSize<frq ? frq: largestSize;
            numFreqCnt.put(sum, numFreqCnt.containsKey(sum)? numFreqCnt.get(sum)+1: 1);
        }
            int count=0;
        for(Map.Entry<Integer, Integer> map: numFreqCnt.entrySet()){
            //System.out.println("map.key  "+ map.getKey() + " , map.getval "+ map.getValue());
            if(map.getValue()>=largestSize)
                count++;

        }
//System.out.println("count "+ count);
        return count;
    }

    //SOlutionn2

    public static int countLargestSum2(int n){
        int[] ar=new int[37];
        int sum=0;
        for(int i=1;i<=n;i++){
            int d=i;
            while(d!=0){
                sum+=d%10;
                d=d/10;
            }
            ar[sum]++;
            sum=0;
        }
        int max=0;
        for(int i=0;i<37;i++){
            if(ar[i]>max){
                max=ar[i];
            }
        }
        int count=0;
        for(int i=0;i<37;i++){
            if(ar[i]==max){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] a){
        System.out.println(countLargestGroup(13));
    }
}
