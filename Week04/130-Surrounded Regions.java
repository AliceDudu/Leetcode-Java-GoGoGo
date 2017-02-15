
扫矩阵的四条边，如果有O，则用DFS遍历，将所有连着的O都变成另一个字符，
这样剩下的O都是被包围的，然后将这些O变成X


public class Solution{
	public void solve( char[][] board ){
		if ( board.length == 0 || board[0].length == 0 ){
			return;
		}
		
		if ( board.length < 2 || board[0].length < 2 ){
			return;
		}
		
		int m = board.length;
		int n = board[0].length;
		
		for ( int i = 0; i < m; i++ ){
			if ( board[i][0] == 'O' ){
				dfs(board, i, 0);
			}
			if ( board[i][n - 1] == 'O' ){
				dfs(board, i, n - 1);
			}
		}
		
		for ( int j = 0; j < n; j++ ){
			if ( board[0][j] == 'O' ){
				dfs(board, 0, j);
			}
			if ( board[m - 1][j] == 'O' ){
				dfs(board, m - 1, j);
			}
		}
		
		for ( int i = 0; i < m; i++ ){
			for ( int j = 0; j < n; j++ ){
				if ( board[i][j] == 'O' ){
					board[i][j] = 'X';
				}else if ( board[i][j] == '*' ){
					board[i][j] = 'O';
				}
			}
		}
	}
	
	public void dfs( char[][] board, int i, int j ){
		if ( i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1 ){
			return;
		}
		if ( board[i][j] == 'O' ){
			board[i][j] = '*';
		}
		if (i > 1 && board[i - 1][j] == 'O'){
			dfs(board, i - 1, j);
		}
		if (i < board.length - 2 && board[i + 1][j] == 'O'){
			dfs(board, i + 1, j);
		}
		if (j > 1 && board[i][j - 1] == 'O'){
			dfs(board, i, j - 1);
		}
		if (j < board[i].length - 2 && board[i][j + 1] == 'O' ){
			dfs(board, i, j + 1);
		}
		
	}
}










