//bit

public class NumMatrix{

	int[][] nums;
	int[][] bit;
	int m;
	int n;

	public NumMatrix( int[][] matrix ){
		if ( matrix.length == 0 || matrix[0].length == 0 ){
			return;
		}
		
		m = matrix.length;
		n = matrix[0].length;
		
		bit = new int[m + 1][n + 1];
		nums = new int[m][n];
		
		for ( int i = 0; i < m; i++ ){
			for ( int j = 0; j < n; j++ ){
				update(i, j, matrix[i][j]);
			}
		}
	}

	public void update( int row, int col, int val ){
		if ( m == 0 || n == 0 ){									//
			return;
		}
	
		int diff = val - nums[row][col];							//
		nums[row][col] = val;
	
		for ( int i = row + 1; i <= m; i += (i & -i)  ){
			for ( int j = col + 1; j <= n; j += (j & -j) ){
				bit[i][j] += diff;
			}
		}
	}
	
	public int sumRange( int row1, int col1, int row2, int col2 ){
		if ( m == 0 || n == 0 ){
			return 0;
		}
		return getSum(row2 + 1, col2 + 1) - getSum(row1, col2 + 1) - getSum(row2 + 1, col1) + getSum(row1, col1);		//
	}
	
	public int getSum( int row, int col ){
		int sum = 0;
		
		for ( int i = row; i > 0; i -= (i & -i) ){
			for ( int j = col; j > 0; j -= (j & -j) ){
				sum += bit[i][j];		
			}
		}
		
		return sum;													//
	}

}


//segment
public class TreeNode {
	int row1, col1, row2, col2, sum;
	
	TreeNode c1, c2, c3, c4;
	
	public TreeNode ( int row1, int col1, int row2, int col2 ){
		this.row1 = row1;
		this.row2 = row2;
		this.col1 = col1;
		this.col2 = col2;
		this.sum = 0;
	}
}

public TreeNode buildTree( int[][] matrix, int row1, int col1, int row2, int col2 ){
	if ( row2 < row1 || col2 < col1 ){
		return null;
	}
	
	TreeNode node = new TreeNode(row1, col1, row2, col2);
	
	if ( row1 == row2 && col1 == col2 ){
		node.sum = matrix[row1][col1];
		return node;
	}
	
	int rowMid = row1 + (row2 - row1) / 2; 
	int colMid = col1 + (col2 - col1) / 2;
	
	node.c1 = buildTree(matrix, row1, col1, rowMid, colMid);
	node.c2 = buildTree(matrix, row1, colMid + 1, rowMid, col2);
	node.c3 = buildTree(matrix, rowMid + 1, col1, row2, colMid);
	node.c4 = buildTree(matrix, rowMid + 1, colMid + 1, row2, col2);
	
	node.sum += node.c1 != null ? node.c1.sum : 0;
	node.sum += node.c2 != null ? node.c2.sum : 0;
	node.sum += node.c3 != null ? node.c3.sum : 0;
	node.sum += node.c4 != null ? node.c4.sum : 0;
	
	return node;
}


public class NumMatrix{
	TreeNode root;

	public NumMatrix( int[][] matrix ){
		if ( matrix.length == 0 ){
			root = null;
		}else{
			root = buildTree(matrix, 0, 0, matrix.length - 1, matrix[0].length - 1);
		}
	}
	
	//update
	public void update(){
		update(root, row, col, val);
	}
	
	public void update( TreeNode root, int row, int col, int val ){
		if ( root.row1 == root.row2 && root.row1 == row && root.col1 == root.col2 && root.col1 == col ){
			root.sum = val;
			return;
		}
		
		int rowMid = root.row1 + (root.row2 - root.row1) / 2;
		int colMid = root.col1 + (root.col2 - root.col1) / 2; 
		
		TreeNode node;
		
		if ( row <= rowMid ){
			if ( col <= colMid ){
				node = root.c1;
			}else{
				node = root.c2;
			}
		}else{
			if ( col <= colMid ){
				node = root.c3;
			}else{
				node = root.c4;
			}
		}
		
		root.sum -= node.sum;		//?????为啥要先减去
		update(node, row, col, val);
		root.sum += node.sum;
	}
	
	
	//sum range
	public int sumRange( int row1, int col1, int row2, int col2 ){
		return sumRange(root, row1, col1, row2, col2);
	}
	
	public int sumRange( TreeNode root, int row1, int col1, int row2, int col2 ){
		if ( root.row1 == row1 && root.col1 == col1 && root.row2 == row2 && root.col2 == col2 ){
			return root.sum;
		}
		
		int rowMid = root.row1 + (root.row2 - root.row1) / 2;
		int colMid = root.col1 + (root.col2 - root.col1) / 2;
		
		if ( row2 <= rowMid ){
			if ( col2 <= colMid ){
				return sumRange(root.c1, row1, col1, row2, col2);
			}else if ( col1 >= colMid + 1 ){
				return sumRange(root.c2, row1, col1, row2, col2);
			}else{
				return sumRange(root.c1, row1, col1, row2, colMid) + sumRange(root.c2, row1, colMid + 1, row2, col2);		//
			}
		}else if ( row1 >= rowMid + 1 ){
			if ( col2 <= colMid ){
				return sumRange(root.c3, row1, col1, row2, col2);
			}else if ( col1 >= colMid + 1 ){
				return sumRange(root.c4, row1, col1, row2, col2);
			}else{
				return sumRange(root.c3, row1, col1, row2, colMid) + sumRange(root.c4, row1, colMid + 1, row2, col2);		//
			}
		}else{
			if ( col2 <= colMid ){
				return sumRange(root.c1, row1, col1, rowMid, col2) + sumRange(root.c3, rowMid + 1, col1, row2, col2);
			}else if ( col1 >= colMid + 1 ){
				return sumRange(root.c2, row1, col1, rowMid, col2) + sumRange(root.c4, rowMid + 1, col1, row2, col2);
			}else{
				return sumRange(root.c1, row1, col1, rowMid, colMid) + sumRange(root.c2, row1, colMid + 1, rowMid, col2)
					+sumRange(root.c3, rowMid + 1, col1, row2, colMid) + sumRange(root.c4, rowMid + 1, colMid + 1, row2, col2);		//
			}
		}
	}
}







