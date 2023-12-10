package com.pavan.DynamicProgrammingPractice.day6.TwoDArray;

import java.util.Arrays;

public class NinjaTraning {

	public static void main(String[] args) {
		//int[][] arr = {{1,2,5}, {3 ,1 ,1} ,{3,3,3}};
		int[][] arr = { { 10, 40, 70 }, { 20, 50, 80 }, { 30, 60, 90 } };
		//int[][] arr = { { 94, 74, 84 }, { 71, 4, 68 }, { 70, 12, 17 }, { 7, 84, 58 }, { 59, 69, 2 }, { 57, 21, 62 },
				//{ 74, 54, 15 }, { 15, 83, 49 }, { 97, 70, 90 }, { 8, 71, 42 } };
		/*
		 * int[][] dp = new int[arr.length + 1][arr[0].length + 1]; for (int[] row : dp)
		 * { Arrays.fill(row, -1); }
		 */
		int[] dp = new int[4];
		Arrays.fill(dp, -1);
		//int max = helperNinjaTrainingNtoO(arr, arr[0].length, arr.length-1, dp);
		int max = helperNinjaTrainingNtoOTabulation(arr, arr.length, dp);

		System.out.println(max);
	}


	public static int helperNinjaTrainingNtoO(int[][] arr, int previousIndex, int currentArrToChoose, int[][] dp) {

			if(currentArrToChoose<0) return 0;
			if(dp[currentArrToChoose][previousIndex]!=-1) return dp[currentArrToChoose][previousIndex];
			int maxMerit = 0;
			for (int i = arr[currentArrToChoose].length-1; i>=0; i--) {
				int currentSum = 0;
				if (i != previousIndex) {
					currentSum = arr[currentArrToChoose][i] 
					+ helperNinjaTrainingNtoO(arr, i, currentArrToChoose-1,dp);
					maxMerit = Math.max(maxMerit, currentSum);
				}
			}
			return dp[currentArrToChoose][previousIndex] = maxMerit;
	}
	
	
	public static int helperNinjaTrainingNtoOTabulation(int[][] arr, int n, int[] dp) {

		dp[0] = Math.max(arr[0][1], arr[0][2]);
		dp[1] = Math.max(arr[0][0], arr[0][2]);
		dp[2] = Math.max(arr[0][0], arr[0][1]);
		
		dp[3] = Math.max(dp[0], Math.max(dp[1], dp[2]));
		
		for(int day=1; day<arr.length; day++) {
			int[] current=new int[4];
			for(int last=0; last<=arr[day].length; last++) {
				for(int task=0; task<arr[day].length; task++) {
					if(task!=last) {
						current[last]= Math.max(current[last], arr[day][task]+dp[task]);
					}
				}
			}
			dp=current;
		}
		
		return dp[3];
}

	public static int helperNinjaTraining(int[][] arr, int omit, int arrNum, int[][] dp) {

		if (arrNum >= arr.length)
			return 0;

		int max = 0;
		for (int i = 0; i < arr[arrNum].length; i++) {
			int sum = 0;
			if (i != omit) {
				if (dp[arrNum][i] != -1)
					continue;
				sum = arr[arrNum][i] + helperNinjaTraining(arr, i, arrNum + 1, dp);
				max = Math.max(max, sum);
				System.out.println("arr[" + arrNum + "][" + i + "]=" + sum);
				dp[arrNum][i] = sum;
			}

		}
		System.out.println("----------------------" + max);
		return max;
	}
}
