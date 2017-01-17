public class Solution {
	public void rotate(int[] nums, int k){
		if ( nums == null || nums.length ==1 )
			return nums;

		int n = nums.length;
		k = k % n;
		// nice !
		reverse(nums, 0, n-k-1);
		reverse(nums, n-k, n-1);
		reverse(nums, 0, n-1);
	}

	public void reverse(int[] nums, int left, int right){
		int tmp;
		while ( left < right ){
			tmp = nums[left];
			nums[left] = nums[right];
			nums[right] = tmp;
			left++;
			right--;
		}
	}

}


// public class Solution {
// 	public void rotate(int[] nums, int k){
// 		if ( nums == null || nums.length == 1 )
// 			return;
//
// 		int n = nums.length;
//
// 		int[] numsCopy = new int[n];
//
// 		for ( int i = 0; i < n; i ++ ){
// 			numsCopy[i] = nums[i];
// 		}
//
// 		for ( int i = 0; i < n; i ++ ){
// 			nums[ (i + k) % n ] = numsCopy[i];
// 		}
//
// 	}
// }
