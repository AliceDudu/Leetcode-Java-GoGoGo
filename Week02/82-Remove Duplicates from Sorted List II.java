public class Solution{
	public ListNode deleteDuplicates(ListNode head){
		if ( head == null || head.next == null )
			return head;
		
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		
		ListNode pre = dummy;
		ListNode cur = head;
		ListNode forward = head.next;
		
		while ( forward != null ){
			if ( cur.val != forward.val ){
				forward = forward.next;
				cur = cur.next;
				pre = pre.next;
			}else{
				while ( forward != null && cur.val == forward.val ){
					forward = forward.next;
				}
				
				pre.next = forward;
				cur = forward;
				
				if ( forward != null ){
					forward = forward.next;
				}
				
			}
		}
		
		return dummy.next;
	}
}