用一个计数器cnt来统计1的个数，
方法是如果当前数字为0，那么cnt重置为0，
如果不是0，cnt自增1，
然后每次更新结果res

from [1,1,0,1,1,1]
count: 1 1 0 1 2 3
res:  2 3

public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
    	int res = 0; 
    	int count = 0;
    	
    	for ( int i = 0; i < nums.length; i++ ){
    		if ( nums[i] == 1 ){
    			count++;
    			res = Math.max(count, res);
    		}else{
    			count = 0;
    		}
    	}    
    	
    	return res;
    }
}