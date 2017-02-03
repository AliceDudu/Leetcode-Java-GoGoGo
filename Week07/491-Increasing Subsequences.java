public class Solution{	
	public List<List<Integer>> findSubsequences( int[] nums ){
		Set<List<Integer>> res = new HashSet<List<Integer>>();
		List<Integer> path = new ArrayList<>();	//current path
		
		findSequence(res, path, 0, nums);	//index=0
		List result = new ArrayList(res);	//convert to list
		
		return result;
	}
	
	public void findSequence( Set<List<Integer>> res, List<Integer> path, int index,  int[] nums){
		//base
		if ( path.size() >= 2 ){
			res.add(new ArrayList<>(path));
		}
		
		
		for ( int i = index; i < nums.length; i++ ){
			//current
			if ( path.size() == 0 || path.get(path.size() - 1) <= nums[i] ){	//increasing
				path.add(nums[i]);
				
				//next
				findSequence(res, path, i + 1, nums);	//?detail
				
				path.remove(path.size() - 1);	//for next iteration path
			}
		}
	}
}