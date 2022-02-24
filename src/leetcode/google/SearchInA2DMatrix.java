/*
* Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.

*
* Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true
*
* */
package leetcode.google;

public class SearchInA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i=0;
        for( i=0;i<matrix.length;i++){
            if(matrix[i][0]<=target && matrix[i][matrix[i].length-1]>=target){
                //i++;
                break;
            }

            if(matrix[i][0]>target )
                return false;
        }

        if(i>matrix.length-1)
            return false;
        System.out.println(i);
        for(int k=0;k<matrix[0].length;k++){
            if(matrix[i][k]==target)
                return true;
        }
        return false;
    }
}
