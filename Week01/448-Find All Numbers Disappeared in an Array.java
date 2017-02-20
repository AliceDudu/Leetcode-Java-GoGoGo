不让用额外的空间，但是还需要标记，那就把本身变成相反数
把每个访问到的数字，应该在的位置上，变成负数
已经负数了，就不用变化了
Input:
from
[4,3,2,7,8,2,3,1]
	  -7
	 -2
   -3
   			 -3
				-1
-4
to
[-4, -3, -2, -7, 8, 2, -3, -1]
				

对于每个数字nums[i]，
如果其对应的nums[nums[i] - 1]是正数，我们就赋值为其相反数，
如果已经是负数了，就不变了，
那么最后我们只要把留下的整数对应的位置加入结果res

public class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
		List<Integer> res = new ArrayList<>();
		
		for ( int i = 0; i < nums.length; i++ ){
			int index = nums[i];
			
			if ( nums[Math.abs(index) - 1] > 0 ){
				nums[Math.abs(index) - 1] = - nums[Math.abs(index) - 1];
			}
		}
		
		for ( int j = 1; j <= nums.length; j++ ){
			if ( nums[j - 1] > 0 ){
				res.add(j);
			}
		}
		
		return res;
    }
}