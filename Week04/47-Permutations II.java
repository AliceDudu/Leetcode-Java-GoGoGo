public class Solution{
	public List<List<Integer>> permutations(int[] nums){
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		//corner
		if ( nums == null || nums.length == 0 ){
			return res;
		}
		
		//core
		List<Integer> curList = new ArrayList<>();
		Arrays.sort(nums);										//wrong: nums.sort();
		boolean[] visited = new boolean[nums.length];			//forgot
		
		helper(res, curList, visited, nums);
		
		return res;
	}
	
	public void helper(List<List<Integer>> res, List<Integer> curList, boolean[] visited, int[] nums){
		//base
		if ( curList.size() == nums.length ){
			res.add(new ArrayList<Integer>(curList));
			return ;
		}
		
		//current
		for ( int i = 0; i < nums.length; i++ ){
// 			if ( nums[i] == nums[i - 1] && curList.contains(nums[i]) ){		//i=1
// 				continue;
// 			}
			
			if ( visited[i] || (i!=0 && nums[i]==nums[i-1] && visited[i - 1]) ){    //访问过i－1并且i和i－1一样
				continue;
			}
			
			curList.add(nums[i]);
			visited[i] = true;
			
			//next
			helper(res, curList, visited, nums);				//forgot visited
			
			curList.remove(curList.size() - 1);
			visited[i] = false;
		}


	}
}