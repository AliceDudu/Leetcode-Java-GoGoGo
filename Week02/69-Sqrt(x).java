// 和判断x是否是完全平方一样，只是返回的是int

public class Solution{
	public int mySqrt(int x) {
		int left = 0; 
		int right = x;
		
		while ( left <= right ){
			long mid = (long)(left + (right - left) / 2);
			
			if ( mid * mid == x ){
				return (int)mid;
			}else if ( mid * mid < x ){
				left = (int)mid + 1;
			}else{
				right = (int)mid - 1;
			}
		}
		
		return right;
	}
}







