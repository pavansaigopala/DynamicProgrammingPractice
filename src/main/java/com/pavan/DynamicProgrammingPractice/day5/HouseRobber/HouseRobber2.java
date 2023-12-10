package com.pavan.DynamicProgrammingPractice.day5.HouseRobber;

import java.util.Arrays;

public class HouseRobber2 {

	public static void main(String[] args) {
		int[] arr = {114,117,207,117,235,82,90,67,143,146,53,108,200,91,80,223,58,170,110,236,81,90,222,160,165,195,187,199,114,235,197,187,69,129,64,214,228,78,188,67,205,94,205,169,241,202,144,240};
		int[][] dp = new int[arr.length][2];
	    for(int[] row: dp){
	        Arrays.fill(row, -1);
	    }
			
	        int[] validate =new int[arr.length];
			int minEng = helperNonAdjSum(arr, arr.length - 1, dp,validate);
			
			System.out.println(minEng);
		}

		private static int helperNonAdjSum(int[] arr, int n, int[][] dp, int[] validate) {
	        
			if (n < 0)return 0;

	        if(dp[n][validate[arr.length-1]] != -1) return dp[n][validate[arr.length-1]];
			if(validate[arr.length-1]==1 && n==0) return 0;
			
			if (n == 0) return arr[0];

	        
			
	        validate[n]=1;
			int pick = arr[n] + helperNonAdjSum(arr, n - 2, dp,validate);

	        validate[n]=0;
			int notPick = 0 + helperNonAdjSum(arr, n - 1, dp, validate);
		    
	        dp[n][validate[arr.length-1]] = Math.max(pick, notPick);
	        //System.out.println(n+": "+dp[n]);
			return dp[n][validate[arr.length-1]];
		}
	}
