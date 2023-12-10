package com.pavan.DynamicProgrammingPractice.day7.UniquePaths;

import java.util.Arrays;

public class UniquePaths {

	public static void main(String[] args) {

		int[][] dp = new int[1][14];
		for (int[] row : dp) {
			Arrays.fill(row, 0);
		}

		// int uniquePath = uniquePath(0, 0, 3, 3);
		//int uniquePath = uniquePathTabulation(19, 13, dp);
		int uniquePath = uniquePathTabulationSpaceOptimization(19, 13, dp);
		System.out.println(uniquePath);
	}

	public static int uniquePath(int i, int j, int n, int m) {

		if (i >= n || j >= m)
			return 0;

		if (i == (n - 1) && j == (m - 1))
			return 1;

		// Right
		int rPath = uniquePath(i + 1, j, n, m);
		// Down
		int dPath = uniquePath(i, j + 1, n, m);

		return rPath + dPath;
	}

	public static int uniquePathDp(int i, int j, int m, int n, int[][] dp) {

		if (i >= m || j >= n)
			return 0;

		if (i == (m - 1) && j == (n - 1))
			return 1;

		if (dp[i][j] != -1)
			return dp[i][j];
		// Right
		int rPath = uniquePathDp(i + 1, j, m, n, dp);
		// Down
		int dPath = uniquePathDp(i, j + 1, m, n, dp);

		return dp[i][j] = rPath + dPath;
	}

	public static int uniquePathTabulation(int m, int n, int[][] dp) {

		for (int i = (m - 1); i >= 0; i--) {

			for (int j = (n - 1); j >= 0; j--) {

				if (i == (m - 1) && j == (n - 1)) {
					dp[i][j] = 1;
					continue;
				}
				// Right
				int rPath = dp[i + 1][j];
				// Down
				int dPath = dp[i][j + 1];

				dp[i][j] = rPath + dPath;
			}
		}
		return dp[0][0];
	}

	public static int uniquePathTabulationSpaceOptimization(int m, int n, int[][] dp) {

		for (int i = (m - 1); i >= 0; i--) {

			int[][] tempArr = new int[1][n + 1];

			for (int j = (n - 1); j >= 0; j--) {

				if (i == (m - 1) && j == (n - 1)) {
					tempArr[0][j] = 1;
					continue;
				}
				// Down
				int rPath = dp[0][j];
				// Right
				int dPath = tempArr[0][j + 1];

				tempArr[0][j] = rPath + dPath;
			}
			dp = tempArr;
		}
		return dp[0][0];
	}

}
