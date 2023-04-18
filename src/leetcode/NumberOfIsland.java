/**
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
 *
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 *
 *
 *
 * Example 1:
 *
 * Input: grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * Output: 1
 */

package leetcode;

import java.util.Arrays;

public class NumberOfIsland {
    public static void isIsland(char[][] grid, int i,int j,int n,int m){
        //System.out.println("inside "+  (grid[i][j] != '1'));
        if(i<0 || j<0 || i>=n || j>=m || grid[i][j] != '1') {

            return;
        }
        grid[i][j] = '0';

           isIsland(grid, i+1, j, n, m);
            isIsland(grid, i-1, j, n, m);
            isIsland(grid, i, j+1, n, m);

            isIsland(grid, i, j-1, n, m);

    }
    public static int numIslands(char[][] grid) {
        int n=grid.length;
        int m= grid[0].length;

        if (n == 0) return 0;

        //boolean visited[][] =new boolean[n][m];

        int count=0;
        for (int ii = 0; ii < n; ii++) {
            for (int jj = 0; jj < m; jj++) {
                //visited[ii][jj] = false;
                System.out.print(grid[ii][jj] + "  ");
            }
            System.out.println();
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == '1' ){

                    isIsland(grid,i,j, n , m);
                        count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] a){
        char[][] grid = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
                };

        System.out.println(numIslands(grid));
    }


}
