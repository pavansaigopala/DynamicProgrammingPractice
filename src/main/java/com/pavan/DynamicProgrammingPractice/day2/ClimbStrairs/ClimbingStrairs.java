package com.pavan.DynamicProgrammingPractice.day2.ClimbStrairs;

import java.util.Arrays;

public class ClimbingStrairs {

	public static void main(String[] args) {
		// no.of ways you can climb stairs,
		// 1) single step
		// 2) two steps at a time

		
		int[] dp = new int[5];
		dp[4]=1;
		dp[3]=1;
		int noOfWays = helperTabulationWithoutDP(6);
		System.out.println(noOfWays);

	}

	public static int helper(int n, int i) {

		int count = 0;
		if (i >= (n - 1))
			return 1;

		count += helper(n, i + 1);
		count += helper(n, i + 2);

		return count;
	}

	public static int helperWithMemo(int n, int i, int[] dp) {

		if(dp[i] !=-1) return dp[i];
		
		int count = 0;
		if (i >= (n - 1))
			return 1;
		

		count += helper(n, i + 1);
		count += helper(n, i + 2);

		return dp[i]=count;
	}
	
	
	public static int helperWithTabulation(int[] dp) {

		for(int i=dp.length-3; i>=0 ; i--) {
			dp[i] = dp[i+1]+dp[i+2];
		}
		return dp[0];
	}
	
	public static int helperTabulationWithoutDP(int n) {

		int prev=1, prev2=1;
		for(int i=n-2; i>=0 ; i--) {
			int current = prev+prev2;
			prev2=prev;
			prev=current;
		}
		return prev;
	}

}
