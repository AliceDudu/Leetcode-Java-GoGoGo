public class Solution{
	public int rob(int[] nums){
		//corner
		if ( nums == null || nums.length == 0 ){
			return 0;
		}
		
		if ( nums.length == 1 ){
			return nums[0];
		}
		
		if ( nums.length == 2 ){					//forgot this case
			return Math.max(nums[0], nums[1]);
		}
		
		//core
		int res1 = helper(nums, 0, nums.length - 2);
		int res2 = helper(nums, 1, nums.length - 1);
		
		return Math.max(res1, res2);
	}
	
	public int helper(int[] nums, int start, int end){
		int[] dp = new int[end - start + 2];
		
		dp[0] = 0;
		dp[1] = nums[start];
		
		for ( int i = 2; i <= end - start + 1; i++ ){
			dp[i] = Math.max(dp[i - 1], nums[start + i - 1] + dp[i - 2]);		
		}
		
		return dp[end - start + 1];
	}
}

// dp[i] = Math.max(dp[i - 1], nums[i - 1] + dp[i - 2]);
// Input:
// [1,1,1,2]
// Output:
// 2
// Expected:
// 3