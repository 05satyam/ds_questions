/**
 * Question:
 * 
 * given a string containing only ‘R’s and ‘O’s (uppercase). Count the total number of subsequences forming “ROR” in the given string. You need to return the count of subsequences possible.
 * */

package mix_questions;

public class CountRORSubsequence {
	public static long solve(String s) {

		int n = s.length();
		long cntG = 0, cntF = 0;
		long result = 0;
		long C = 0;

		for (int i = 0; i < n; i++) {
			switch (s.charAt(i)) {
			case 'R':
				cntG++;
				result += C;
				break;
			case 'O':
				cntF++;
				C += cntG;
				break;
			default:
				continue;
			}
		}

		return (result);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solve("ROR");
	}

}
