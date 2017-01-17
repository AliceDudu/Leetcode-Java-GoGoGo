public class Solution{
	public List<List<Integer>> subsets(int[] nums){
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		//corner
		if ( nums == null || nums.length == 0 ){
			return res;
		}
		
		//core
		Arrays.sort(nums);
		
		List<Integer> path = new ArrayList<>();
		helper(res, path, nums, 0);		//0 position
		
		return res;
	}
	
	public void helper(List<List<Integer>> res, List<Integer> path, int[] nums, int position){
		//base
// 		if (  ){				//不用等到头再加，直接加进去
// 			res.add(new ArrayList<Integer>(path));
// 			return ;
// 		}
		res.add(new ArrayList<Integer>(path));
		
		//current
		for ( int i = position; i < nums.length; i++ ){
// 			if ( path.contains(nums[i]) ){
// 				continue;
// 			}
			
			path.add(nums[i]);
			
			//next
			helper(res, path, nums, i + 1);				//wrong: helper(res, path, nums, position);
			
			path.remove(path.size() - 1);				//wrong: path.remove(nums.length - 1);
		}
		return ;
	}
}