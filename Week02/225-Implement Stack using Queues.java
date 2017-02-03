class MyStack{

	//stack = [1,2,3]
	//queue = [3,2,1]
 // please use queue
	Deque<Integer> queue = new ArrayDeque<>();

	public void push(int x){
		queue.add(x);
		for ( int i = 0; i < queue.size() - 1; i++ )
			queue.add( queue.poll() );
	}

	public void pop(){
		queue.poll();
	}

	public int top(){
		return queue.peek();
	}

	public boolean empty(){
		return queue.isEmpty();
	}

}
