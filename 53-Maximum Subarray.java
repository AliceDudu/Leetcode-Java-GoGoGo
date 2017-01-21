public class Solution{
	public int maxSubArray(int[] nums){
		//corner
		if ( nums == null || nums.length == 0 ){
			return 0;
		}
	
		//core
		int[] dp = new int[nums.length];
		
		dp[0] = nums[0];
		
		for ( int i = 1; i < nums.length; i++ ){
			dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
		}
		
		int max = Arrays.stream(dp).max().getAsInt();
		
		return max;
	}
}