

把start和stop都分别取出来，分别排序
可以看成start是从小到大，以这个顺序为准
如果没有重叠的话，那么这个顺序的区间的相应的end的顺序，和start的顺序是一样的
并且begin[i] 还会大于 区间 i－1 的end
但是如果是小于的话，就说明有重叠

public boolean canAttendMeetings(Interval[] intervals) {
        int len = intervals.length;
        
        if(len == 0){
            return true;
        }
        
        int[] begin = new int[len];
        int[] stop = new int[len];
        
//         把start和stop都分别取出来
        for(int i = 0; i < len; i++){
            begin[i] = intervals[i].start;
            stop[i] = intervals[i].end;
        }
        
//         分别排序
        Arrays.sort(begin);
        Arrays.sort(stop);
        
        int endT = 0;
        
        for(int i = 1; i < len; i++){
//         	可以看成start是从小到大，以这个顺序为准
//         	如果没有重叠的话，那么这个顺序的区间的相应的end的顺序，和start的顺序是一样的
//         	并且begin[i] 还会大于 区间 i－1 的end
//         	但是如果是小于的话，就说明有重叠
            if(begin[i] < stop[i - 1]){
                return false;
            }
        }
        
        return true;
}