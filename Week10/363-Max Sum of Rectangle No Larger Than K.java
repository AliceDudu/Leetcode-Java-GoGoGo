

save every sum of 0~i(0<=i<len) and binary search previous sum to find 
    possible result for every index, time complexity is O(NlogN).
    so in 2D matrix, we can sum up all values from row i to row j and create a 1D array 
    to use 1D array solution.
    
array里，每个位置相当于每一列的累加
val，相当于把每个位置前的所有列累加，即它是一个矩形的和
set里，存的是val，即i行n列这个矩形里，包含左上角的所有矩形的和的集合，subres也在res里面取，res = Math.max(res, val - subres)所以res也相当于是set里取的
for(int i = 0; i < m; i++)：相当于在限制矩形的外沿
for(int j = i; j >= 0; j--)：相当于在计算这个外沿矩形中任意矩形的和（看代码是只有必含左上角的，没看到不包含的）
for(int k = 0; k < n; k++)：j和k共同形成了外沿矩形内部的任意矩形
subres = set.ceiling(val - target) 和 res = Math.max(res, val - subres)：相当于 res <= target
最后返回的就是这个res

public class Solution {
    public int maxSumSubmatrix(int[][] matrix, int target) {
    	int row = matrix.length;
    	if(row == 0){
    		return 0;
    	}
    	
    	int col = matrix[0].length;
    	int m = Math.min(row, col);
    	int n = Math.max(row, col);
    	
    //indicating sum up in every row or every column
    	boolean colIsBig = col > row;
    	int res = Integer.MIN_VALUE;
    	
//     	m是row和col最小的
    	for(int i = 0; i < m; i++){
//     		i更新了，array就会初始化
        	int[] array = new int[n];
        // sum from row j to row i
//         	col>row, j is row, k is col, otherwise, reverse j k
// 			j更新了，val，set，subres就会初始化
// 			不过res是在i和j外面的，是个全局最大值
        	for(int j = i; j >= 0; j--){
            	int val = 0;
            	
            	TreeSet<Integer> set = new TreeSet<Integer>();
            	set.add(0);
            //traverse every column/row and sum up
            	for(int k = 0; k < n; k++){
                	array[k] = array[k] + (colIsBig ? matrix[j][k] : matrix[k][j]);
                	val = val + array[k];
                //use  TreeMap to binary search previous sum to get possible result 
                	Integer subres = set.ceiling(val - target);
                	
                	if(null != subres){
                    	res = Math.max(res, val - subres);
                	}
                	
                	set.add(val);
            	}
        	}
    	}
    	return res;
	}
}