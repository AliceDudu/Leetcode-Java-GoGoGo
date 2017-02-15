求矩阵中连续区域的个数，DFS来解，
建立一个visited数组用来记录某个位置是否被访问过，
对于一个为‘1’且未被访问过的位置，我们递归进入其上下左右位置上为‘1’的数，
将其visited对应值赋为true，继续进入其所有相连的邻位置，这样可以将这个连通区域所有的数找出来，
并将其对应的visited中的值赋true，
找完此区域后，将结果res自增1，然后在继续找下一个为‘1’且未被访问过的位置，

public class Solution {
	public int n;
	public int m;
	
    public int numIslands(char[][] grid) {
    	int count = 0;
    	n = grid.length;
    	
    	if ( n == 0 ){
    		return 0;
    	}    
    	
    	m = grid[0].length;
    	
    	for ( int i = 0; i < n; i++ ){
    		for ( int j = 0; j < m; j++ ){
    			if ( grid[i][j] == '1' ){
    				dfs(grid, i, j);
    				++count;
    			}
    		}
    	}
    	
    	return count;
    }
    
    public void dfs( char[][] grid, int i, int j ){
    	if ( i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != '1' ){
    		return;
    	}
    	
    	grid[i][j] = 0;
    	
    	dfs(grid, i + 1, j);
    	dfs(grid, i - 1, j);
    	dfs(grid, i, j + 1);
    	dfs(grid, i, j - 1);
    	
    }
}