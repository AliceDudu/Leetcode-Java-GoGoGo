

//DFS
public class Solution{
	int res = 0;
	
	public int findTargetSumWays( int[] nums, int S ){
		

		//corner
		if ( nums == null || nums.length == 0 ){
			return res;
		}
		
		int n = nums.length;
		int[] sums = new int[n];
		sums[n - 1] = nums[n - 1];
		
		for ( int i = n - 2; i >= 0; i--  ){
			sums[i] = sums[i + 1] + nums[i];		//?
		}
		
		helper(nums, sums, S, 0);
		
		return res;
		
	}
	
	public void helper( int[] nums, int[] sums, int target, int pos ){
		if ( pos == nums.length ){
			if ( target == 0 ){		//path sum up = target
				res++;
			}
			return;
		}
		
		if ( sums[pos] < Math.abs(target) ){	//sum of all elements left is smaller than absolute value of target
			return ;
		}
		
		helper(nums, sums, target + nums[pos], pos + 1);	//try +
		helper(nums, sums, target - nums[pos], pos + 1);	//try -
	
	}
}

//DP
// public class Solution{
// 	public int findTargetSumWays( int[] nums, int S ){
// 		int sum = 0;
// 		
// 		for ( int i : nums ){
// 			sum += i;		//sum up all nums
// 		}	
// 		
// 		//corner
// 		if ( S > sum || S < -sum ){
// 			return 0;
// 		}
// 		
// 		int[] dp = new int[2 * sum + 1];	//?
// 		dp[0 + sum] = 1;
// 		
// 		for ( int i = 0; i < nums.length; i++ ){
// 			int[] next = new int[2 * sum + 1];	//?
// 			
// 			for ( int k = 0; k < 2 * sum + 1; k++ ){
// 				if ( dp[k] != 0 ){
// 					next[k + nums[i]] += dp[k];	//?
// 					next[k - nums[i]] += dp[k];
// 				}
// 			}
// 			
// 			dp = next;	//?
// 		}
// 		return dp[sum + S];	//?
// 		
// 	}
// }