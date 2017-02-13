
// 先看以中点为层数，计算需要的点数和，等差序列求和
// 再根据大小关系移动左右两端点

public class Solution{
	public int arrangeCoins( int n ){
		//corner
		if ( n == 0 ){
			return 0;
		}
	
		long nL = (long)n;
		
		long left = 1;
		long right = nL;
		
		while ( left <= right ){
			long mid = left + (right - left) / 2;
			long sum = mid * (mid + 1) / 2;
			
			if ( sum <= nL ){
				left = mid + 1;
			}else{
				right = mid - 1;
			}
		}
		
		return (int)(left - 1);
	}
}



