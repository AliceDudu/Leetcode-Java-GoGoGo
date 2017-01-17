public class Solution{
	public List<List<Integer>> subsetsWithDup(int[] nums){
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		//corner
		if ( nums == null || nums.length == 0 ){
			return res;
		}
		//core
		List<Integer> path = new ArrayList<>();
		Arrays.sort(nums);
		helper(res, path, nums, 0);
		
		return res;
	}
	
	public void helper(List<List<Integer>> res, List<Integer> path, int[] nums, int position){
		//base
		res.add(new ArrayList<Integer>(path));
		
		//current
		for ( int i = position; i < nums.length; i++ ){
		
			if ( i != position && nums[i] == nums[i - 1] ){		//if duplicates continue
				continue;
			}
			
			path.add(nums[i]);
			
			//next
			helper(res, path, nums, i + 1);
			
			path.remove(path.size() - 1);
		}

		return ;
	}
}