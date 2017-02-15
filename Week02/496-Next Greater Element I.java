

先遍历nums2，每一个都将后面第一个比它大的找到，存进map里，找的过程用stack
再遍历nums1，每一个若可以在map找到，就返回val，否则－1

public class Solution{
	public int[] nextGreaterElement( int[] findNums, int[] nums ){
		Map<Integer, Integer> map = new HashMap<>();
		
		Stack<Integer> stack = new Stack<>();
		int[] res = new int[findNums.length];
		
		for ( int num : nums ){
			while ( !stack.isEmpty() && stack.peek() < num ){
				map.put(stack.pop(), num);
			}
			stack.push(num);
		}
		
		for ( int i = 0; i < findNums.length; i++ ){
			res[i] = map.getOrDefault(findNums[i], -1);
		}
		
		return res;
	}
}