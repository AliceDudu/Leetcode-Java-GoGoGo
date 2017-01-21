public class Solution{
	public int uniquePathsWithObstacles(int[][] matrix){
		//corner
		
		//core
		int m = matrix.length;
		int n = matrix[0].length;
		
		int[][] dp = new int[m][n];
		
		if ( matrix[0][0] == 1 ){
			dp[0][0] = 0;
		}else{
			dp[0][0] = 1;
		}
		
		//initial
		for ( int j = 1; j < n; j++ ){
			if ( matrix[0][j] == 1 ){
				dp[0][j] = 0;
			}else{
				dp[0][j] = dp[0][j - 1];
			}
		}
		
		for ( int i = 1; i < m; i++ ){
			if ( matrix[i][0] == 1 ){
				dp[i][0] = 0;
			}else{
				dp[i][0] = dp[i - 1][0];
			}
		}
		
		//rule
		for ( int i = 1; i < m; i++ ){
			for ( int j = 1; j < n; j++ ){
				if ( matrix[i][j] == 1 ){
					dp[i][j] = 0;
				}else{
					dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
				}
			}
		}
		
		return dp[m - 1][n - 1];
		
	}
}