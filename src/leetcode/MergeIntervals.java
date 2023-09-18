/**
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
 *
 *
 *
 * Example 1:
 *
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
 * Example 2:
 *
 * Input: intervals = [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 *
 *
 *
 *
 */
package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeIntervals {
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b)-> a[0]-b[0]);
        ArrayList<Integer> mergedList = new ArrayList<>();
        int s=0, end=0;
        for(int i=0;i<intervals.length;i++){
            int fst = intervals[i][0];
            int scnd = intervals[i][1];
            if(i==0){
                mergedList.add(fst);
                mergedList.add(scnd);
                s=0;
                end=1;
            }else{
                if((fst>=mergedList.get(s) && fst<=mergedList.get(end)) && scnd > mergedList.get(end)){
                    System.out.println("mergedList.get(end) "+ mergedList.get(end));
                    mergedList.set(end, scnd);
                }else{
                    mergedList.add(fst);
                    mergedList.add(scnd);
                    s +=2;
                    end +=2;
                }

            }
        }
        for(Integer i : mergedList){
            System.out.print(i +"   ");
        }
        System.out.println();
        int[][] res = new int[mergedList.size()/2][2];
        int k=0;
        for(int i=0;i<mergedList.size()-1;){
            res[k][0] = mergedList.get(i);
            res[k][1] = mergedList.get(i+1);
            i=i+2;
            k++;
        }
        return res;
    }

    public static void main(String[] a){
        int[][] arr = {{1,3},{2,6},{8,10},{15,18}};
        int[][] res = merge((arr));
        for(int i=0;i< res.length;i++){
            System.out.println(res[i][0]  + " -  " + res[i][1]);
        }
    }
}
