public class Solution{
	public int maxProduct( int[] A ){
		//corner
		if ( A == null || A.length == 0 ){
			return 0;
		}
		
		int max = A[0];
		int min = A[0];
		int res = A[0];
		
		for ( int i = 1; i < A.length; i++ ){
			int temp = max;
			
			max = Math.max(Math.max(max * A[i], min * A[i]), A[i]);	
			min = Math.min(Math.min(temp * A[i], min * A[i]), A[i]);	//n
			
			if ( max > res ){
				res = max;
			}
		}
		
		return res;
	}
}