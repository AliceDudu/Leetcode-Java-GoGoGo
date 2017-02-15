
如果有三个点b，c，d都分别和a之间的距离相等，
那么有六种排列方法，abc, acb, acd, adc, abd, adb
如果有n个点和a距离相等，那么排列方式为n(n-1)

遍历所有点，让每个点都做一次点a，
然后遍历其他所有点，统计和a距离相等的点有多少个，
然后分别带入n(n-1)计算结果并累加到res中


public class Solution{
	public int numberOfBoomerangs(int[][] points){
		int res = 0;
		
		Map<Integer, Integer> map = new HashMap<>();
		
		for ( int i = 0; i < points.length; i++ ){
			for ( int j = 0; j < points.length; j++ ){
				if ( i == j ){
					continue;
				}
				
				int d = distance(points[i], points[j]);
				
				map.put(d, map.getOrDefault(d, 0) + 1);
			}
			
			for ( int val : map.values() ){
				res += val * (val - 1);
			}
			
			map.clear();
		}
		
		return res;
	}
	
	public int distance( int[] a, int[] b ){
		int dx = a[0] - b[0];
		int dy = a[1] - b[1];
		
		return dx * dx + dy * dy;
	}
}