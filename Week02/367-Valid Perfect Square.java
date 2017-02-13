

// 先看中值的平方是否＝＝num
// 然后，如果s大于num，则right左移
// 如果s小于num，则left右移
// 找不到就false

public class Solution{
	public boolean isPerfectSquare( int num ){
		//corner
		if ( num < 1 ){		
			return false;
		}
		//core
		long left = 1;
		long right = num;
		
		while ( left + 1 < right ){		//
			long mid = left + (right - left) / 2;	//int
			
			long s = mid * mid;
			
			if (s == num ){
				return true;
			}else if ( s > num ){
				right = mid;
			}else{
				left = mid;
			}	
		}
		
		if ( left * left == num || right * right == num ){
			return true;
		}else{
			return false;
		}
		
	}
}

