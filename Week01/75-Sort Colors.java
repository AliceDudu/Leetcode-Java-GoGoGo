public class Solution {
	public void sortColors(int[] nums){
		int left = 0;
		int right = nums.length - 1;
		int index = 0;
		
		while ( index <= right ){
			if ( nums[index] == 0 ){
				nums[index] = nums[left];
				nums[left] = 0;
				left++;
			}
			
			if ( nums[index] == 2 ){
				nums[index] = nums[right];
				nums[right] = 2;
				right--;   // ???
			}
			
			index ++;
		}	
	}	
}