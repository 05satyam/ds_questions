/**
 * You are given an m x n grid where each cell can have one of three values:
 *
 * 0 representing an empty cell,
 * 1 representing a fresh orange, or
 * 2 representing a rotten orange.
 * Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
 *
 * Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.
 *
 *
 */
package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class MinTimeToMakeAllAppleRotten {
    int count=0;
    public boolean issafe(int i,int j, int n, int m) {

        if (i >= 0 && i < n && j >= 0 && j < m)
            return true;

        return false;
    }

    public int orangesRotting(int[][] v) {
        boolean changed = false;
        int no = 2;
        int R=v.length;
        int C = v[0].length;
        while (true) {
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {

                    // Rot all other oranges present at
                    // (i+1, j), (i, j-1), (i, j+1), (i-1,
                    // j)
                    if (v[i][j] == no) {
                        if (issafe(i + 1, j, R,C)
                                && v[i + 1][j] == 1) {
                            v[i + 1][j] = v[i][j] + 1;
                            changed = true;
                        }
                        if (issafe(i, j + 1, R,C)
                                && v[i][j + 1] == 1) {
                            v[i][j + 1] = v[i][j] + 1;
                            changed = true;
                        }
                        if (issafe(i - 1, j, R,C)
                                && v[i - 1][j] == 1) {
                            v[i - 1][j] = v[i][j] + 1;
                            changed = true;
                        }
                        if (issafe(i, j - 1, R,C )
                                && v[i][j - 1] == 1) {
                            v[i][j - 1] = v[i][j] + 1;
                            changed = true;
                        }
                    }
                }
            }

            // If no rotten orange found it means all
            // oranges rottened now
            if (!changed)
                break;

            changed = false;
            no++;
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {

                // If any orange is found to be
                // not rotten then ans is not possible
                if (v[i][j] == 1)
                    return -1;
            }
        }

        // Because initial value for a rotten
        // orange was 2
        return no - 2;
    }

//    public static void main(String[] a){
//        int[][] arr={{2,0,1,1,1,1,1,1,1,1},{1,0,1,0,0,0,0,0,0,1},{1,0,1,0,1,1,1,1,0,1},{1,0,1,0,1,0,0,1,0,1},{1,0,1,0,1,0,0,1,0,1},{1,0,1,0,1,1,0,1,0,1},{1,0,1,0,0,0,0,1,0,1},{1,0,1,1,1,1,1,1,0,1},{1,0,0,0,0,0,0,0,0,1},{1,1,1,1,1,1,1,1,1,1}
//        };
//        System.out.println(orangesRotting(arr));
//
//    }
}

//{{2,0,1,1,1,1,1,1,1,1},{1,0,1,0,0,0,0,0,0,1},{1,0,1,0,1,1,1,1,0,1},{1,0,1,0,1,0,0,1,0,1},{1,0,1,0,1,0,0,1,0,1},{1,0,1,0,1,1,0,1,0,1},{1,0,1,0,0,0,0,1,0,1},{1,0,1,1,1,1,1,1,0,1},{1,0,0,0,0,0,0,0,0,1},{1,1,1,1,1,1,1,1,1,1}
//}