

从click这一点出发，逐条执行这四个rule
rule 1:遇到第一条rule，如果自己是雷，变换成X后，game over，直接返回board
rule 4:如果自己不是雷，数一下click这个点的周围有多少雷，这个周围的意思是九宫格
rule 4:如果click这点周围有雷，则这点上的val变为count雷的数目
rule 2:如果周围没有雷，它就变为B，并且接着执行rule 3
rule 3:递归地把它九宫格范围的点都变换了

public class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        int m = board.length, n = board[0].length;
        int row = click[0], col = click[1];
        
//         rule 1:遇到第一条rule，变换完后，game over
        if (board[row][col] == 'M') { // Mine
            board[row][col] = 'X';
            
        }else { // Empty
            // Get number of mines first.
//             rule 4:数一下click这个点的周围有多少雷，这个周围的意思是九宫格
            int count = 0;
            for (int i = -1; i < 2; i++) {
                for (int j = -1; j < 2; j++) {
                    if (i == 0 && j == 0) {
                    	continue;
                    }
//                     以click的这个点为中心的一个九宫格，r c走遍这个九宫格的每一个点
                    int r = row + i, c = col + j;
//                     超出board边界的就掠过
                    if (r < 0 || r >= m || c < 0 || c >= n) {
                    	continue;
                    }
//                     如果遇到雷，count＋1
                    if (board[r][c] == 'M' || board[r][c] == 'X') {
                    	count++;
                    }
                }
            }
            
//             rule 4:如果click这点周围有雷，则这点上的val变为count雷的数目
            if (count > 0) { // If it is not a 'B', stop further DFS.
                board[row][col] = (char)(count + '0');
                
            }else { // Continue DFS to adjacent cells.
//             	rule 2:如果周围没有雷，它就变为B
                board[row][col] = 'B';
                
                for (int i = -1; i < 2; i++) {
                    for (int j = -1; j < 2; j++) {
//                     	row col这个点已经变完了，所以掠过
                        if (i == 0 && j == 0) {
                        	continue;
                        }
//                         九宫格的其它位置走一遍
                        int r = row + i, c = col + j;
                        if (r < 0 || r >= m || c < 0 || c >= n) {
                        	continue;
                        }
//                         rule 3:递归地把各自范围的点都变换了
                        if (board[r][c] == 'E') {
                        	updateBoard(board, new int[] {r, c});
                        }
                    }
                }
            }
        }
        
        return board;
    }
}