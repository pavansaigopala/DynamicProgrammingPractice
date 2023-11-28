package com.pavan.DynamicProgrammingPractice.day2.ClimbStrairs;

import java.util.Arrays;

public class FrogJump {

	public static void main(String[] args) {

		int[] arr = { 30, 10, 60, 10, 60, 50};
		//int minEng = helper(arr, 0, 0, arr.length - 1);
		int[] dp = new int[arr.length];
		Arrays.fill(dp,0);
		int minEng = helperSpaceOptimization(arr);
		System.out.println(minEng);
	}

	public static int helper(int[] arr, int index) {

		if (index >= arr.length-1)
			return 0;

		int left = helper(arr, index + 1) + Math.abs(arr[index] - arr[index + 1]);

		int right = Integer.MAX_VALUE;
		if (index < (arr.length-2)) {
			right = helper(arr, index + 2)+ Math.abs(arr[index] - arr[index + 2]);
		}

		return Math.min(left, right);
	}

	public static int helperBottomUp(int[] arr, int index) {

		if (index == 0)return 0;

		int left = Math.abs(arr[index] - arr[index - 1]) + helperBottomUp(arr, index - 1) ;

		int right = Integer.MAX_VALUE;
		if (index > 1) {
			right = Math.abs(arr[index] - arr[index-2]) + helperBottomUp(arr, index - 2) ;
		}

		return Math.min(left, right);
	}
	
	
	// memorization
	public static int helperMemo(int[] arr, int index, int[] dp) {

		if (index >= arr.length-1)
			return 0;
		
		if(dp[index]!=-1) return dp[index];

		int left = helperMemo(arr, index + 1, dp) + Math.abs(arr[index] - arr[index + 1]);

		int right = Integer.MAX_VALUE;
		if (index < (arr.length-2)) {
			right = helperMemo(arr, index + 2, dp)+ Math.abs(arr[index] - arr[index + 2]);
		}

		return dp[index] = Math.min(left, right);
	}
	
	//Tabulation
	public static int helperTabulation(int[] arr, int[] dp) {

		for(int index=1;index<arr.length;index++) {
			
		

		int left =  dp[index-1] + Math.abs(arr[index] - arr[index - 1]);

		int right = Integer.MAX_VALUE;
		if (index >1) {
			right = dp[index-2]+ Math.abs(arr[index] - arr[index - 2]);
		}

		dp[index] = Math.min(left, right);
		
		}
		return dp[arr.length-1];
	}
	
	public static int helperSpaceOptimization(int[] arr) {

		int prev=0, prev2=0;
		for(int index=1;index<arr.length;index++) {
			
		int left =  prev + Math.abs(arr[index] - arr[index - 1]);

		int right = Integer.MAX_VALUE;
		if (index >1) {
			right = prev2+ Math.abs(arr[index] - arr[index - 2]);
		}

		int current = Math.min(left, right);
		prev2 = prev; 
		prev = current;
		
		}
		return prev;
	}
	
	
}
