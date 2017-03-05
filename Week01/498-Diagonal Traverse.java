

想要一步一步按照这个规则走遍matrix
得有起点，定了00
得有方向，每个点有两个选择，右上方，左下方
需要变换方向，得确定转折点：有四种情况，row < 0，col < 0，row >= m，col >= n
所以就是，在矩阵内并且在一条线上时，就是取值，然后移动步伐
到了转折点，就变换方向，和下一条路线的起点
再继续走，继续取值

public class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
        	return new int[0];
        }
        int m = matrix.length;
        int n = matrix[0].length;
        
        int[] result = new int[m * n];
        
        int row = 0, col = 0;
//         因为是沿着对角线走，看图，发现，每个点可以有两个方向的选择，
//         一个是右上方，即row－1，col＋1
//         一个是左下方，即row＋1，col－1
// 			dirs就代表这两个方向
        int[][] dirs = {{-1, 1}, {1, -1}};
// 			00出发时，第一个方向是右上方，所以d初始化为0
        int d = 0;
        
        for (int i = 0; i < m * n; i++) {
            result[i] = matrix[row][col];
//             沿着当前方向一个一个走，一个一个加入到res中
            row += dirs[d][0];
            col += dirs[d][1];
            
//             这4个if是当row和col超过边界时，就要变换方向了
// 			此时走到了底边的左下方，col＋2，row变成最底边，变换方向
            if (row >= m) { 
            	row = m - 1; 
            	col += 2; 
            	d = 1 - d;
            }
//             此时走到了matrix右上角的右上方了，此时row＋2，col变成最右边，变换方向
            if (col >= n) { 
            	col = n - 1; 
            	row += 2; 
            	d = 1 - d;
            }
//             起点00出发后，row小于0了，方向变为左下方走，起点向直下方移动一位到matrix里面
// 				此if后，row＝0，d＝1，col＝1
            if (row < 0)  { 
            	row = 0; 
            	d = 1 - d;
            }
//             走到matrix的左下角的左边，冒出去了，向右方移动一位进入matrix，方向变换成右上方
            if (col < 0)  { 
            	col = 0; 
            	d = 1 - d;
            }
        }
        
        return result;
    }
}