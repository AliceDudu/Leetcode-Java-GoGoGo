
dp[i] = dp[i-1] * (k-1) + dp[i-2] * (k-1);

The reason is that for a given i, we can consider both i itself and [i-1,i] as a whole, 
for the former case, we have k-1 choice, 
for the later case, we also have k-1 choice.

public class Solution {
    public int numWays(int n, int k) {
        if(n <= 0){
            return 0;
        }
        if(n == 1){
            return k;
        }
        
        int lastS = k;		//last single
        int lastD = k * (k - 1);		//last double

        for(int i= 3; i <= n; i++){
            int tempD = (k - 1) * (lastS + lastD);
            lastS = lastD;
            lastD = tempD;
        }

        return lastS + lastD;
    }
}



 public int numWays(int n, int k) {
        if(n == 0) return 0;
        if(n <= 2) return (int) Math.pow(k,n);
        // int[] dp = new int[n+1];   Solution with O(n) space complexity
        int[] dp  = new int[3];
        dp[0] = 0;
        dp[1] = k;
        dp[2] = k*k;
        for(int i = 3; i <= n; i++)
            // dp[i] = (dp[i-1] + dp[i-2]) * (k-1);
            {
                dp[0] = (dp[1]+dp[2]) * (k-1);
                dp[1] = dp[2];
                dp[2] = dp[0];
            }
        return dp[0];
    }