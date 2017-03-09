


public class NumMatrix {
    // Using 2D Binary Indexed Tree, 2D BIT Def:
    // bit[i][j] saves the rangeSum of [i-(i&-i), i] x [j-(j&-j), j]
    // note bit index == matrix index + 1
    int n, m;
    int[][] bit, a;

    public NumMatrix(int[][] matrix) {
        if (matrix.length < 1) {
        	return;
        }
        
        n = matrix.length; 
        m = matrix[0].length;
        
//         定义bit，多1个
        bit = new int[n + 1][m + 1];
//         a用来记录前一状态的matrix的值，为了计算出diff 
        a = new int[n][m];
        
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                update(i, j, matrix[i][j]);
    }

    public void update(int row, int col, int val) {
//     	计算diff
        int diff = val - a[row][col];
        a[row][col] = val;
        
//         +=，i <= n
        for (int i = row + 1; i <= n; i += i & -i)
            for (int j = col + 1; j <= m; j += j & -j)
//             	把相关的bit上累加diff
                bit[i][j] += diff;
    }

// 	计算指定区域的sum，是通过这四个区间的加减
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sum(row2, col2) + sum(row1 - 1, col1 - 1) - sum(row1 - 1, col2) - sum(row2, col1 - 1);
    }
    
//     这个和是从原点00到这一点的组成的矩形
// 	-=， i > 0
    public int sum(int row, int col) {
        int tot = 0;
        
        for (int i = row + 1; i > 0; i -= i & -i)
            for (int j = col + 1; j > 0; j -= j & -j)
                tot += bit[i][j];
                
        return tot;
    }
}