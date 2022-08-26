package app.dp;

import java.util.Arrays;

public class Knapsack {
	public static void knapsack() {
		int w = 10;
		int n = 4;
		int[] wt = { 1, 3, 4, 6 };
		int[] val = { 20, 30, 10, 50 };
		int[][] output = new int[n + 1][w + 1];

		for (int i = 0; i < n + 1; i++) {
			output[i][0] = 0;
		}

		for (int i = 0; i < w + 1; i++) {
			output[0][i] = 0;
		}

		for (int row = 1; row < n + 1; row++) {
			for (int col = 1; col < w + 1; col++) {
				int previousHigh = output[row - 1][col];
				int newHigh = 0;

				if (wt[row - 1] <= col) {
					newHigh = val[row - 1];
					int remainingCapacity = col - wt[row - 1];
					newHigh += output[row - 1][remainingCapacity];
				}
				output[row][col] = Math.max(previousHigh, newHigh);
			}
		}
		System.out.println(output[n][w]);
		System.out.println(Arrays.deepToString(output));
	}

}
