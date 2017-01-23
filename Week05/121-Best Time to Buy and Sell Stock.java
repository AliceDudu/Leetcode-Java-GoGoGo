public class Solution{
	public int maxProfit(int[] nums){
		//corner
		if ( nums == null || nums.length == 0 ){
			return 0;
		}
		
		//core
		int curMin = nums[0];
		int max = 0;
		
		for ( int i = 1; i < nums.length; i++ ){
			curMin = Math.min(curMin, nums[i]);
		
			max = Math.max(max, nums[i] - curMin);
			
		}
		
		return max;
	}
}