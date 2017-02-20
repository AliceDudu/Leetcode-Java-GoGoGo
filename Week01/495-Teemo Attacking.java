


从起点开始，先计算出一个end
从第二个位置开始遍历
如果这个位置位于end前面，那么就更新新的end＝当前点＋dura
如果这个位置位于end后面，那么res先加上end－start，再把start更新，end也更新
最后的res再加上最后一段end－start

public class Solution {
    public int findPosisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries == null || timeSeries.length == 0 || duration == 0){
        	return 0;
        }
        
        int res = 0;
        int start = timeSeries[0];
        int end = timeSeries[0] + duration;
        
        for( int i = 1; i < timeSeries.length; i++ ){
            if( timeSeries[i] > end ){
                res += end - start;
                start = timeSeries[i];
            }
            end = timeSeries[i] + duration;
        }
        
        res += end - start;
        
        return res;
    }
}