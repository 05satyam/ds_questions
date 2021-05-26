/*
* Given an array points where points[i] = [xi, yi] represents a point on the X-Y plane, return true if these points are a boomerang.

A boomerang is a set of three points that are all distinct and not in a straight line.
Example 1:

Input: points = [[1,1],[2,3],[3,2]]
Output: true
* */
package leetcode;

public class ValidBoomerang {
    public static boolean isBoomerang(int[][] points) {
        int x1 = points[0][0];
        int y1=points[0][1];
        int x2 = points[1][0];
        int y2=points[1][1];
        int x3=points[2][0];
        int y3=points[2][1];

        float arr = (x1*(y2-y3) + x2*(y3-y1) + x3*(y1-y2));
        return (arr>0.0|| arr<0.0)? true: false;

    }
    public static void main(String[] a){
        int[][] points = {{0,0},{1,2},{0,1}};
        System.out.println(isBoomerang(points));
    }
}
