public class Solution{
	public int numWays( int n, int k ){
		if ( n == 0 || k == 0 ){
			return 0;
		}
		if ( n == 1 ){
			return k;
		}
		
		int lastS = k;
		int lastD = k * (k - 1);
		
		for ( int i = 2; i < n; i++ ){
			int tempD = (k - 1) * (lastS + lastD);
			lastS = lastD;
			lastD = tempD;
		}
		
		return lastS + lastD;
	
	}
}