public class Solution{
	public boolean isValidBST(TreeNode root){
		if ( root == null )
			return true;
		
		return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}
	
	public boolean helper(TreeNode cur, long min, long max){
		if ( cur == null )
			return true;
	
		if ( cur.val >= max || cur.val <= min )
			return false;
		
		return helper(cur.left, min, cur.val) && helper(cur.right, cur.val, max);
	}

}