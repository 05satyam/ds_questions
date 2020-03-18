/**
 * question
 * 
 *AMEO birthday today and he has ordered his favourite square cake consisting of '0's and '1's . But AMEO wants the biggest piece of '1's and no '0's . A piece of cake is defined as a part which consist of only '1's, and all '1's share an edge with eachother on the cake. Given the size of cake N and the cake , can you find the size of the biggest piece of '1's for AMEO ?
 * 
 * 
 * 
 * **/

package mix_questions;

import java.util.Arrays;
import java.util.Scanner;

public class LargestCakePieceCount {

	public int ROW, COL;
	public int len = 0;
	static int rowNbr[] = { -1, 1, 0, 0 };
	static int colNbr[] = { 0, 0, 1, -1 };

	private int countPieceCake(int arr[][]) {
		int count = 0;
		boolean visited[][] = new boolean[ROW][COL];
		Arrays.fill(visited, false);
		for (int i = 0; i < ROW; i++)
			for (int j = 0; j < COL; j++) {
				if (isPossibleMove(i, j, visited, arr)) {
					visited[i][j] = true;
					recurseCalc(i, j, visited, arr);
					count = count > len ? count : len;
					len = 0;
				}
			}
		return count;

	}

	private void recurseCalc(int i, int j, boolean visited[][], int arr[][]) {

		for (int ii = 0; ii < 4; ii++) {
			if (isPossibleMove(i + rowNbr[ii], j + colNbr[ii], visited, arr)) {
				len++;
				recurseCalc(i + rowNbr[ii], j + colNbr[ii], visited, arr);
			}

		}
	}

	private boolean isPossibleMove(int i, int j, boolean visited[][], int[][] arr) {
		if (i < 0 || i >= ROW || j < 0 || j >= COL || visited[i][j] || arr[i][j] == '0') {
			return false;
		} else
			return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LargestCakePieceCount lpc = new LargestCakePieceCount();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[][] = new int[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				arr[i][j] = sc.nextInt();
		lpc.ROW = n;
		lpc.COL = n;
		System.out.println(lpc.countPieceCake(arr) - 1);

	}

}
