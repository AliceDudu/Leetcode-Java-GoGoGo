// 把1存在set里，去2里一个一个看是否在1里存在，
// 存在的为了不重复记录，加入到inter的set里，
// 把inter变成int［］

public class Solution{
	public int[] intersection( int[] nums1, int[] nums2 ){
		Set<Integer> set = new HashSet<>();
		
		Set<Integer> intersect = new HashSet<>();
		
		for ( int i = 0; i < nums1.length; i++ ){
			set.add(nums1[i]);
		}
		
		for ( int i = 0; i < nums2.length; i++ ){
			if ( set.contains(nums2[i]) ){
				intersect.add(nums2[i]);
			}
		}
		
		int[] res = new int[intersect.size()];
		
		int i = 0;
		for ( int num : intersect ){
			res[i++] = num;
		}
		
		return res;
	}
}