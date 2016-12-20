public class Solution {
	public ListNode removeNthFromEnd(ListNode head, int n){
		//corner case
		//length==1, n==1
		if ( head == null || head.next == null )					//'n will always be valid.' mean 1<= n <= length?
			return null;
			
		//core logic
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		
		ListNode slow = dummy;				// slow is the node just before the one to delete, no need to set pre
		ListNode fast = dummy;
// 		ListNode pre = dummy;
		
// 		int i = n - 1;
		
		while ( n >= 1 ){					// slow + n_step = fast
			fast = fast.next;
			n--;
		}
		
		while ( fast.next != null ){
			fast = fast.next;
			slow = slow.next;
// 			pre = pre.next;
		}
		
// 		slow.next = fast;					// when n==1, fast is the one to be deleted
		slow.next = slow.next.next;
		return dummy.next;
		
	}
}