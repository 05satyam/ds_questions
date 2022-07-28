/*
Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.


Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true



 */
package leetcode;

public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {

        int row = matrix.length;
        int column = matrix[0].length;
        int rownNo=-1;
            for(int i=0;i<row;i++){
                if(matrix[i][0]<=target && matrix[i][column-1]>=target){
                    rownNo = i;
                    break;

                }
            }

            if(rownNo!=-1){
                for(int i=0;i<column;i++){
                    if(matrix[rownNo][i]==target)
                        return true;
                }
            }
            return false;
    }


}
