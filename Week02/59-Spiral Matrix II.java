public class Solution{
	public int[][] generateMatrix(int n){
	
		int[][] res = new int[n][n];
		
		if ( n == 0 )
			return res;
			
		int rowStart = 0;
		int rowEnd = n - 1;
		int colStart = 0;
		int colEnd = n - 1;
		
		int count = 1;
		
		while ( rowStart <= rowEnd && colStart <= colEnd ){
			for ( int j = colStart; j <= colEnd; j++ ){
				res[rowStart][j] = count ++;
			}
			rowStart++;
			
			for ( int i = rowStart; i <= rowEnd; i++ ){
				res[i][colEnd] = count ++;
			}
			colEnd--;
			
			if ( rowStart <= rowEnd ){
				for ( int j = colEnd; j >= colStart; j-- ){
					res[rowEnd][j] = count ++;
				}
				rowEnd--;
			}
			
			if ( colStart <= colEnd ){
				for ( int i = rowEnd; i >= rowStart; i-- ){
					res[i][colStart] = count ++;
				}
				colStart++;
			}
			
		}
		
		return res;

	}
}