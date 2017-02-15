

建立一个长度为4的数组sums来保存每个边的长度和，我们希望每条边都等于target，数组总和的四分之一。
遍历sums中的每条边，我们判断如果加上数组中的当前数字大于target，那么我们跳过，如果没有，我们就加上这个数
对数组中下一个位置调用递归，如果返回为真，我们返回true，否则我们再从sums中对应位置将这个数字减去继续循环

public class Solution{
	public boolean makesquare( int[] nums ){
		if ( nums == null || nums.length < 4 ){
			return false;
		}
		
		int sum = 0;
		
		for ( int num : nums ){
			sum += num;
		}
		
		if ( sum % 4 != 0 ){
			return false;
		}
		
		return dfs(nums, new int[4], 0, sum / 4);
	}
	
	public boolean dfs( int[] nums, int[] sums, int index, int target ){
		if ( index == nums.length ){
			if ( sums[0] == target &&  sums[1] == target && sums[2] == target ){
				return true;
			}
			return false;
		}
		
		for ( int i = 0; i < 4; i++ ){
			if ( sums[i] + nums[index] > target ){
				continue;
			}else{
				sums[i] += nums[index];
			}
			
			if ( dfs(nums, sums, index + 1, target) ){
				return true;
			}
			sums[i] -= nums[index];
		}
		return false;
	}
}