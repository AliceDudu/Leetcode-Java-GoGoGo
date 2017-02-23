为什么我跑这个例子，感觉start点会重复被加入呢？
并不会，因为 len >= dis[nextX][nextY] 时，就跳过忽略，不用加到q里，而start的len＝0

与一般bfs的区别：别的是临近的一个ok，就可以加入到queue里，此题时，ok了还要继续走

题意：给个起点，终点，如果从起点出发能走到终点，就返回所有path的最短的距离，
如果走不到终点，就返回－1

从起点出发，包括从任何一点再次出发，都可以向四个方向走
选定某一个方向后，一直沿着这个方向走，直到最后一个点是墙

每个point自带一个变量len，用来记录从起点到这一点，各种长度中最短的长度：
所以每次当遇到 len < dis[nextX][nextY] 时，就把当前 dis[nextX][nextY] = len 更新到最小path

dis x y 是用来记录走到此点挺住时，走过的最短步长
初始化为 Integer.MAX_VALUE)

queue 用来存放可以停住的点，即转折点，
然后可以一个一个弹出，每一个弹出时，都可以重新选择方向


public class Solution{
	public int shorestDistance( int[][] maze, int[] start, int[] destination ){
			
		int[][] dir = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
		
		Deque<Point> queue = new ArrayDeque<Point>();		
		queue.offerLast(new Point(start[0], start[1], 0));
		
		int[][] dis = new int[m][n];			//dis x y 是用来记录走到此点挺住时，走过的最短步长		
		for ( int i = 0; i < m; i++ ){
			Arrays.fill(dis[i], Integer.MAX_VALUE);
		}
		
		while ( !queue.isEmpty() ){
			Point cur = queue.pollFirst();
						
			for ( int[] d : dir ){			//从起点出发，包括从任何一点再次出发，都可以向四个方向走
				int nextX = cur.x;
				int nextY = cur.y;
				int len = cur.len;
				
				//选定某一个方向后，一直沿着这个方向走，直到最后一个点是墙
				while ( isValid(nextX, nextY, m, n, maze) ){
					nextX += d[0];
					nextY += d[1];
					len++;
				}
				
				//最后一个点是碰到墙了，退回来
				nextX -= d[0];
				nextY -= d[1];
				len--;
				
				if ( len > dis[destination[0]][destination[1]] ){
					continue;
				}
				
				//len >= dis[nextX][nextY] 时，就跳过忽略，不用加到q里，
				if ( len < dis[nextX][nextY] ){
					dis[nextX][nextY] = len;
					queue.offerLast(new Point(nextX, nextY, len));
				}
			}
		}
		
		if ( dis[destination[0]][destination[1]] == Integer.MAX_VALUE ){
			return -1;
		}else{
			return dis[destination[0]][destination[1]];
		}
	}
	
	public boolean isValid( int x, int y, int m, int n ){
		return x >= 0 && y >= 0 && x < m && y < n && maze[x][y] == 0;
	}
	
	class Point{
		int x;
		int y;
		int len;
		
		public Point( int x, int y, int len ){
			this.x = x;
			this.y = y;
			this.len = len;
		}
	}
}



