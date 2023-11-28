package com.pavan.DynamicProgrammingPractice.day4.NonAdjucentSum;

import java.util.Arrays;

public class MaxSumOfNonAdjucentElement {

	public static void main(String[] args) {
		int[] arr = { 3,4,2,11,9};
		int[] dp = new int[arr.length];
		Arrays.fill(dp, -1);
		//int minEng = helperNonAdjSum(arr, arr.length - 1, dp);
		//int minEng = helperNonAdjSumTabulation(arr,dp);
		int minEng = helperNonAdjSumSpaceOpt(arr);
		System.out.println(minEng);
	}

	private static int helperNonAdjSum(int[] arr, int n, int[] dp) {

		if (n < 0)
			return 0;
		if (n == 0)
			return arr[0];

		int pick = arr[n] + helperNonAdjSum(arr, n - 2, dp);

		int notPick = 0 + helperNonAdjSum(arr, n - 1, dp);

		return dp[n] = Math.max(pick, notPick);
	}

	private static int helperNonAdjSumTabulation(int[] arr, int[] dp) {

		dp[0]=arr[0];
		
		for(int i=1; i<arr.length;i++) {
			
			int pick = arr[i];
			if(i>1) pick += dp[i - 2];

			int notPick = 0 + dp[i - 1];
			
			dp[i] = Math.max(pick, notPick);
		}
		
		return dp[arr.length-1];
	}

	private static int helperNonAdjSumSpaceOpt(int[] arr) {

		int prev = arr[0];
		int prev2 = 0;
		for(int i=1; i<arr.length;i++) {
			
			int pick = arr[i];
			if(i>1) pick += prev2;

			int notPick = 0 + prev;
			
			int current = Math.max(pick, notPick);
			
			prev2 = prev;
			prev = current;
		}
		
		return prev;
	}
}
