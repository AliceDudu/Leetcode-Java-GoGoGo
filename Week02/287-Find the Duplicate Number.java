

// 在区别[1, n]中搜索，首先求出中点mid，然后遍历整个数组，统计所有小于等于mid的数的个数，
// 如果个数大于mid，则说明重复值在[mid+1, n]之间，
// 反之，重复值应在[1, mid-1]之间，
// 然后依次类推，直到搜索完成，此时的low就是我们要求的重复值

public class Solution{
	public int findDuplicate( int[] nums ){
		int left = 0;
		int right = nums.length;
		
		while ( left < right ){
			int mid = left + (right - left) / 2;
			int count = 0;
			
			for ( int i = 0; i < nums.length; i++ ){
				if ( nums[i] <= mid ){
					count++;
				}
			}
			
			if ( count <= mid ){
				left = mid + 1;
			}else{
				right = mid;
			}
		}
		
		return left;
	}
}