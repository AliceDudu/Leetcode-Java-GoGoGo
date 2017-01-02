public class MinStack{

	Deque<Integer> oriStack;
	Deque<Integer> minStack;

	public MinStack(){
// 		ArrayDeque<Integer> oriStack = new ArrayDeque<>();
// 		ArrayDeque<Integer> minStack = new ArrayDeque<>();
		oriStack = new ArrayDeque<>();
		minStack = new ArrayDeque<>();
	}
	
	public void push(int x){
		oriStack.push(x);
		// same time: maintain min stack
		if ( minStack.isEmpty() || x <= minStack.peek() )
			minStack.push(x);
	}
	
	public void pop(){
		int val = oriStack.peek();
		oriStack.pop();
		// same time: maintain min stack
		if ( !minStack.isEmpty() && val == minStack.peek() )
			minStack.pop();
	}
	
	public int top(){
		return oriStack.peek();
	}
	
	public int getMin(){
	   if ( !minStack.isEmpty() )
	        return minStack.peek();
	   else
	        return 0;
	}
		
}