public class Solution{
	public ListNode reverseBetween(ListNode head, int m, int n){
		
		if ( head == null || head.next == null || m == n )
			return head;
		
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		
		ListNode slow = dummy;
		ListNode fast = dummy;
		
		//locate slow.next=m & fast=n
		while ( m > 1){
			slow = slow.next;
			fast = fast.next;
			m -= 1;
			n -= 1;
		}
		
		while ( n > 0 ){
			fast = fast.next;
			n -= 1;
		}
		
		
		//reverse m~n		
		ListNode cur = slow.next;
		slow.next = fast;
		ListNode pre = fast.next;
		
		while ( cur != fast ){
			ListNode forward = cur.next;
			cur.next = pre;
			pre = cur;
			cur = forward;
		}
		cur.next = pre;
		
		return dummy.next;

	}
	

}