

merge sort

这个partition的过程，就是把这k个list，拆成两两一对，
每两个一对排好序后，再和另外的两个排好序后的结果一起，
这二者再排一次
每当到2个单独的list的时候，就可以进行merge 排序
recursion的方法，先比较head，谁小谁就做新的head，并且next指向下一次递归的结果
下一次递归只是换了一下头，挪动了一步而已

public class Solution {
    public static ListNode mergeKLists(ListNode[] lists){
    	return partion(lists, 0, lists.length - 1);
	}

// 	这个partition的过程，就是把这k个list，拆成两两一对，
// 	每两个一对排好序后，再和另外的两个排好序后的结果一起，
// 	这二者再排一次
	public static ListNode partion(ListNode[] lists, int s, int e){
    	if(s == e)  {
    		return lists[s];
    	}
    	
    	if(s < e){
        	int q = s + (e - s) / 2;
        	
        	ListNode l1 = partion(lists, s, q);
        	ListNode l2 = partion(lists, q + 1, e);
        	
//         	每当到2个单独的list的时候，就可以进行merge 排序
        	return merge(l1, l2);
    	}else
        	return null;
	}

//This function is from Merge Two Sorted Lists.
	public static ListNode merge(ListNode l1,ListNode l2){
    	if(l1 == null) {
    		return l2;
    	}
    	if(l2 == null) {
    		return l1;
    	}
    	
//     	recursion的方法，先比较head，谁小谁就做新的head，并且next指向下一次递归的结果
// 		下一次递归只是换了一下头，挪动了一步而已
    	if(l1.val < l2.val){
        	l1.next = merge(l1.next, l2);
        	return l1;
    	}else{
        	l2.next = merge(l1, l2.next);
        	return l2;
    	}
	}
}