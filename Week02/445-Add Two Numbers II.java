public class Solution{
	public ListNode addTwoNumbers(ListNode l1, ListNode l2){
	
		if ( l1 == null )
			return l2;
		if ( l2 == null )
			return l1;
	
		Deque<Integer> stack1 = new ArrayDeque<>();
		Deque<Integer> stack2 = new ArrayDeque<>();
		
		while ( l1 != null ){
			stack1.push(l1.val);
			l1 = l1.next;
		}
		
		while ( l2 != null ){
			stack2.push(l2.val);
			l2 = l2.next;
		}
		
		ListNode res = new ListNode(0);
		int sum = 0;
		
		while ( !stack1.isEmpty() || !stack2.isEmpty() ){
			if ( !stack1.isEmpty() )
				sum += stack1.pop();
			if ( !stack2.isEmpty() )
				sum += stack2.pop();
			
			res.val = sum % 10;
			ListNode head = new ListNode( sum / 10 );
			head.next = res;
			res = head;
			sum = sum / 10;
		}
		
		return res.val == 0 ? res.next : res;
	}
}