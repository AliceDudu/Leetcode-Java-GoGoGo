public class Solution{
	public int integerBreak( int n ){
		if ( n == 2 ){
			return 1;
		}
		
		if ( n == 3 ){
			return 2;
		}
		
		double res;
		
		int n3 = n / 3;
		int shift = n % 3;
		
		res = Math.pow(3, n3);
		
		if ( shift == 1 ){
			res = res / 3 * 4;
		}else if ( shift == 2 ){
			res = res * 2;
		}
		
		return (int)res;
	}
}