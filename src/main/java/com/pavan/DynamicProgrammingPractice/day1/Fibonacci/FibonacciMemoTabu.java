package com.pavan.DynamicProgrammingPractice.day1.Fibonacci;

import java.util.Arrays;

public class FibonacciMemoTabu {
	
	// Practicing Memorization and Tabulation Technique
	public static void main(String[] args) {
		int n=9;
		int[] dp = new int[n+1];
		Arrays.fill(dp, -1);
		int value = fiboTabu(n);
		System.out.println(value);
	}
	
	//Recursive Approach
	// TC: O(n^2)
	// SC: O(n)
	public static int fibo(int n) {
		if(n<=1) return n;
		return fibo(n-1)+fibo(n-2);  // i =  (i-1) + (i-2);
	}
	
	// DP || Memorization Approach
	// TC: O(n)
	// SC: O(n) - stack space + O(n)-array space
	public static int fiboMemo(int n, int[] dp) {
		if(n<=1) return n;
		
		if(dp[n]!=-1) return dp[n];
		
		return dp[n] = fiboMemo(n-1, dp)+fiboMemo(n-2, dp);  // i =  (i-1) + (i-2);
	}
	
	// DP || Tabulation Approach
	// TC: O(n)
	// SC: O(1)
		public static int fiboTabu(int n) {
			
			int prev = 1, prev2 = 0;
			
			for(int i=2; i<=n; i++) {
				int current = prev + prev2;
				prev2 = prev;
				prev = current;
			}
			
			return prev;
		}
}
