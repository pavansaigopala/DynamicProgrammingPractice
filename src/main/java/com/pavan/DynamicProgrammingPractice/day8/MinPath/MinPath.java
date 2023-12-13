package com.pavan.DynamicProgrammingPractice.day8.MinPath;

import java.util.* ;
public class MinPath {
	
	public static void main(String[] args) {
		int[][] triangle = {{1},{2,3},{3,6,7},{8,9,6,10}};
		minimumPathSum(triangle,triangle.length);
	}
    public static int minimumPathSum(int[][] triangle, int n) {
        int[][] dp = new int[1][triangle[n-1].length];
		for (int[] row : dp) {
			Arrays.fill(row, Integer.MAX_VALUE);
		}
        int minPath = minimumPathSumHelperTabulation(triangle, n,dp);
        return minPath;
    }

    public static int minimumPathSumHelper(int[][] triangle, int n, int row, int col, int[][] dp){
        if(row==(n-1)){
            return triangle[row][col];
        }
        if(dp[row][col]!=-1)return dp[row][col];
        //Down
        int downVal = triangle[row][col] + minimumPathSumHelper(triangle, n, row+1, col, dp);

        //Diagonal
        int rightVal = triangle[row][col] + minimumPathSumHelper(triangle, n, row+1, col+1, dp);
            
        
        return dp[row][col] = Math.min(downVal, rightVal);
        
    }

    public static int minimumPathSumHelperTabulation(int[][] triangle, int n,int[][] dp){
        dp[0][0]=triangle[0][0];

        for(int row=1; row<n; row++){
            int[][] temp = new int[1][triangle[n-1].length];
            for(int col=0; col<triangle[row].length;col++){
                //Down
                 int downVal=Integer.MAX_VALUE;
                if(col<triangle[row-1].length){
                    downVal = triangle[row][col] + dp[0][col];
                }
                

                //Diagonal
                int rightVal=Integer.MAX_VALUE;
                if(col>0){
                    rightVal = triangle[row][col] + dp[0][col-1];
                }
               temp[0][col] = Math.min(downVal, rightVal);
               //System.out.println("row:"+ row+"col:"+ col);
            }
            dp=temp;
        }
        int min=Integer.MAX_VALUE;
        for(int col=0; col<triangle[n-1].length;col++){
             min= Math.min(min, dp[0][col]);
        }  
        
        return min;
        
    }
}