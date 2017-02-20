
只要求返回最终最小的连续子集长度，
所以 用 min track中间过程，每一次比较区间的最小距离
如果没比s大，就一直累加，
如果大于等于了，就从left剔除

定义两个指针left和right，分别记录子数组的左右的边界位置，
然后我们让right向右移，直到子数组和大于等于给定值或者right达到数组末尾，
此时我们更新最短距离，并且将left像右移一位，然后再sum中减去移去的值，
然后重复上面的步骤，
直到right到达末尾，且left到达临界位置，即要么到达边界，要么再往右移动，和就会小于给定值

public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
		if ( nums == null || nums.length == 0 ){
			return 0;
		}        
		
		int left = 0;
		int right = 0;
		int sum = 0;
		int min = Integer.MAX_VALUE;
		
		while ( right < nums.length ){
			sum += nums[right];
			right++;
			
			while ( sum >= s ){		//题意是 sum ≥ s，不是＝＝
				min = Math.min(min, right - left);
				sum -= nums[left];
				left++;
			}
		}
		
		return min == Integer.MAX_VALUE ? 0 : min;
    }
}