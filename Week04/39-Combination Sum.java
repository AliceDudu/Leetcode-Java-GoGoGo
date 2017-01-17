public class Solution {
	public List<List<Integer>> combinationSum(int[] candidate, int sum){		
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		//corner
		
		//core
		List<Integer> path = new ArrayList<>();
		
		Arrays.sort(candidate);
		
		helper(res, path, candidate, sum, 0);		//start from position = 0
		
		return res;
	}
	
	public void helper(List<List<Integer>> res, List<Integer> path, int[] candidate, int sum, int position){
		//base
		if ( sum == 0 ){									
			res.add(new ArrayList<Integer>(path));
			return ;										
		}
		
		//current
// 		for ( int i = position; i < candidate.length; i++ ){
// 			int k = sum / candidate[i];
// 			for ( int j = 1; j <= k; j++ ){
// 				path.add(candidate[i]);
// 				//next
// 				helper(res, path, candidate, sum - candidate[i] * j, i + 1);
// 			}			
// 			path.remove(path.size() - 1);
// 		}
		for ( int i = position; i < candidate.length && sum >= candidate[i]; i++ ){		//differ
			path.add(candidate[i]);
			//next: pass down remaining 'sum', and afterwards 'start position'
			helper(res, path, candidate, sum - candidate[i], i);						//differ
			path.remove(path.size() - 1);
		}
		
		return ;
	}
}
