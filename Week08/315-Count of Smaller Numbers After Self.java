public class Solution{
	public List<Integer> countSmaller(int[] nums){ 					//return list not int[]
		List<Integer> res = new ArrayList<>();
		//corner
		if ( nums == null || nums.length == 0 ){
			return res;
		}
		//core
		List<Integer> sorted = new ArrayList<>();			//
		
		for ( int i = nums.length - 1; i >= 0; i-- ){
			int index = findIndex(sorted, nums[i]);
			sorted.add(index, nums[i]);
			res.add(0, index);
		}
		
		return res;
	}
	

	public int findIndex ( List<Integer> sorted, int target ){
		//corner
		if ( sorted == null || sorted.size() == 0 ){
			return 0;
		}
		
		int beg = 0;
		int end = sorted.size() - 1;
		
		if ( target < sorted.get(beg) ){					//
			return 0;
		}
		
		if ( target > sorted.get(end) ){
			return sorted.size();
		}
		
		while ( beg + 1 < end ){					//
			int mid = beg + (end - beg) / 2; 
			
			if ( target > sorted.get(mid) ){
				beg = mid;
			}else{
				end = mid;
			}
		}
		
		if ( sorted.get(beg) == target ){
			return beg;
		}else{
			return end;
		}
	}

}