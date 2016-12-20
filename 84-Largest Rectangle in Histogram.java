
// import java.util.Deque;
// import java.util.LinkedList;

public class Solution {

// 	public static void main(String[] args) {
// 		// TODO Auto-generated method stub
// 		int[] heights = {2,1,5,6,4,3};
// 		System.out.println(largestRectangleArea(heights));
// 
// 	}
// 	
	public int largestRectangleArea(int[] heights){
	
		if ( heights == null || heights.length == 0 )
			return 0;
		
		Deque<Integer> stack = new LinkedList<Integer>();	//store index
		int max = 0;
		
		for ( int i = 0; i <= heights.length; i++ ){
			
			int curVal = (i == heights.length) ? 0 : heights[i];  				//如果i到array的外面了，curVal＝0，否则就为当前index装的高度
			
			while ( !stack.isEmpty() && heights[stack.peekLast()] >= curVal ){		//如果 curVal 大于stack.peekLast()，说明这是cur的一个左边界
																					//stack里每个元素都是后一个元素的左边界，停止add的时候说明碰到了右边界
				int height = heights[stack.pollLast()];								//pollLast get height(index) AND REMOVE index from stack
				int leftBound = stack.isEmpty() ? 0 : (stack.peekLast() + 1);		// why +1: since pollLast() removed
				int rightBound = i;
				max = Math.max( max, height * (rightBound - leftBound) );
			}		

			stack.addLast(i);					//stack=[1,4]时，说明 1处比4处值小，但是2处被弹出去了，2处是比4处大的，4处相当于凹心
			
		}
		
		
		return max;
	}
}
