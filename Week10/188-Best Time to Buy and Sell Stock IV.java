

/**
 * dp[i, j] represents the max profit up until prices[j] using at most i transactions. 
 * dp[i, j] = max(dp[i, j-1], prices[j] - prices[jj] + dp[i-1, jj]) { jj in range of [0, j-1] }
 *          = max(dp[i, j-1], prices[j] + max(dp[i-1, jj] - prices[jj]))
 * dp[0, j] = 0; 0 transactions makes 0 profit
 * dp[i, 0] = 0; if there is only one price data point you can't make any transaction.
 */
 
 public class Solution {

    public int maxProfit(int k, int[] prices) {
	
		int n = prices.length;
		
		if (n <= 1){
			return 0;
		}
	
		//if k >= n/2, 直接计算最多可以有多少profit
		if (k >= n / 2) {
			int maxPro = 0;
			
			
			for (int i = 1; i < n; i++) {					//如果当前比前一个大，就可以用这两个买卖一次，累加这个和
				if (prices[i] > prices[i-1]){
					maxPro += prices[i] - prices[i-1];
				}
			}
		
			return maxPro;
		}
	
		//if k < n/2								//dp i j 代表到price j为止，这个子集，交易i次可以获得的最大profit
    	int[][] dp = new int[k+1][n];				//dp[0, j] = 0; 0 transactions makes 0 profit
    												//dp[i, 0] = 0; if there is only one price data point you can't make any transaction
    
    
    	for (int i = 1; i <= k; i++) {
    		int localMax = dp[i-1][0] - prices[0];
    		
    		for (int j = 1; j < n; j++) {   		
    			dp[i][j] = Math.max(dp[i][j-1],  prices[j] + localMax);					
    			localMax = Math.max(localMax, dp[i-1][j] - prices[j]);		
    		}
    	}
    
    	return dp[k][n-1];
	}
}






