能装水的底面肯定不能在边界上，因为边界上的点无法封闭，那么所有边界上的点都可以加入queue，当作BFS的启动点，
同时需要一个二维数组来标记访问过的点

周围的高度都应该比当前的高度高，形成一个凹槽才能装水，而且装水量取决于周围最小的那个高度
BFS遍历的时候就需要从高度最小的格子开始遍历，所以要使用优先级队列，将高度小的放在队首，最先取出

向周围BFS搜索的条件是不能越界，且周围格子未被访问
将这样的未被访问过的格子，加入优先队列queue中，然后标记为已访问

优先队列queue中高度为1的格子遍历完了，此时海平面上升1，变为2，遍历优先队列queue中高度为2的格子
海平面继续上升，变为4，遍历所有高度为4的格子

这时周围有灰格子可以遍历，且高度比海平面低了，可以存水了，把存水量算出来加入结果res中
加完水后，遍历到的格子会被加入优先队列queue中，由于它们的高度小，所以下一次从优先队列queue中取格子时，它们会被优先遍历到，

接着就从刚加过水的格子进行BFS搜索，就会遍历到其左边的那个灰格子，由于其高度小于海平面，也可以存水，将存水量算出来加入结果res中

等遍历结束了，它们会被标记为红色，加完水的格子遍历会先被标记红色，然后加入优先队列queue中，由于其周围格子全变成标记过了，所有不会有任何操作

此时所有的格子都标记为已访问了，海平面继续上升，继续遍历完优先队列queue中的格子，
不过已经不会对结果有任何影响了，因为所有的格子都已经访问过了，此时等循环结束后返回res即可

public class Solution{

	public class Cell{
		int row;
		int col;
		int height;

		public Cell( int row, int col, int height ){
			this.row = row;
			this.col = col;
			this.height = height;
		}
	}
	
	public int trapRainWater( int[][] heightMap ){
		if ( heightMap == null || heightMap.length == 0 || heightMap[0].length == 0 ){
			return 0;
		}
		
		PriorityQueue<Cell> queue = new PriorityQueue<>(1, new Comparator<Cell>(){
			public int compare( Cell a, Cell b ){
				return a.height - b.height;
			}
		});
		
		int m = heightMap.length;
		int n = heightMap[0].length;
		boolean[][] visited = new boolean[m][n];
		
		for ( int i = 0; i < m; i++ ){
			visited[i][0] = true;
			visited[i][n - 1] = true;
			queue.offer(new Cell(i, 0, heightMap[i][0]));
			queue.offer(new Cell(i, n - 1, heightMap[i][n - 1]));
		}
		
		for ( int i = 0; i < n; i++ ){
			visited[0][i] = true;
			visited[m - 1][i] = true;
			queue.offer(new Cell(0, i, heightMap[0][i]));
			queue.offer(new Cell(m - 1, i, heightMap[m - 1][i]));
		}
		
		int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
		int res = 0;
		
		while ( !queue.isEmpty() ){
			Cell cell = queue.poll();
			
			for ( int[] dir : dirs ){
				int row = cell.row + dir[0];
				int col = cell.col + dir[1];
				
				if ( row >= 0 && row < m && col >= 0 && col < n && !visited[row][col] ){
					visited[row][col] = true;
					res += Math.max(0, cell.height - heightMap[row][col]);
					queue.offer(new Cell(row, col, Math.max(heightMap[row][col], cell.height)));
				}
			}
		}
		
		return res;
		
	}
}