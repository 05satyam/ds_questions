/**
 * 11.  Container With Most Water
 *
 *
 * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
 *
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 *
 * Return the maximum amount of water a container can store.
 *
 * Notice that you may not slant the container.
 */
package leetcode;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int iIdx=0, jIdx=height.length-1, maxArea=-1, maxLeftVal=-1, maxRightVal=-1;
        while(iIdx<jIdx){
            maxArea = Math.max(maxArea , (Math.min(height[iIdx], height[jIdx]) * (jIdx-iIdx)));
            if(height[iIdx]<height[jIdx])
                iIdx++;
            else
                jIdx--;
        }
        return maxArea;
    }
}
