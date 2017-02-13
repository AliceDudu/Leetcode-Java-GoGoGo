public class Solution{
	public int longestPalindromeSubseq( String s ){
		int len = s.length();
		
		int[][] dp = new int[len][len];
		
		for ( int i = 0; i < len; i++ ){
			dp[i][i] = 1;
		}
		
		for ( int l = 2; l <= len; l++ ){
			for ( int st = 0; st <= len - l; st++ ){		//
				int end = st + l - 1;					//
				if ( s.charAt(st) == s.charAt(end) ){
					dp[st][end] = dp[st + 1][end - 1] + 2;
				}else{
					dp[st][end] = Math.max(dp[st + 1][end], dp[st][end - 1]);
				}
			}
		}
		
		return dp[0][len - 1];
	}
}