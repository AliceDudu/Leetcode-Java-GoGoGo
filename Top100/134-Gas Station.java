public class Solution {
	public int canCompleteCircuit(int[] gas, int[] cost){
		//corner
		if ( gas == null || cost == null || gas.length != cost.length )
			return -1;
		
		//core
		int start = gas.length - 1;						//用two pointer模拟deque，并不需要建立deque
		int end = 0;
		
		int gasLeftSum = gas[start] - cost[start];
// 		int gasLeftSum = 0;
		
		while ( start > end ){							//start >= end会停在小于，而非等于
			
			if ( gasLeftSum >= 0 ){							//end开始并为加进来，所以先加，再右移
				gasLeftSum += gas[end] - cost[end];
				end++;
			}else{
				start--;
				gasLeftSum += gas[start] - cost[start];		//start最开始已经被加上了，所以先左移，再加油
// 				start--;
			}	
		}
		
		return  gasLeftSum >= 0 ? start : -1;
	}
}