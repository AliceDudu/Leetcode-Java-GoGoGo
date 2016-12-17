public class Solution {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2){
	
		//corner case
		if ( l1 == null )
			return l2;
		if ( l2 == null )
			return l1;
		
		//core	
		ListNode dummy = new ListNode(-1);
		
		if ( l1.val < l2.val ){
			dummy.next = l1;
		}else{
			dummy.next = l2;
		}
		
		ListNode pre = dummy;
		
		while ( l1 != null && l2 != null ){		//together
			if ( l1.val < l2.val ){
				pre.next = l1;
				pre = l1;
				l1 = l1.next;
				
			}else{
				pre.next = l2;
				pre = l2;
				l2 = l2.next;
			}
		}
		
		if ( l1 == null && l2 != null ){		//one is longer
			pre.next = l2;
		}else if( l1 != null && l2 == null ){
			pre.next = l1;
		}
		
		return dummy.next;
		

		
		
	}
}