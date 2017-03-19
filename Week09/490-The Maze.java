

//         从start出发
//             如果已经走到了desti就true
//             如果没有，就4个方向都try一下
//                 先判断一下当前点的有效性，再向别的方向走
//                 用while一直走到超出边界了,或者走到了墙
//                 如果这个到达点没有访问过
//                 就把它放入queue，当作转折点，下一次出发预备

public class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
    
        int m = maze.length, n = maze[0].length;
        boolean[][] visited = new boolean[m][n];
        int[] dx = new int[]{0, -1, 0, 1};
        int[] dy = new int[]{1, 0, -1, 0};
        
        Queue<int[]> queue = new LinkedList<>();
//         从start出发
        queue.offer(start);
        visited[start[0]][start[1]] = true;
        
        while ( !queue.isEmpty() ) {
            int[] curPos = queue.poll();
            
//             如果已经走到了desti就true
            if (curPos[0] == destination[0] && curPos[1] == destination[1]) {
                return true;
            }
            
//             4个方向都try一下
            // try four direction until it hits the wall
            for (int direction = 0; direction < 4; direction++) {
                int nx = curPos[0], ny = curPos[1];
                
//                 先判断一下当前点的有效性，再向别的方向走
//                 用while一直走到超出边界了,或者走到了墙
                while (nx >= 0 && nx < m && ny >= 0 && ny < n && maze[nx][ny] == 0) {
                    nx += dx[direction];
                    ny += dy[direction];
                }
                
//                 上一步超出边界，所以要退回来一步
                //back one step
                nx -= dx[direction];
                ny -= dy[direction];
                
//                 检查visited是以防无限循环走一条path弹来弹去
//                 如果这个到达点没有访问过
//                 就把它放入queue，当作转折点，下一次出发预备
                if ( !visited[nx][ny] ) {
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny});
                }
            }
            
        }
        
        return false;
    }
}