/*
题目链接: https://leetcode.com/problems/plus-one-linked-list/

Given a non-negative number represented as a singly linked list of digits, plus one to the number.

The digits are stored such that the most significant digit is at the head of the list.

Example:
Input:
1->2->3

Output:
1->2->4
*/

public class PlusOneListSolution {
	public ListNode plusOne(ListNode head){
		//corner case
		if ( head == null )
			return null;
			
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		
		ListNode newHead = reverseList(head);
		
		ListNode cur = newHead;
		
		while ( cur.next != null ){
// 			int carry = 0;
			int sum = cur.val + 1;
			if ( sum < 10 ){
				cur.val += 1;
				// reverse
				ListNode finalHead = reverseList(newHead);
				return finalHead;
			}else{
				cur.val = 0;
// 				carry = 1;				
			}
			cur = cur.next;
		}
		
// 		if ( carry == 1 ){
		ListNode tail = new ListNode(1);
		dummy.next.next = tail;
// 		}
		
		ListNode finalHead = reverseList(newHead);
		
		return finalHead;
			
	}
	
	
	
	public ListNode reverseList(ListNode head){
		if ( head == null || head.next == null )
			return head;
			
		ListNode pre = null;
		ListNode cur = head;
		
		while ( cur != null ){
			ListNode tmp = cur.next;
			cur.next = pre;
			pre = cur;
			cur = tmp;
		}
		
		return pre;		
	}
	
}
