class MyQueue{
  //  please use stack
	Deque<Integer> stack = new ArrayDeque<>();

	//queue = [1,2,3]
	//stack = [3,2,1]

	public void push(int x){
		Deque<Integer> temp = new ArrayDeque<>();

		while ( !stack.isEmpty() )
			temp.push( stack.pop() );

		stack.push(x);

		while ( !temp.isEmpty() )
			stack.push( temp.pop() );

	}

	public void pop(){
		stack.pop();
	}

	public int peek(){
		return stack.peek();
	}

	public boolean empty(){
		return stack.isEmpty();
	}

}
