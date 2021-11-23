package leetcode;

import java.util.Arrays;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class NQueens {
     static final int nQueen = 4;

    static void printSolution(int grid[][])
    {
        for (int i = 0; i < nQueen; i++) {
            for (int j = 0; j < nQueen; j++)
                System.out.print(" " + grid[i][j]
                        + " ");
            System.out.println();
        }
    }

     static boolean isSafeToPlaceQueen(int[][] grid, int row, int col){

         for(int i=0;i<col;i++){
             if(grid[row][i]==1)
                 return false;
         }

         for(int i=row, j=col; i>=0 && j>=0; i--, j--){
             if(grid[i][j]==1)
                 return false;
         }

         for(int i=row, j=col; i<nQueen && j>=0; i++, j--){
             if(grid[i][j]==1)
                 return false;
         }

         return true;
     }

     public static boolean placeNQueen(int [][] grid, int col){
         if(col >= nQueen)
             return true;

         for(int i=0;i<nQueen;i++){
             if(isSafeToPlaceQueen(grid, i, col)){
                    grid[i][col]=1;
                 if (placeNQueen(grid, col + 1) == true)
                     return true;

                 grid[i][col]=0;
             }
         }
         return false;
     }

     public static void main(String[] a){
         String[] y = {"1", "2", "15", "-7"};
         Arrays.sort(y);
         System.out.println(y[0] + "   " + y[1]);

         int grid[][] = { { 0, 0, 0, 0 },
                 { 0, 0, 0, 0 },
                 { 0, 0, 0, 0 },
                 { 0, 0, 0, 0 } };
         if (placeNQueen(grid, 0) == false) {
             System.out.print("Solution does not exist");
             return;
         }

         printSolution(grid);
     }




}

 