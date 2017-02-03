public class Solution{
	public static final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	
	public int longestIncreasingPath( int[][] matrix ){
		if ( matrix.length == 0 ){
			return 0;
		}
		
		int m = matrix.length;
		int n = matrix[0].length;
		int[][] cache = new int[m][n];	//initial dp
		int max = 1;
		
		for ( int i = 0; i < m; i++ ){
			for ( int j = 0; j < n; j++ ){
				int len = dfs(matrix, i, j, m, n, cache);
				max = Math.max(max, len);	//find max length
			}
		}
		
		return max;
	}
	
	public int dfs( int[][] matrix, int i, int j, int m, int n, int[][] cache ){
		if ( cache[i][j] != 0 ){
			return cache[i][j];
		}
		
		int max = 1;
		
		for ( int[] dir : dirs ){	//4 directions
			int x = i + dir[0];
			int y = j + dir[1];
			
			if ( x < 0 || x >= m || y < 0 || y >= n || matrix[x][y] <= matrix[i][j] ){
				continue;
			}
			
			//next
			int len = 1 + dfs(matrix, x, y, m, n, cache);	//len+1
			
			max = Math.max(max, len);
		}
		cache[i][j] = max;	//store max
		
		return max;
	}
}