

int[] cols = new int[n]; 用来存每一列有多少个E
int  rows = 0; 用来存每一行有多少个E
但它们都是在一行或者一列的初始时计算，并且只计算到墙前面
或者它们会在遇到墙之后的那一行或者一列开始重新计算，仍然只是计算到墙
grid[i][j] == '0' 当i j上为0时，计算一下它所在的行 列一共多少个E
与result比较，保留最大值

public class Solution {
    /**
     * @param grid Given a 2D grid, each cell is either 'W', 'E' or '0'
     * @return an integer, the maximum enemies you can kill using one bomb
     */
    public int maxKilledEnemies(char[][] grid) {
        // Write your code here
        int m = grid.length;
        int n = m > 0 ? grid[0].length : 0;

        int result = 0, rows = 0;
        int[] cols = new int[n];
        
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
//             	j == 0说明这一行是新起的
//             	这个if只在一行新起时或者碰到墙后那一格子重新开始计算
//             	eg，如果一行畅通无阻，就只计算一次，这一行有多少个E就行了
// 				用来存每一行有多少个E
                if (j == 0 || grid[i][j - 1] == 'W') {
                    rows = 0;
                    for (int k = j; k < n && grid[i][k] != 'W'; ++k)
//                     	数一下，这一行第i行在遇到W之前有多少个E
                        if (grid[i][k] == 'E')
                            rows += 1;
                }
                
                if (i == 0 || grid[i - 1][j] == 'W') {
                    cols[j] = 0;
//                     遇到墙会停止
                    for (int k = i; k < m && grid[k][j] != 'W'; ++k)
//                     	用来存每一列有多少个E
//                     	数一下，这一列第j列在遇到W之前有多少个E
                        if (grid[k][j] == 'E')
                            cols[j] += 1;
                }
				
// 				数完之后，当i j上为0时，计算一下它所在的行 列一共多少个
                if (grid[i][j] == '0' && rows + cols[j] > result)
                    result = rows + cols[j];
            }
        }
        
        return result;
    }
}

