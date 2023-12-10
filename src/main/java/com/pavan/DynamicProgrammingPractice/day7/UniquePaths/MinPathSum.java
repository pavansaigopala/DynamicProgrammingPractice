package com.pavan.DynamicProgrammingPractice.day7.UniquePaths;

import java.util.Arrays;

public class MinPathSum {

	public static void main(String[] args) {
		int[][] grid = { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };
		int minPath = minPathSum(grid);
		System.out.println(minPath);
	}

	public static int minPathSum(int[][] grid) {
		int[] dp = new int[grid[0].length + 1];
			Arrays.fill(dp, 10000);
		return minPathSumHelperTabulationSpaceOpt(grid, grid.length, grid[0].length, dp);
	}

	public static int minPathSumHelper(int[][] grid, int row, int col, int n, int m, int[][] dp) {

		if (row >= n || col >= m)
			return 10000;

		if (row == (n - 1) && col == (m - 1))
			return grid[row][col];

		if (dp[row][col] != -1)
			return dp[row][col];

		// down
		int down = grid[row][col] + minPathSumHelper(grid, row + 1, col, n, m, dp);
		// right
		int right = grid[row][col] + minPathSumHelper(grid, row, col + 1, n, m, dp);

		return dp[row][col] = Math.min(down, right);

	}

	public static int minPathSumHelperTabulation(int[][] grid, int n, int m, int[][] dp) {

		for (int row = (n - 1); row >= 0; row--) {

			for (int col = (m - 1); col >= 0; col--) {

				if (row == (n - 1) && col == (m - 1)) {
					dp[row][col] = grid[row][col];
					continue;
				}
				// down
				int down = grid[row][col] + dp[row + 1][col];
				// right
				int right = grid[row][col] + dp[row][col + 1];

				dp[row][col] = Math.min(down, right);
			}
		}
		return dp[0][0];
	}

	public static int minPathSumHelperTabulationSpaceOpt(int[][] grid, int n, int m, int[] dp) {

		for (int row = (n - 1); row >= 0; row--) {
			int[] currentRow = new int[m + 1];
			currentRow[m] = 10000;
			for (int col = (m - 1); col >= 0; col--) {

				if (row == (n - 1) && col == (m - 1)) {
					currentRow[col] = grid[row][col];
					continue;
				}
				// down
				int down = grid[row][col] + dp[col];
				// right
				int right = grid[row][col] + currentRow[col + 1];

				currentRow[col] = Math.min(down, right);
			}
			dp = currentRow;
		}
		return dp[0];
	}
}
