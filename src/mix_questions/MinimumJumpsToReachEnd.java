package mix_questions;

public class MinimumJumpsToReachEnd {

	// recursion
	public static int minimumJumps(int[] jump, int currentIdx) {
		if (currentIdx == jump.length - 1)
			return 0;

		if (jump[currentIdx] == 0)
			return Integer.MAX_VALUE;
		int totalJump = Integer.MAX_VALUE;
		int start = currentIdx + 1;
		int end = jump[currentIdx] + currentIdx;
		while (start < jump.length && start <= end) {
			int minJump = minimumJumps(jump, start++);
			if (minJump != Integer.MAX_VALUE) {
				totalJump = Math.min(totalJump, minJump);
			}
		}
		return totalJump;
	}

	// top-down
	public static int minimumJumps(int dp[], int[] jump, int currentIdx) {
		if (currentIdx == jump.length - 1)
			return 0;
		if (jump[currentIdx] == 0)
			return Integer.MAX_VALUE;

		if (dp[currentIdx] != 0)
			return dp[currentIdx];

		int totalJump = Integer.MAX_VALUE;
		int start = currentIdx + 1;
		int end = jump[currentIdx] + currentIdx;
		while (start < jump.length && start <= end) {
			int minJump = minimumJumps(jump, start++);
			if (minJump != Integer.MAX_VALUE) {
				totalJump = Math.min(totalJump, minJump);
			}
		}
		dp[currentIdx] = totalJump;
		return dp[currentIdx];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] jumps = { 1, 2, 3, 4, 5 };
		System.out.println("recursion: " + minimumJumps(jumps, 0));

		int[] jumpss = new int[] { 1, 2, 3, 6, 0, 8, 7 };
		int dp[] = new int[jumpss.length];
		System.out.println("top-down: " + minimumJumps(dp, jumps, 0));
	}

}
