定义一个二维dp矩阵
维度为 [s1.length() + 1][s2.length() + 1]
每个dp ij 代表：s1到i && s2到j，这些字母构成的一个整体是否与s3到i+j－1处的组成匹配
初始化  matrix[0][0] = true
初始化 第一列，即无视s2，s1到相应位置的段落是否等于s3相应位置的段落
同理初始化第一行
eg，matrix 1 1看的是，最后一个字母可以从s1也可以从s2中取，
如果倒数第一个字母是从s1中选，那么除了对比s1的i－1与s3的i+j-1，同时还要看matrix[i－1][j]
同理。。s2.。。matrix[i][j－1]
即每一个点，向上向左看
最后返回矩阵右下角


 
public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {

    	if ( (s1.length() + s2.length()) != s3.length() ){
    		return false;
    	}

    	boolean[][] matrix = new boolean[s1.length() + 1][s2.length() + 1];

    	matrix[0][0] = true;

    	for ( int j = 1; j < matrix[0].length; j++ ){
        	matrix[0][j] = matrix[0][j - 1] && (s2.charAt(j - 1) == s3.charAt(j - 1));
    	}

    	for (int i = 1; i < matrix.length; i++){
        	matrix[i][0] = matrix[i - 1][0] && (s1.charAt(i - 1)==s3.charAt(i - 1));
    	}

    	for (int i = 1; i < matrix.length; i++){
        	for (int j = 1; j < matrix[0].length; j++){
            	matrix[i][j] = (matrix[i - 1][j] && (s1.charAt(i - 1) == s3.charAt(i + j - 1)))
                    	|| (matrix[i][j - 1] && (s2.charAt(j - 1) == s3.charAt(i + j - 1)));
        	}
    	}

    	return matrix[s1.length()][s2.length()];

	}
} 