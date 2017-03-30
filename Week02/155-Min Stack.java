public class MinStack{
// 	push，pop，top都可以直接用stack的本身的函数，即oriStack负责这三个
// 	但是getMin需要构造，所以需要minStack辅助
// 	minStack的peek就是要返回最小值
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
// 		x小于目前为止的peek时，才放到最后
		if ( minStack.isEmpty() || x <= minStack.peek() )
			minStack.push(x);
	}
	
	public void pop(){
		int val = oriStack.peek();
		oriStack.pop();
		// same time: maintain min stack
// 		如果当前ori弹出的是目前为止最小的，那么min也要弹出来，不是的话就不用弹了
		if ( !minStack.isEmpty() && val == minStack.peek() )
			minStack.pop();
	}
	
	public int top(){
		return oriStack.peek();
	}
	
// 	最小值就是直接提取minstack的peek
	public int getMin(){
	   if ( !minStack.isEmpty() )
	        return minStack.peek();
	   else
	        return 0;
	}
		
}