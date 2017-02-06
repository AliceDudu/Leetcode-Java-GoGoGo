

public class Solution {
    public int coinChange(int[] coins, int amount) {
    	//corner
    	if ( coins == null || coins.length == 0 ){
    		return -1;
    	}
    	
    	//core
    	int[] dp = new int[amount + 1];
    	
    	//initial
    	dp[0] = 0;
    	for ( int i = 1; i <= amount; i++ ){
    		dp[i] = Integer.MAX_VALUE;
    	}
    	
    	//rule
    	for ( int i = 0; i <= amount; i++ ){
    		for ( int j = 0; j < coins.length; j++ ){
    			if ( i + coins[j] <= amount ){
    				if ( dp[i] == Integer.MAX_VALUE ){
    					dp[i + coins[j]] = dp[i + coins[j]];
    				}else{
    					dp[i + coins[j]] = Math.min(dp[i + coins[j]], dp[i] + 1);
    				}
    			}
    		}
    	}
    	
    	
    	//return
    	if ( dp[amount] == Integer.MAX_VALUE ){
    		return -1;
    	}else{
    		return dp[amount];
    	}

    }
}