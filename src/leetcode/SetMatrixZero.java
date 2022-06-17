/**
 * Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
 *
 * You must do it in place.
 */
package leetcode;

public class SetMatrixZero {
    public void setZeroes(int[][] matrix) {
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                if(matrix[i][j]==Integer.MAX_VALUE)
                    continue;
                //System.out.println("1.  i j "+ i + j);
                if(matrix[i][j]==0){

                    for(int k=0;k<matrix[i].length;k++){
                        if(matrix[i][k]!=0 ){
                            System.out.println("1.  i K "+ i + k);
                            matrix[i][k]=((-1)*Integer.MAX_VALUE);
                        }

                    }

                    for(int k=i;k>=0;k--){
                        if(matrix[k][j]!=0){
                            System.out.println("2.  k j "+ k + j);
                            matrix[k][j]=((-1)*Integer.MAX_VALUE);}
                    }

                    for(int k=i;k<matrix.length;k++){
                        if(matrix[k][j]!=0){
                            System.out.println("3.  k j "+ k + j);
                            matrix[k][j]=((-1)*Integer.MAX_VALUE);}
                    }
                }


            }
        }

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++)
                if(matrix[i][j]==((-1)*Integer.MAX_VALUE))
                    matrix[i][j]=0;
        }
    }

}
