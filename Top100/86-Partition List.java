public class Solution {
	public ListNode partition(ListNode head, int x){
		if ( head == null || head.next == null )
			return head;
		
		ListNode smallDummy = new ListNode(0);
		ListNode largeDummy = new ListNode(0);
		ListNode smallPre = smallDummy;
		ListNode largePre = largeDummy;
		
		while ( head != null ){
			if ( head.val < x ){
				smallPre.next = head;
				smallPre = smallPre.next;
			}else{
				largePre.next = head;
				largePre = largePre.next;
			}
			
			head = head.next;
			
		}
		
		largePre.next = null;
		smallPre.next = largeDummy.next;
		
		return smallDummy.next;
		
	}
}



// public class PartitionSolution {
// 	public ListNode partition(ListNode head, int x){
// 		
// 		if ( head == null || head.next == null )
// 			return head;
// 		
// 		ListNode dummy = new ListNode(-1);
// 		dummy.next = head;
// 		
// 		ListNode small = dummy;
// 		ListNode cur = head;
// 		ListNode pre = dummy;
// 		
// // 		while ( cur != null ){				//[1,1] 用此代码跑，small一直前进，cur和pre未前进
// // 			if ( cur.val >= x ){
// // 				cur = cur.next;
// // 				pre = pre.next;
// // 			}else{
// // 				pre.next = cur.next;
// // 				cur.next = small.next;
// // 				small.next = cur;
// // 				cur = pre.next;
// // 				
// // 				small = small.next;
// // 			}
// // 		}
// 
// // Input:
// // [1,1]
// // 2
// // Output:
// // []
// // Expected:
// // [1,1]
// 		
// 		return dummy.next;
// 	}
// }