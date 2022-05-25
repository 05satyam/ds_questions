/*
* Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.
*
* Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
Output: 7
Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
*
*
*
* */
package leetcode;

public class MinimumPathSum {
    public static int minPathSum(int[][] grid) {
        int [][] dp = new int[grid.length+1][grid[0].length+1];

        for(int i=1;i<dp.length;i++){
            dp[i][1] = dp[i-1][1]+grid[i-1][0];
        }

        for(int i=1;i<dp[0].length;i++){
            dp[1][i] = dp[1][i-1]+grid[0][i-1];
        }

       /* for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[i].length;j++){
                System.out.print(dp[i][j] +  "  ");
            }

            System.out.println();
        }*/

        for(int i=2;i<dp.length;i++){
            for(int j=2;j<dp[i].length;j++){
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1])+ grid[i-1][j-1];
            }
        }

      /*   System.out.println();
        System.out.println();System.out.println("final result");
        System.out.println();

       for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[i].length;j++){
                System.out.print(dp[i][j] +  "  ");
            }

            System.out.println();
        }
*/

        return dp[dp.length-1][dp[0].length-1];
    }

    public static void main(String[] a){
        int[][] grid = {{1,2,3},{4,5,6}};

        System.out.println(minPathSum(grid));
    }
}
