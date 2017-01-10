//iteration
public class Solution{
	public ListNode reverseList(ListNode head){
		//corner
		if ( head == null || head.next == null ){
			return head;
		}
		
		ListNode pre = null;
		ListNode cur = head;

		while ( cur != null ){
			//reverse
			ListNode nextone = cur.next;
			cur.next = pre;
			//prepare
			pre = cur;
			cur = nextone;
		}
		
		return pre;
	}
}

//recursion
public class Solution{
	public ListNode reverseList(ListNode head){
		//corner
		if ( head == null || head.next == null ){
			return head;
		}
		
		ListNode pre = null;
		
		return helper(head, pre);
	}
	
	public ListNode helper(ListNode cur, ListNode pre){
		//base
		if ( cur == null ){
			return pre;
		}
		
		//current
		ListNode nextone = cur.next;
		cur.next = pre;
		
		//next
		return helper(nextone, cur);
	}
}