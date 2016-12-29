public class MovingAverage{
	Deque<Integer> queue;
	int sum;
	int windowSize;
	double average;
	
	/** Initialize your data structure here. */
	public MovingAverage(int size){
		queue = new ArrayDeque<>();
		windowSize = size;
		sum = 0;
		average = 0;
	}
	
	public double next(int val){
		queue.offer(val);
		sum += val;
			
		if ( queue.size() <= windowSize ){
			average = (double)sum / queue.size();
		}else{
			int headval = queue.poll();
			sum -= headval;
			average = (double)sum / windowSize;
		}
		return average;
	}	
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */