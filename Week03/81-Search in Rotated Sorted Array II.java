public class Solution{
	public boolean search(int[] nums, int target) {
		//corner
		if ( nums == null || nums.length == 0 ){
			return false;
		}
		
		//core
		int start = 0;
		int end = nums.length -1;
		
		while ( start < end - 1 ){
			int mid = start + (end - start) / 2;
			
			if ( target == nums[mid] ){
				return true;
			}
			
			if ( nums[mid] > nums[start] ){
				if ( target >= nums[start] && target <= nums[mid] ){
					end = mid;
				}else{
					start = mid;
				}
			}
			
			if ( nums[mid] < nums[start] ){
				if ( target >= nums[mid] && target <= nums[end] ){
					start = mid;
				}else{
					end = mid;
				}
			}
			
			if ( nums[mid] == nums[start] ){
				start++;
			}
			
		}
		
// 		if ( target == nums[start] ){
// 			return true;
// 		}else if ( target == nums[end] ){
// 			return true;
// 		}else{
// 			return false;
// 		}
		
		return target == nums[start] || target == nums[end];
        
    }
}