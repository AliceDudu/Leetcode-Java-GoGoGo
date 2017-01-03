/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class Solution {
	public TreeNode sortedArrayToBST(int[] array){
		//corner case
		if ( array == null || array.length == 0 )
			return null;
		
		//core logic
		int n = array.length;
		return helper(array, 0, n-1);
	}
	
	private TreeNode helper(int[] array, int start, int end){
		//base case
// 		if ( array == null )
// 			return null
		if ( start > end )
			return null;
		
		//current
		int mid = start + (end - start) / 2;
		TreeNode root = new TreeNode( array[mid] );
		
		//next
		root.left = helper( array, start, mid - 1 );
		root.right = helper( array, mid + 1, end );
		
		return root;
	}
	
}