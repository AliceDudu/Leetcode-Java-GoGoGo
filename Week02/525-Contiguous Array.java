

要求子集的最大长度，这个子集中，1和0的个数想等

diff[i]：num到i－1处，1的个数－0的个数
所以递推公式中，主要看目前为止倒数第一个数是否 nums[i - 1] == 0
如果＝0，则diff[i - 1] + （－1），
如果＝1，则diff[i - 1] + （1）

if diff[i] == diff[j]
则nums的 i到j－1处是一个子集，其中1和0的个数相等

然后计算i与j之间的子集的长度，即：i - map.get(diff[i])
map记录的是，每个不重复的diff第一次出现时的角标，角标相减得到子集长度

然后res更新为最max的


diff[i] is "count of 1s" minus "count of 0s" so far.

For given i and j, if diff[i] == diff[j], 
then the subarray between i and j is a contiguous array as defined in the questions.

For any value of diff[], we save the index of the first item in the hashmap. 
Then once the value appears again, 
we get the length of the subarray between the current index and the index of the first item.

public class Solution {
    public int findMaxLength(int[] nums) {
    
    	int res = 0;
    	int n = nums.length;
    
//     	diff[i]：num到i－1处，1的个数－0的个数
    	int[] diff = new int[n + 1];
    
    	Map<Integer, Integer> map = new HashMap<>();
    	map.put(0, 0);
    
    	for (int i = 1; i <= n; i++) {
//     		所以递推公式中，主要看目前为止倒数第一个数是否 nums[i - 1] == 0
        	diff[i] = diff[i - 1] + ( nums[i - 1] == 0 ? -1 : 1 );

        	if ( !map.containsKey(diff[i]) )
            	map.put(diff[i], i);
            
//             如果 diff[i] == diff[j]
// 			则nums的 i到j－1处是一个子集，其中1和0的个数相等
        	else
//         		然后计算i与j之间的子集的长度，即：i - map.get(diff[i])
// 				然后res更新为最max的
            	res = Math.max( res, i - map.get(diff[i]) );
    	}

    	return res;
	}
}