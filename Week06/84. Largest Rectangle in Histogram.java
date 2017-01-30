public class Solution{
	public int largestRectangleArea(int[] nums){
		//corner
		if ( nums == null || nums.length == 0 ){
			return 0;
		}

		Deque<Integer> stack = new ArrayDeque<>();
		int res = 0;
		
		for ( int i = 0; i <= nums.length; i++ ){  //why length?
			int cur = 0;
			
			if ( i == nums.length ){
				cur = -1;
			}else{
				cur = nums[i];
			}
			
			//不递增时，开始挨个从stack的右端向左弹出，计算area
			while ( !stack.isEmpty() && cur < nums[stack.peek()] ){		
				int height = nums[stack.pop()];
				int width = stack.isEmpty() ? i : i - stack.peek() - 1;
				res = Math.max(res, height * width);
			}
			
			//递增序列
			stack.push(i);
		}
		
		return res;
	
	}
}
