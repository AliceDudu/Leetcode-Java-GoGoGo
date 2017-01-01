public class Solution{
	public List<Integer> spiralOrder(int[][] matrix){
	
		List<Integer> res = new ArrayList<Integer>();
		
		if ( matrix.length == 0 )
			return res;
		
		int rowStart = 0;
		int rowEnd = matrix.length - 1;
		int colStart = 0;
		int colEnd = matrix[0].length - 1;
		
		int i = 0, j = 0;
		
		while ( rowEnd >= rowStart && colEnd >= colStart ){	//? &&: && or ||
			//i stay, j++
			for ( j = colStart; j <= colEnd; j++ ){
				res.add( matrix[rowStart][j] );
			}
			rowStart += 1;
		
			for ( i = rowStart; i <= rowEnd; i++ ){ // eg m<n: stop
				res.add( matrix[i][colEnd] );
			}
			colEnd -= 1;
			
			if ( rowStart <= rowEnd ){
				for ( j = colEnd; j >= colStart; j-- ){ //??+if : continue
					res.add( matrix[rowEnd][j] );
				}
				rowEnd -= 1;
			}
		
			if ( colStart <= colEnd ){
				for ( i = rowEnd; i >= rowStart; i-- ){ //stop
					res.add( matrix[i][colStart] );
				}
				colStart += 1;
			}
		}
		
		return res;
		
	}
}