用 dp x y 来存：以当前点 x y 出发，能找到的最长的升序path的长度
用到了 dfs ，相当于先把给定 matrix 的局部区内最大值找到，先赋值为1，因为以它们为起点，升序序列只有自己
即 matrix[nextX][nextY] > matrix[x][y] 时，先把 dp[nextX][nextY] 填上
这样，下一步遇到临近的比他小的点，作为起点时，只需要再这个长度上加1，
局部：当然四个方向上要选择一个max
全局：每走一步，也要记录一个max

public class Solution{
	int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	
	public int longestIncreasingPath( int[][] matrix ){
		if ( matrix == null || matrix.length == 0 ){
			return 0;
		}
		
		//dp matrix
		int m = matrix.length;
		int n = matrix[0].length;
		int[][] maxPath = new int[m][n];	//initial dp
		//用 dp x y 来存：以当前点 x y 出发，能找到的最长的升序path的长度
		
		int max = 0;
		
		//recursion
		for ( int i = 0; i < m; i++ ){
			for ( int j = 0; j < n; j++ ){
				//全局：每走一步，也要记录一个max
				max = Math.max(max, helper(i, j, maxPath, matrix, m, n));	//find max length
			}
		}
		
		return max;
	}
	
	public int helper( int x, int y, int[][] maxP, int[][] matrix, int row, int col ){
		//stop case
		if ( maxP[x][y] != 0 ){
			return maxP[x][y];
		}
		
		int max = 1;
		
		//current
		for ( int[] dir : dirs ){	//4 directions
			int nextX = x + dir[0];
			int nextY = y + dir[1];
			
			//next
			if ( isValid(nextX, nextY, row, col) && matrix[nextX][nextY] > matrix[x][y] ){
				max = Math.max(helper(nextX, nextY, maxP, matrix, row, col) + 1, max);
				//遇到临近的比他小的点，作为起点时，只需要再这个长度上加1
			}
			//局部：当然四个方向上要选择一个max
		}
		
		maxP[x][y] = max;	//store max
		
		return max;
	}
	
	public boolean isValid( int i, int j, int row, int col ){
		return i >= 0 && j >= 0 && i < row && j < col;
	}
}


//top sol: 15ms Concise Java Solution
//http://www.cnblogs.com/grandyang/p/5148030.html
//https://www.hrwhisper.me/leetcode-longest-increasing-path-matrix/

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
			
			max = Math.max(max, len);	//?why max again?
		}
		cache[i][j] = max;	//store max
		
		return max;
	}
}