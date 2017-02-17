// multi end BFS
先把 m＊n 遍历一遍，把所有0加入到queue中
把0一个一个弹出
对每个0，都向四周走一步，遇到inf，就将其赋值为0+1，并把这个点加入到queue中，下一层走它们
走完0后，走1，仍然是向四周走一步，遇到inf，赋值为1+1，加入queue。。。
对于不是inf的，除了wall以外，就曾经是inf，说明已经在之前被某个gate赋值过了，就不用管他们了


public class Solution{
	public void wallsAndGrates( int[][] rooms ){
		if ( rooms == null || rooms.length == 0 || rooms[0] == null || rooms[0].length == 0 ){
			return;
		}
		
		Deque<int[]> queue = new LinkedList<int[]>();
		
		for ( int i = 0; i < rooms.length; ++i ){
			for ( int j = 0; j < rooms[0].length; ++j ){
				if ( rooms[i][j] == 0 ){
					queue.offerLast(new int[]{i, j});
				}
			}
		}
		
		multiEndBFS(queue, rooms);
	}
	
	public void multiEndBFS( Deque<int[]> queue, int[][] rooms ){
		int row = rooms.length;
		int col = rooms[0].length;
		
		while ( !queue.isEmpty() ){
			int[] cur = queue.pollFirst();
			int x = cur[0];
			int y = cur[1];
			
			if ( isValid(x + 1, y, row, col) && rooms[x + 1][y] == Integer.MAX_VALUE ){
				rooms[x + 1][y] = rooms[x][y] + 1;
				queue.offerLast(new int[]{x + 1, y});
			}
			
			if ( isValid(x, y + 1, row, col) && rooms[x][y + 1] == Integer.MAX_VALUE ){
				rooms[x][y + 1] = rooms[x][y] + 1;
				queue.offerLast(new int[]{x, y + 1});
			}
			
			if ( isValid(x - 1, y, row, col) && rooms[x - 1][y] == Integer.MAX_VALUE ){
				rooms[x - 1][y] = rooms[x][y] + 1;
				queue.offerLast(new int[]{x - 1, y});
			}
			
			if ( isValid(x, y - 1, row, col) && rooms[x][y - 1] == Integer.MAX_VALUE ){
				rooms[x][y - 1] = rooms[x][y] + 1;
				queue.offerLast(new int[]{x, y - 1});
			}
	
		}
	}
	
	public boolean isValid( int x, int y, int row, int col ){
		return x >= 0 && y >= 0 && x < row && y < col;
	}
}