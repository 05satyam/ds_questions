/**
 *
 * Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.
 *
 * Input: n = 3
 * Output: [[1,2,3],[8,9,4],[7,6,5]]
 * Example 2:
 *
 * Input: n = 1
 * Output: [[1]]
 */
package leetcode;

public class CreateSpiralMatrix {

    public int[][] generateMatrix(int n1) {
        int i, k = 0, l = 0;
        int n= n1;
        int m  = n;
        int[][] arr = new int[n][n];

        int num=1;
        while (k < m && l < n) {
            // Print the first row from the remaining rows
            for (i = l; i < n; ++i) {

                arr[k][i]=num;
                num++;
            }
            k++;

            // Print the last column from the remaining
            // columns
            for (i = k; i < m; ++i) {

                arr[i][n-1]= num;
                num++;
            }
            n--;

            // Print the last row from the remaining rows */
            if (k < m) {
                for (i = n - 1; i >= l; --i) {

                    arr[m-1][i]=num;
                    num++;
                }
                m--;
            }

            // Print the first column from the remaining
            // columns */
            if (l < n) {
                for (i = m - 1; i >= k; --i) {

                    arr[i][l]=num;
                    num++;
                }
                l++;
            }
        }

        return  arr;
    }


}
