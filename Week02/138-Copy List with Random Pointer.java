/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */


public class Solution{
	public RandomListNode copyRandomList(RandomListNode head){
	
		if ( head == null )
			return head;
		
		Map<RandomListNode, RandomListNode> map = new HashMap<>();
		
		RandomListNode cur = head;
		
		
		while ( cur != null ){
		
			// copy cur
			if ( !map.containsKey(cur) ){
				RandomListNode curCopy = new RandomListNode(cur.label);
				map.put(cur, curCopy);
			}
		
			// copy cur.next
			if ( cur.next != null && !map.containsKey(cur.next) ){
				RandomListNode nextCopy = new RandomListNode(cur.next.label);
				map.put(cur.next, nextCopy);
			}
			
			// copy cur.random
			if ( cur.random != null && !map.containsKey(cur.random) ){
				RandomListNode randomCopy = new RandomListNode(cur.random.label);
				map.put(cur.random, randomCopy);
			}
			
			// connect cur with next
			if ( cur.next != null ){
				map.get(cur).next = map.get(cur.next);
			}
			
			// connect cur with random
			if ( cur.random != null ){
				map.get(cur).random = map.get(cur.random);
			}
			
			// next round
			cur = cur.next;
		}
		
		return map.get(head);
	}
}


// public class Solution{
// 	public RandomListNode copyRandomList(RandomListNode head){
// 		if ( head == null )
// 			return null;
// 		
// 		Map<RandomListNode, RandomListNode> map = new HashMap<>();
// 		
// 		RandomListNode cur = head;
// 		while ( cur != null ){
// 			map.put(cur, new RandomListNode(cur.label));
// 			cur = cur.next;
// 		}
// 		
// 		cur = head;
// 		while ( cur != null ){
// 			map.get(cur).next = map.get(cur.next);
// 			map.get(cur).random = map.get(cur.random);
// 			cur = cur.next;
// 		}
// 		
// 		return map.get(head);
// 	}
// }