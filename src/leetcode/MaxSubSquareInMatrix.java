/*
* Maximal square
* Given an m x n binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
*
* Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
Output: 4
* */
package leetcode;

public class MaxSubSquareInMatrix {
    public static int maximalSquare(char[][] matrix) {
        int dp[][] = new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix[0].length;i++){
            dp[0][i]= matrix[0][i]=='1'? 1:0;
        }
        for(int i=0;i<matrix.length;i++){
            dp[i][0]= matrix[i][0]=='1'? 1:0;
        }

        for(int i=1;i<matrix.length;i++){
            for(int j=1;j<matrix[i].length;j++){
                if(matrix[i][j]=='1'){
                    dp[i][j] = Math.min(Math.min(dp[i-1][j-1], dp[i-1][j]), dp[i][j-1])+1;
                }else{
                    dp[i][j]=0;
                }
            }
        }

        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[i].length;j++){
                System.out.print(dp[i][j] + "  ");
            }
            System.out.println();
        }



        int maxNum = 0;
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[i].length;j++){
                maxNum = maxNum<dp[i][j]? dp[i][j]:maxNum;
            }
        }
        System.out.println("maxNum "+ maxNum);
        return (maxNum*maxNum);
    }

    public static void main(String[] a){
        char matrix[][] = {{'0','1'}};
        System.out.println(maximalSquare(matrix));
    }
}
