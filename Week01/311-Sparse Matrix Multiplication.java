
c的每个元素i j等于这两个的乘积，再遍历k求和
C[i][j] += A[i][k] * B[k][j];
所以不稀疏的话，需要这两个都不是0的时候，在做乘法有意义


public class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int m = A.length, n = A[0].length, nB = B[0].length;
        int[][] C = new int[m][nB];

        for(int i = 0; i < m; i++) {
            for(int k = 0; k < n; k++) {
            
                if (A[i][k] != 0) {
                
                    for (int j = 0; j < nB; j++) {
                    
                        if (B[k][j] != 0) {
//                         	c的每个元素i j等于这两个的乘积，再遍历k求和
//                         	所以不稀疏的话，需要这两个都不是0的时候，在做乘法有意义
                        	C[i][j] += A[i][k] * B[k][j];
                        }
                        
                    }
                    
                }
                
            }
        }
        
        return C;   
    }
}