public class Solution{
	public ListNode reverseKGroup( ListNode head, int k ){
		//corner
		if ( head == null || head.next == null || k < 2 ){
			return head;
		}
		
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		
		ListNode tail = dummy;
		ListNode pre = dummy;
		ListNode temp;
		
		int count;
		
		while ( true ){
			count = k;
			
			while ( count > 0 && tail != null ){
				count--;
				tail = tail.next;
			}
			
			if ( tail == null ){
				break;
			}
			
			head = pre.next;
			
			while ( pre.next != tail ){
				temp = pre.next;
				pre.next = temp.next;
				
				temp.next = tail.next;
				tail.next = temp;
			}
			
			tail = head;
			pre = head;
		}
		
		return dummy.next;
	}
}