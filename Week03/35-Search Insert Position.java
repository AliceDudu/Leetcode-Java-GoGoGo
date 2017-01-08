public class Solution{
	public int searchInsert(int[] nums, int target){
		
		//corner
		if ( nums == null || nums.length == 0 ){
			return 0;
		}
		
		//core
		int start = 0;
		int end = nums.length - 1;
		
		while ( start <= end ){		//start < end - 1	
			int mid = start + (end - start) / 2;
			
			if ( nums[mid] == target ){
				return mid;
			}else if ( nums[mid] < target ){
				start = mid + 1;
// 				return start;
			}else{
				end = mid - 1;
// 				return start;
			}
		}
		
		return start;
		
// 		if ( target < nums[start] ){
// 			return 0;
// 		}else if ( target > nums[start] && target < nums[end] ){	//start < end:[1],1
// 			return start + 1;
// 		}else{		//target > nums[end]
// 			return end + 1;
// 		}
	}
}