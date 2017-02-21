
因为一个字母只能访问一次，所以用个boolean矩阵跟踪谁被track了
用两个for循环，遇到第一个字母相等时，就进入recursion
从这个位置，开始向四个方向走
如果当前的指向word里的index已经超过尾部，说明全部匹配好了，返回true
如果当前位置的xy坐标超过board，或者当前字母并不等于index指向的字母，或者这个字母已经被访问过了，都返回false，退回到上一层
如果符合条件，就把visited更新为true，从这个位置继续向四周走

 

public class Solution {
    static boolean[][] visited;
    
    public boolean exist( char[][] board, String word ){
        visited = new boolean[board.length][board[0].length];
        
        for( int i = 0; i < board.length; i++ ){
            for( int j = 0; j < board[i].length; j++ ){
                if( (word.charAt(0) == board[i][j]) && search(board, word, i, j, 0) ){
                    return true;
                }
            }
        }
        
        return false;
    }
    
    private boolean search( char[][]board, String word, int i, int j, int index ){
        if( index == word.length() ){
            return true;
        }
        
        if( i >= board.length || i < 0 || j >= board[i].length || j < 0 || board[i][j] != word.charAt(index) || visited[i][j] ){
            return false;
        }
        
        visited[i][j] = true;
        
        if( search(board, word, i - 1, j, index + 1) || 
            search(board, word, i + 1, j, index + 1) ||
            search(board, word, i, j - 1, index + 1) || 
            search(board, word, i, j + 1, index + 1) ){
            return true;
        }
        
        visited[i][j] = false;		//---
        
        return false;
    }
}

// 若没有倒数第二行 visited[i][j] = false;	
// Input:
// ["CAA","AAA","BCD"]
// "AAB"
// Output:
// false
// Expected:
// true