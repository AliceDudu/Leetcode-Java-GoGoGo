public class Solution {
	public ListNode deleteDuplicates(ListNode head){
		if ( head == null || head.next == null )
			return head;
		
		ListNode slow = head;
		ListNode fast = head.next;
		
		while ( fast != null ){
			if ( slow.val != fast.val ){
				slow = slow.next;
				fast = fast.next;
			}else{
				while ( fast != null && fast.val == slow.val ) 	//ok-fast null val
					fast = fast.next;
				
				slow.next = fast;
				
				if ( fast != null ){
					slow = slow.next;
					fast = fast.next;
				}
			}
		}
		
		return head;
		
		
	}
}

