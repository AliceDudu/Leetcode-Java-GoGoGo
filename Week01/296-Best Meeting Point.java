
 solution was using median to get shortest meeting point
 Let's think about simple cases in one dimension first:

house location: [1,6] -> best point can be anywhere between 1~6
house location: [1,2,6] -> best point is 2, because 1 and 6 don't care where it is as long as the point is between them
house location: [1,2,3,6] -> best point is 2.5(actually 2 or 3)
For a sequence [a1, a2 ... an], dist(a1,bestPoint)+dist(an,bestPoint) is constant and equal to dist(a1,an)

把有1的横坐标，纵坐标分别存起来
排序
两边做差，同时移动，累加

public int minTotalDistance(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;
    
    List<Integer> I = new ArrayList<>(m);
    List<Integer> J = new ArrayList<>(n);
    
//     把有1的横坐标，纵坐标分别存起来
    for(int i = 0; i < m; i++){
        for(int j = 0; j < n; j++){
            if(grid[i][j] == 1){
                I.add(i);
                J.add(j);
            }
        }
    }
    
    return getMin(I) + getMin(J);
}

private int getMin(List<Integer> list){
    int ret = 0;
    
//     排序
    Collections.sort(list);
    
    int i = 0;
    int j = list.size() - 1;
    
//     两边做差，同时移动
    while(i < j){
        ret += list.get(j--) - list.get(i++);
    }
    
    return ret;
}