public class Solution{
	public int rob(int[] nums){
		//corner
		if ( nums == null || nums.length == 0 ){
			return 0;
		}
		
		//core
		int[] dp = new int[nums.length + 1];		//1.dp的长度
		
		dp[0] = 0;					//3.得到递推公式后，再来赋值
		dp[1] = nums[0];
		
		for ( int i = 2; i <= nums.length; i++ ){		//4.i是dp的不是原数组的
			dp[i] = Math.max(dp[i - 1], nums[i - 1] + dp[i - 2]);	//2.先得到递推公式   nums[i]最长位置小于dp的，注意变型
                                                                // 			Runtime Error Message:
                                                                // Line 15: java.lang.ArrayIndexOutOfBoundsException: 2
		}
		
// 		int max = (int) Collections.max(dp);
// 		List b = Arrays.asList(ArrayUtils.toObject(dp));
// 		int max = Collections.max(b);
		int max = Arrays.stream(dp).max().getAsInt();
		
		return max;		//5.注意返回值
	}
}
