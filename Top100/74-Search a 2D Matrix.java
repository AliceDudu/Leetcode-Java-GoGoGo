public class Solution{
	public boolean searchMatrix(int[][] matrix, int target){
		//corner
		if ( matrix == null || matrix.length == 0 )
			return false;
		
		if ( matrix[0] == null || matrix[0].length == 0 )
			return false;
		
		//core
		int m = matrix.length;
		int n = matrix[0].length;
		int start = 0;
		int end = m * n - 1;
		
		while ( end >= start ){
			int mid = start + (end - start) / 2;
			
			if ( matrix[mid / n][mid % n] == target )
				return true;
			else if ( matrix[mid / n][mid % n] > target )
				end = mid - 1;
			else
				start = mid + 1;
		}
		
		return false;
	
	}
}



// 不用recursion
// public class Solution{
// 	public boolean searchMatrix(int[][] matrix, int target){
// 		//corner
// 		if ( matrix == null || matrix.length == 0 )
// 			return false;
// 		
// 		if ( matrix[0] == null || matrix[0].length == 0 )
// 			return false;
// 		
// 		
// 		//core
// 		int i = 0;
// 		while ( i < matrix.length  && target > matrix[i][0] ){
// 			i++;
// 		}
// 		//卡在边界
// 		
// 
// 		//停在最后一层，或者target小于等于i层了 !! 乱
// 		if ( target < matrix[i][0] )		// [[1]],2
// 			if ( i == 0 )
// 				return false;
// 			else
// 				layer = i - 1;
// 		else if ( target == matrix[i][0]  )
// 			return true;
// 		else
// 			if ( i >= matrix.length )
// 				layer = i - 1;
// 			else 
// 				layer = i;
// 		
// 		
// 		return binarySearch(matrix[layer], target, 0, matrix[0].length);
// 	}
// 	
// 	private boolean binarySearch(int[] array, int target, int start, int end){
// 		if ( start > end )
// 			return false;
// 	
// 		int mid = start + (end - start) / 2;
// 		
// 		if ( array[mid] < target )
// 			return binarySearch( array, target, mid + 1, end );
// 		else if ( array[mid] > target ) 
// 			return binarySearch( array, target, start, mid - 1 );
// 		else
// 			return true;
// 		
// 	}
// 	
// 	
// }