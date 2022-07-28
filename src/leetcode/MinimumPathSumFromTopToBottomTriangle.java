/*
Given a triangle array, return the minimum path sum from top to bottom.

For each step, you may move to an adjacent number of the row below. More formally, if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.


Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
Output: 11
Explanation: The triangle looks like:

 2
  3 4
 6 5 7
4 1 8 3
The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).



 */
package leetcode;

import java.util.ArrayList;
import java.util.List;

public class MinimumPathSumFromTopToBottomTriangle {
    public static int minimumTotal(List<List<Integer>> triangle) {

            int minSum =Integer.MAX_VALUE;
            int idx = -1;
            for(int i=1;i<triangle.size();i++){
                for(int j=0;j<triangle.get(i).size();j++){

                    int num = triangle.get(i).get(j);
                    int x=Integer.MAX_VALUE,y=Integer.MAX_VALUE;
                    if(j-1>=0 && j-1 <=triangle.get(i-1).size()){
                        x = num+triangle.get(i-1).get(j-1);
                    }

                    if(j>=0 && j<triangle.get(i-1).size()){
                        y = num + triangle.get(i-1).get(j);
                    }

                    if(x<=y) {
                        triangle.get(i).set(j, x);
                    }
                    else {
                        triangle.get(i).set(j, y);
                    }
                }

            }

            for(int num: triangle.get(triangle.size()-1)){
                if(num<=minSum)
                    minSum=num;
            }
            return minSum;
    }

    public static void main(String[] a){
        List<List<Integer>> list = new ArrayList<>();

        List<Integer> list1 = new ArrayList<>();
        list1.add(2);

        List<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(4);

        List<Integer> list3 = new ArrayList<>();
        list3.add(6);
        list3.add(5);
        list3.add(7);

        List<Integer> list4 = new ArrayList<>();
        list4.add(4);
        list4.add(1);
        list4.add(8);
        list4.add(3);

        list.add(list1);
        list.add(list2);
        list.add(list3);
        list.add(list4);

        System.out.println(minimumTotal(list));

    }
}
