

// 快速找到第一个大于等于当前house位置的数，
// 如果这个数存在，那么我们可以算出其和house的差值，并且如果这个数不是heater的首数字，
// 我们可以算出house和前面一个数的差值，这两个数中取较小的为cover当前house的最小半径

public class Solution{
	public int findRadius( int[] houses, int[] heaters ){
		Arrays.sort(heaters);
		
// 		int res = Integer.MIN_VALUE;
		int res = 0;
		
		for ( int house : houses ){
// 			int index = Arrays.binarySearch(heaters, house);
			
			int left = 0;
			int right = heaters.length;
			
			while ( left < right ){
				int mid = left + (right - left) / 2;
				if ( heaters[mid] < house ){
					left = mid + 1;
				}else{
					right = mid;
				}
			}
			int index = right;
			
			
			if ( index < 0 ){
				index = -(index + 1);
			}
			
			int dis1 = index - 1 >= 0 ? house - heaters[index - 1] : Integer.MAX_VALUE;
			int dis2 = index < heaters.length ? heaters[index] - house : Integer.MAX_VALUE;
			
			res = Math.max(res, Math.min(dis1, dis2));
		}
		
		return res;
	}
}


