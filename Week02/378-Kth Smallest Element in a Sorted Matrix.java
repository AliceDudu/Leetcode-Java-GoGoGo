

// 那么左上角的数字一定是最小的，而右下角的数字一定是最大的，所以这个是我们搜索的范围，
// 然后我们算出中间数字mid，由于矩阵中不同行之间的元素并不是严格有序的，所以我们要在每一行都查找一下mid，
// 遍历完所有的行可以找出中间数是第几小的数，然后k比较，进行二分查找

public class Solution{
	public int kthSmallest(int[][] matrix, int k){
		int low = matrix[0][0];
		int high = matrix[matrix.length - 1][matrix[0].length - 1] + 1;		//why +1
		
		while ( low < high ){
			int mid = low + (high - low) / 2;
			
			int count = 0;
			int j = matrix[0].length - 1;
			
			for ( int i = 0; i < matrix.length; i++ ){
				while ( j >= 0 && matrix[i][j] > mid ){
					j--;
				}
				count += (j + 1);
			}
			
			if ( count < k ){
				low = mid + 1;
			}else{
				high = mid;
			}
		}
		return low;
	}
}