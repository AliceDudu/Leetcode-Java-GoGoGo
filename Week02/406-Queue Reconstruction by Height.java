


public class Solution {

    class PairComp implements Comparator<int[]> {
        public int compare(int[] p1, int[] p2){
            int comp_h = Integer.compare(p2[0], p1[0]);	 //p1在后面
            
            if ( comp_h == 0 ){		//二者第一位相等时
            	return Integer.compare(p1[1], p2[1]);	//就去比较第二位，p1在前面
            }else{
            	return comp_h;
            }
            
        }
    }
    
    public int[][] reconstructQueue(int[][] people) {   
        LinkedList<int[]> list = new LinkedList();
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(1, new PairComp() );
        
//         最后排成什么样了？
        for ( int[] ppl: people ){
            queue.offer( ppl );
        }
        
        while ( ! queue.isEmpty() ) {
            int[] pair = queue.poll();
            list.add(pair[1], pair);
        }
        
        
//         获取结果
        int[][] ret = new int[people.length][];
        
        for (int i = 0; i < list.size(); i++){
            ret[i] = list.get(i);
        }
        
        return ret;
    }
}