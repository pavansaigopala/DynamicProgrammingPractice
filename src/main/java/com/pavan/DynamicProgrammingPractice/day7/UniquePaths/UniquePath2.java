package com.pavan.DynamicProgrammingPractice.day7.UniquePaths;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UniquePath2 {

	public static void main(String[] args) {
		
		List<List<Integer>> mat = new ArrayList<List<Integer>>();
		/*
		 * mat.add(Arrays.asList(0,-1,0,0,-1,0,0,0,0));
		 * mat.add(Arrays.asList(-1,0,0,0,0,-1,-1,0,0));
		 * mat.add(Arrays.asList(0,0,0,-1,-1,0,0,0,0));
		 * mat.add(Arrays.asList(1,0,-1,0,0,0,0,0,-1));
		 * mat.add(Arrays.asList(-1,0,0,0,0,0,-1,-1,0));
		 */
		
		mat.add(Arrays.asList(0,0,0,0,0,0,0,0,-1,0,-1,0));
		mat.add(Arrays.asList(0,0,-1,0,0,0,0,-1,-1,0,0,0));
		mat.add(Arrays.asList(0,-1,-1,0,0,-1,0,-1,0,0,0,-1));
		mat.add(Arrays.asList(-1,0,-1,0,0,-1,0,0,-1,0,-1,-1));
		mat.add(Arrays.asList(0,-1,0,0,0,0,0,0,-1,0,0,0));
		mat.add(Arrays.asList(-1,-1,0,0,0,0,-1,-1,-1,-1,0,0));
		mat.add(Arrays.asList(0,0,0,-1,-1,0,0,-1,0,0,0,0));
		mat.add(Arrays.asList(0,-1,-1,-1,0,0,0,-1,0,0,0,-1));
		mat.add(Arrays.asList(-1,0,0,-1,-1,-1,0,0,0,0,0,0));
		mat.add(Arrays.asList(0,0,-1,0,0,-1,-1,0,0,-1,-1,-1));
		mat.add(Arrays.asList(-1,0,0,-1,0,0,0,-1,0,0,0,0));
		mat.add(Arrays.asList(-1,0,0,0,0,-1,-1,0,-1,0,0,0));
		mat.add(Arrays.asList(0,0,0,-1,0,0,-1,0,0,0,0,0));
		mat.add(Arrays.asList(0,0,0,0,-1,0,0,0,0,0,0,0));
		//System.out.println(mat);
		int n=14, m=12;
		long[][] dp = new long[1][m+1];
		for (long[] row : dp) {
			Arrays.fill(row, 0);
		}
        long mod = 1000000007;
        //System.out.println((int)mazeObstacles(0,0,n,m,mat,dp,mod));
        
        //System.out.println((int)mazeObstaclesTabulation(n,m,mat,dp,mod));
        
        System.out.println((int)mazeObstaclesTabulationSpaceOptimization(n,m,mat,dp,mod));
    }

    public static long mazeObstacles(int i, int j, int n, int m,
      List<List<Integer>> mat, long[][] dp, long mod) {
        if (i >= n || j >=m) return 0;
        
        if(mat.get(i).get(j)==-1) return 0;
        else{
		    if (i==(n-1) && j==(m-1))return 1;
            if(dp[i][j]!=-1) return dp[i][j];
		    // Down
		    long rPath = (mazeObstacles(i + 1, j, n, m, mat,dp, mod))%mod;
		    // Right
		    long dPath = (mazeObstacles(i, j + 1, n, m,mat,dp,mod))%mod;

		    return dp[i][j]=(rPath + dPath)%mod;
        }
		
	}
    
    public static long mazeObstaclesTabulation(int n, int m,List<List<Integer>> mat, long[][] dp, long mod) {
    	       
    	for(int i=(n-1); i>=0; i--) {
    		for(int j=(m-1); j>=0; j--) {
    			if (i==(n-1) && j==(m-1)) {
			    	dp[i][j]=1;
			    	continue;
			    }
    			if(mat.get(i).get(j)==-1) {
    				dp[i][j]=0;
    				continue;
    			}
    			
    			// Down
			    long rPath = (dp[i+1][j])%mod;
			    // Right
			    long dPath = (dp[i][j+1])%mod;

			    dp[i][j]=(rPath + dPath)%mod;
    			
    		}
    	}
    	return dp[0][0];
    }
    
    public static long mazeObstaclesTabulationSpaceOptimization(int n, int m,List<List<Integer>> mat, long[][] dp, long mod) {
	       
    	for(int i=(n-1); i>=0; i--) {
    		long[][] temp = new long[1][m+1];
    		for(int j=(m-1); j>=0; j--) {
    			if (i==(n-1) && j==(m-1)) {
    				temp[0][j]=1;
			    	continue;
			    }
    			if(mat.get(i).get(j)==-1) {
    				temp[0][j]=0;
    				continue;
    			}
    			
    			// Down
			    long rPath = (dp[0][j])%mod;
			    // Right
			    long dPath = (temp[0][j+1])%mod;

			    temp[0][j]=(rPath + dPath)%mod;
    			
    		}
    		dp=temp;
    	}
    	return dp[0][0];
    }
}
