package leetcode;

public class SetMatrixZero {
    public void setZeroes(int[][] matrix) {
            for(int i=0;i<matrix.length;i++){
                for(int j=0;j<matrix.length;j++){
                    if(matrix[i][j]==-1)
                        continue;

                    if(matrix[i][j]==0){
                        for(int k=0;k<matrix[i].length;k++){
                            matrix[i][k]=-1;
                        }

                        for(int k=i;k>=0;k--){
                            matrix[k][j]=-1;
                        }

                        for(int k=i;k<matrix.length;k++){
                            matrix[k][j]=-1;
                        }
                    }
                }
            }

            for(int i=0;i<matrix.length;i++){
                for(int j=0;j<matrix[i].length;j++)
                    if(matrix[i][j]==-1)
                        matrix[i][j]=0;
            }

    }

}
