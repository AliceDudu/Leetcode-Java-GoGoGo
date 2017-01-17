public class Solution{
	public List<List<Integer>> combine(int n, int k){
		List<List<Integer>> res = new ArrayList<>();
		//corner
		if ( n < 1 || k > n ){
			return res;
		}
		
		List<Integer> path = new ArrayList<>();
// 		int[] nums = new int[n];								//no need to build extra array
		
// 		helper(res, path, nums, position, k);
		helper(res, path, n, 1, k);								//start from position=1
		
		return res;
	}
	
	public void helper(List<List<Integer>> res, List<Integer> path, int n, int position, int k){
		//base
		if ( path.size() == k ){
			res.add(new ArrayList<Integer>(path));
		}
		
		//current
		for ( int i = position; i <=n; i++ ){					//i < nums.length
			path.add(i);										//path.add(nums[i]);
			//next
			helper(res, path, n, i + 1, k);
			path.remove(path.size() - 1);
		}
	}
}