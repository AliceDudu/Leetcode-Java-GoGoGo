
    	minHeap相当于存储整个数组中较大的那一半数字，所以它的top就是这个大数区间里最小的
    	maxHeap相当于存储整个数组中较小的那一半数字，所以它的top就是这个小数区间里最大的
    	当两组个数一样时，这时位于两个堆的top的就是整个数组的中位数，所以取top除以2
    	当maxHeap个数多一个时，它的top就是中位数median，

public class MedianFinder {
    public class MyComparator implements Comparator<Integer>{
        @Override
        public int compare(Integer l1, Integer l2){
            return l2 - l1;
        }
    }
    
    private PriorityQueue<Integer> minHeap;
    private PriorityQueue<Integer> maxHeap;

    public MedianFinder(){
//     	minHeap相当于存储整个数组中较大的那一半数字，所以它的top就是这个大数区间里最小的
//     	maxHeap相当于存储整个数组中较小的那一半数字，所以它的top就是这个小数区间里最大的
        minHeap = new PriorityQueue<Integer>();
        maxHeap = new PriorityQueue<Integer>(new MyComparator());
    }
    
    // Adds a number into the data structure.
    public void addNum(int num) {
//     	加到maxHeap里排个序，挑个最大的
        maxHeap.offer(num);
//         max再弹出来放进min，因为min就是放大数的那一堆
        minHeap.offer(maxHeap.poll());
//         保持两组个数相等，或max比min多一个
        if(maxHeap.size() < minHeap.size()){
            maxHeap.offer(minHeap.poll());
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
//     	当两组个数一样时，这时位于两个堆的top的就是整个数组的中位数，所以取top除以2
//     	当maxHeap个数多一个时，它的top就是中位数median，
        return maxHeap.size() == minHeap.size() ? (double)(maxHeap.peek() + minHeap.peek()) / 2 : (double)maxHeap.peek();
    }
}


/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */