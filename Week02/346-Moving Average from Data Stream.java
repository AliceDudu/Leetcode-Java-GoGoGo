用一个q来模拟window
遇到一个值，先加入到queue中，并加入到sum里
queue的大小小于等于window的时候，直接求和，除以现有的个数
q的大小超过window的时候，把head弹出，sum减去head的值，再做平均值
返回平均值

//week-02
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
// 		用一个q来模拟window
// 		遇到一个值，先加入到queue中，并加入到sum里
		queue.offer(val);
		sum += val;
		
// 		queue的大小小于等于window的时候，直接求和，除以现有的个数
		if ( queue.size() <= windowSize ){
			average = (double)sum / queue.size();
// 		q的大小超过window的时候，把head弹出，sum减去head的值，再做平均值
		}else{
			int headval = queue.poll();
			sum -= headval;
			average = (double)sum / windowSize;
		}
// 		返回平均值
		return average;
	}	
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
