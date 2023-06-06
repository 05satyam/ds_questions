/**
 *
 * You are given row x col grid representing a map where grid[i][j] = 1 represents land and grid[i][j] = 0 represents water.
 *
 * Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).
 *
 * The island doesn't have "lakes", meaning the water inside isn't connected to the water around the island. One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.
 *
 *
 *
 * Example 1:
 *
 * Input: grid = [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]
 * Output: 16
 * Explanation: The perimeter is the 16 yellow stripes in the image above.
 *
 *
 *
 */
package leetcode;

public class IslandParameter {

    public int islandPerimeter(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        int res=0, connectedCnt = 0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                connectedCnt=0;
                if(grid[i][j]==0)
                    continue;

                if((i>=0 && i+1<row )&& (j>=0 && j<col)){
                    if(grid[i+1][j]==1)
                        connectedCnt+=1;
                }

                if((i-1>=0 && i<row )&& (j>=0 && j<col)){
                    if(grid[i-1][j]==1)
                        connectedCnt+=1;
                }

                if((i>=0 && i<row )&& (j-1>=0 && j<col)){
                    if(grid[i][j-1]==1)
                        connectedCnt+=1;
                }


                if((i>=0 && i<row )&& (j>=0 && j+1<col)){
                    if(grid[i][j+1]==1)
                        connectedCnt+=1;
                }


                res += 4-connectedCnt;
            }
        }

        return res;
    }
}
