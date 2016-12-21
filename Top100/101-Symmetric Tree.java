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
	public boolean isSymmetric(TreeNode root){
		//corner case
		if ( root == null )
			return true;
		
		//core logic
		return isSymmetric(root.left, root.right);
	}
	
	
	//helper function
	public boolean isSymmetric(TreeNode one, TreeNode two){			//传进来的是同一位置的点
		//base case
		if( one == null || two == null ){
			if ( one == two )
				return true;
			else
				return false;
		}
		
		//current layer
		if ( one.val != two.val )				//同一位置如果不同直接false
			return false;
		//next layer
		else
			return isSymmetric( one.left, two.right ) && isSymmetric( one.right, two.left );
												//再把同一位置的点传入进去
												//一个node有俩child，所以同时判断两个位置
	}
	
}