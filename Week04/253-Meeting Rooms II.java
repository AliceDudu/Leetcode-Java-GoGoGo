
按start给区间排序  
minheap顶存的是最小的end，说明结束的最早
把最早结束的弹出来，与当前区间比较
如果相交，就把这个区间加到heap里去
如果不相交，就把这两个区间合并
don't forget to put the meeting room back
heap里存的区间数，即heap的size，也就是相交的区间数，即要定的room数

public int minMeetingRooms(Interval[] intervals) {
    if (intervals == null || intervals.length == 0)
        return 0;
      
//     按start给区间排序  
    // Sort the intervals by start time
    Arrays.sort(intervals, new Comparator<Interval>() {
        public int compare(Interval a, Interval b) { return a.start - b.start; }
    });
    
//     heap顶存的是最小的end，说明结束的最早
//     heap里存的区间数，即heap的size，也就是相交的区间数，即要定的room数
    // Use a min heap to track the minimum end time of merged intervals
    PriorityQueue<Interval> heap = new PriorityQueue<Interval>(intervals.length, new Comparator<Interval>() {
        public int compare(Interval a, Interval b) { return a.end - b.end; }
    });
    
    // start with the first meeting, put it to a meeting room
    heap.offer(intervals[0]);
    
    for (int i = 1; i < intervals.length; i++) {
//     	把最早结束的弹出来
        // get the meeting room that finishes earliest
        Interval interval = heap.poll();
        
//         如果不相交，就把这两个区间合并
        if (intervals[i].start >= interval.end) {
            // if the current meeting starts right after 
            // there's no need for a new room, merge the interval
            interval.end = intervals[i].end;
//         如果相交，就把这个区间加到heap里去
        } else {
            // otherwise, this meeting needs a new room
            heap.offer(intervals[i]);
        }
        
        // don't forget to put the meeting room back
        heap.offer(interval);
    }
    
    return heap.size();
}