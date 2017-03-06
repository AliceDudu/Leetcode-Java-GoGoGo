

遍历整个board，遇到空的位置，1到9去填充这个位置
isValid是true的话，就是这个位置可以放这个c
继续下一次递归，结束时把数字设回'.'

public class Solution {
    public void solveSudoku(char[][] board) {
        if(board == null || board.length == 0)
            return;
            
        solve(board);
    }
    
    public boolean solve(char[][] board){
//     	遍历整个board
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
//             	遇到空的位置
                if(board[i][j] == '.'){
//                 	1到9去填充这个位置
                    for(char c = '1'; c <= '9'; c++){//trial. Try 1 through 9
//                     	isValid是true的话，就是这个位置可以放这个c
                        if(isValid(board, i, j, c)){
                            board[i][j] = c; //Put c for this cell
                            
                            if( solve(board) )
                                return true; //If it's the solution return true
                            else
                                board[i][j] = '.'; //Otherwise go back
                        }
                    }
                    
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean isValid(char[][] board, int row, int col, char c){
        for(int i = 0; i < 9; i++) {
//         	在col这一列中，如果c已经存在，就不valid
            if(board[i][col] != '.' && board[i][col] == c) {
            	return false; //check row
            }
//             在row这一行中，如果c已经存在，就不valid
            if(board[row][i] != '.' && board[row][i] == c) {
            	return false; //check column
            }
//             在row col所在的九宫格里如果已经有c了，就不valid
            if(board[3 * (row / 3) + i / 3][ 3 * (col / 3) + i % 3] != '.' && 
			board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) {
				return false; //check 3*3 block
			}
        }
        
        return true;
    }
}