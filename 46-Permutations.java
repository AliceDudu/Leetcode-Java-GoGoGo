public class Solution{
	public List<List<Integer>> permutations(int[] arr){
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		//corner
		if ( arr == null || arr.length == 0 ){
			return res;
		}
		
		//core
		List<Integer> curList = new ArrayList<>();
// 		return helper(res, curList, arr);
		helper(res, curList, arr);
		
		return res;
	}
	
// 	public List<List<Integer>> helper(List<List<Integer>> res, List<Integer> curList, int[] arr){
	public void helper(List<List<Integer>> res, List<Integer> curList, int[] arr){
		//base
		if ( curList.size() == arr.length ){
			res.add(new ArrayList<Integer>(curList));			//forget
			return ;
		}
		
		//current
		for ( int i = 0; i < arr.length; i++ ){
			if ( curList.contains(arr[i]) ){
				continue;
			}
			
			curList.add(arr[i]);
			
			//next
			helper(res, curList, arr);
			
			curList.remove(curList.size() - 1);					//.size(), not .length
		}
	}
}