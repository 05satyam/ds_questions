/**
 *
 *
 * There are n buildings in a line. You are given an integer array heights of size n that represents the heights of the buildings in the line.
 *
 * The ocean is to the right of the buildings. A building has an ocean view if the building can see the ocean without obstructions. Formally, a building has an ocean view if all the buildings to its right have a smaller height.
 *
 * Return a list of indices (0-indexed) of buildings that have an ocean view, sorted in increasing order.
 *
 *
 *
 * Example 1:
 *
 * Input: heights = [4,2,3,1]
 * Output: [0,2,3]
 * Explanation: Building 1 (0-indexed) does not have an ocean view because building 2 is taller.
 * Example 2:
 *
 * Input: heights = [4,3,2,1]
 * Output: [0,1,2,3]
 * Explanation: All the buildings have an ocean view.
 */

package leetcode;




import java.util.ArrayList;

import java.util.List;

public class BuildingsWithAnOceanView {
    public int[] findBuildings(int[] heights) {
        int n = heights.length-1;
        int maxHeight = heights[n];
        for(int i=n-1;i>=0;i--){
            if(heights[i]<=maxHeight)
                heights[i]=-1;
            else if(heights[i]>maxHeight)
                maxHeight = heights[i];
        }

        List<Integer> arr = new ArrayList<>();
        for(int i=0;i<=n;i++){
            System.out.println(heights[i]);
            if(heights[i]!=-1){
                arr.add(i);

            }
        }
        int[] ret = new int[arr.size()];
        for(int i = 0; i < ret.length; i++)
            ret[i] = arr.get(i);
        return ret;
    }
}
