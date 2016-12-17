public class Solution {
	public ListNode rotateRight(ListNode head, int k){
		//corner case
		if ( head == null || head.next == null || k == 0 )
			return head;
			
			
		//core logic
		int list_size = 0;
		ListNode cur = head;
		while ( cur != null ){
			cur = cur.next;
			list_size++;
		}
		
		
		int k_remain = k % list_size;
		
		if ( k_remain == 0 )
			return head;
		
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		
		ListNode slow = head;	// make fast the end of ruler
		ListNode fast = head;
		while ( k_remain > 1 ){
			fast = slow.next;
			slow = fast;
			k_remain--;
		}
		
		slow = head;			// find the right－k nodes
		ListNode pre = dummy;
		while ( fast.next != null ){
			slow = slow.next;
			fast = fast.next;
			pre = pre.next;
		}
		
// 		dummy.next = slow;
		fast.next = head;
		pre.next = null;
		
		return slow;		
		
	}
}