package com.pavan.DynamicProgrammingPractice.day3.frogWithKJumps;

import java.util.Arrays;

public class FrogJumpWithKDistance {

	public static void main(String[] args) {
			int[] arr = { 20,40,100,50,70,10,30};
			int k=3;
			int[] dp= new int[arr.length];
			Arrays.fill(dp, 0);
			int minEng = helperBottomUpTabulation(arr,dp , k);
			System.out.println(minEng);
		}

	public static int helperBottomUp(int[] arr, int index, int k) {

		if (index <= 0)return 0;
		
		int minEnrgy = Integer.MAX_VALUE;
		for(int i=1; i<=k; i++) {
			if((index-i)>=0) {
				int current = Math.abs(arr[index] - arr[index - i]) + helperBottomUp(arr, index - i, k) ;
				minEnrgy =  Math.min(minEnrgy, current);
			}
		}
		System.out.println("index:"+index+"  minEnr:"+minEnrgy);
		return minEnrgy;
	}
	
	// memorization 
	public static int helperBottomUpMemo(int[] arr, int index, int k, int[] dp) {

		if (index <= 0)return 0;
		if(dp[index]!=-1) return dp[index];
		int minEnrgy = Integer.MAX_VALUE;
		for(int i=1; i<=k; i++) {
			if((index-i)>=0) {
				int current = Math.abs(arr[index] - arr[index - i]) + helperBottomUp(arr, index - i, k) ;
				minEnrgy =  Math.min(minEnrgy, current);
			}
		}
		System.out.println("index:"+index+"  minEnr:"+minEnrgy);
		return dp[index]=minEnrgy;
	}
	
	//Tabulation
		public static int helperBottomUpTabulation(int[] arr, int[] dp, int k) {

			for(int index=1;index<arr.length;index++) {
				int minEnrgy = Integer.MAX_VALUE;
				for(int i=1; i<=k; i++) {
					if((index-i)>=0) {
						int current = Math.abs(arr[index] - arr[index - i]) + dp[index - i] ;
						minEnrgy =  Math.min(minEnrgy, current);
					}
				}
				dp[index]=minEnrgy;
			}
			return dp[arr.length-1];
		}
		
		
		/*SpaceOptimization
		public static int helperBottomUpSpaceOptimization(int[] arr, ArrayList<Integer> dp, int k) {

			for(int index=1;index<arr.length;index++) {
				int minEnrgy = Integer.MAX_VALUE;
				for(int i=1; i<=k; i++) {
					if((index-i)>=0) {
						int current = Math.abs(arr[index] - arr[index - i]) + dp.get(index - i);
						minEnrgy =  Math.min(minEnrgy, current);
					}
				}
				dp.add(minEnrgy);
			}
			return dp[arr.length-1];
		}
		
		*/
}
