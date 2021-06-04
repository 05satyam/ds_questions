/*
* You are given an array points where points[i] = [xi, yi] is the coordinates of the ith point on a 2D plane. Multiple points can have the same coordinates.

You are also given an array queries where queries[j] = [xj, yj, rj] describes a circle centered at (xj, yj) with a radius of rj.

For each query queries[j], compute the number of points inside the jth circle. Points on the border of the circle are considered inside.

Return an array answer, where answer[j] is the answer to the jth query.
*
*
* Input: points = [[1,3],[3,3],[5,3],[2,2]], queries = [[2,3,1],[4,3,1],[1,1,2]]
Output: [3,2,2]
Explanation: The points and circles are shown above.
queries[0] is the green circle, queries[1] is the red circle, and queries[2] is the blue circle.
*
*
* */
package leetcode;

public class QueriesOnNumberOfPointsInsideCircle {
    public static int[] countPoints(int[][] points, int[][] queries) {
        int[] res = new int[queries.length];

        for(int i=0;i<queries.length;i++){
            int x=queries[i][0];
            int y=queries[i][1];
            int r=queries[i][2];
            int count=0;
            for(int j=0;j<points.length;j++){
                int x1=points[j][0];
                int y1=points[j][1];

                if(((x1-x)*(x1-x)+((y1-y)*(y1-y))) <= (r*r))
                    count++;
            }

            res[i]=count;
        }
        return res;
    }
    public static void main(String[] a){
        int[][] points=  {{1,3},{3,3},{5,3},{2,2}};
        int[][] queries= {{2,3,1}, {4,3,1},{1,1,2}};
        int[] res = countPoints(points, queries);
        for(int i=0;i<res.length;i++){
            System.out.println(res[i]);
        }
    }
}
