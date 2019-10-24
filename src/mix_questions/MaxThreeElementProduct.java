/**
 * USING PRIORITY QUEUE----MAX HEAP
 * 
 * question:
 * 
 * 
 * 
 * Gary learned about priority queues recently and asked his teacher for an interesting problem. So his teacher came up with a simple problem. He now has an integer array A. For each index i, he wants to find the product of the largest, second largest and the third largest integer in the range [1,i].
	Note: Two numbers can be the same value-wise but they should be distinct index-wise.
	Input Format :
		Line 1 : Integer N, denoting the number of elements in the array A.
		Line 2 : N space separated integers, each denoting the ith integer of the array A.
	Output Format :
		Print the answer for each index in each line. If there is no second largest or third largest number in the array A upto that index, then print "-1", without the quotes.
	Constraints:
	1 <= N <= 100000
	0 <= A[i] <= 1000000
 * 
 * 
 * 
 * SAMPLE:
 * 
 * 
 *  7
	580386 433232 43193 917170 219977 349897 701880 
 * 
 * **/





package mix_questions;

import java.util.*;

public class MaxThreeElementProduct {

	public static void solve(int n, int[] input) {
		PriorityQueue<Long> pQ = new PriorityQueue<Long>(Collections.reverseOrder());
		long l1 = 0, l2 = 0, l3 = 0;
		if (n > 2) {
			l1 = input[0];
			l2 = input[1];
			l3 = input[2];
			pQ.add(l1);
			pQ.add(l2);
			pQ.add(l3);

		}
		// System.out.println((l1 * l2 * l3));
		for (int i = 0; i < n; i++) {
			if (i < 2) {
				System.out.println(("-1"));
			} else if (i == 2) {
				System.out.println((l1 * l2 * l3));
			} else {
				long x = input[i];
				pQ.add(x);
				l1 = pQ.remove();
				l2 = pQ.remove();
				l3 = pQ.remove();
				System.out.println((l1 * l2 * l3));
				pQ.add(l1);
				pQ.add(l2);
				pQ.add(l3);

			}
		}

	}

	public static void main(String[] args) {

		int[] input = new int[] { 1, 1 };
		solve(2, input);
	}

}
