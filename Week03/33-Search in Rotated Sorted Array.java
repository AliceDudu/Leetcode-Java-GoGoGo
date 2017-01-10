public class Solution{
	public int search(int[] nums, int target){
		//corner
		if ( nums == null || nums.length == 0 ){
			return -1;
		}
		
		//core
		int start = 0;
		int end = nums.length -1;
		
		while ( start < end - 1 ){
			int mid = start + (end - start) / 2;
			
			if ( target == nums[mid] ){
				return mid;
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
		}
		
		if ( target == nums[start] ){
			return start;
		}else if ( target == nums[end] ){
			return end;
		}else{
			return -1;
		}
	}
}