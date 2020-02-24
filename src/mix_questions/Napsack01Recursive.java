package mix_questions;

public class Napsack01Recursive {

	public int solveKnapsack(int[] profits, int[] weights, int capacity) {
		return this.knapsackRecursive(profits, weights, capacity, 0);
	}

	private int knapsackRecursive(int[] profits, int[] weights, int capacity, int currentIndex) {
		if (capacity <= 0 || currentIndex >= profits.length)
			return 0;

		int profit1 = 0;
		if (weights[currentIndex] <= capacity) {
			System.out.println("currentIndex: "+currentIndex +" , profit1  before recursive call: " + profit1);
			profit1 = profits[currentIndex]
					+ knapsackRecursive(profits, weights, capacity - weights[currentIndex], currentIndex + 1);
			System.out.println("currentIndex: "+currentIndex +" , profit1  after recursive call: " + profit1);
		}

		int profit2 = 0;
		System.out.println("currentIndex: "+currentIndex+ ", profit2  before recursive call: " + profit2);
		profit2 = knapsackRecursive(profits, weights, capacity, currentIndex + 1);
		System.out.println("currentIndex: "+currentIndex + ", profit2 after recursive call: " + profit2);
		int max = Math.max(profit1, profit2);
		System.out.println("currentIndex: "+currentIndex + ", returning max profit: " + max);
		return max;
	}

	public static void main(String[] args) {
		Napsack01Recursive ks = new Napsack01Recursive();
		int[] profits = { 1, 6, 10, 16 };
		int[] weights = { 1, 2, 3, 5 };
		int maxProfit = ks.solveKnapsack(profits, weights, 7);
		System.out.println("Total knapsack profit ---> " + maxProfit);
		//maxProfit = ks.solveKnapsack(profits, weights, 6);
		//System.out.println("Total knapsack profit ---> " + maxProfit);
	}
}