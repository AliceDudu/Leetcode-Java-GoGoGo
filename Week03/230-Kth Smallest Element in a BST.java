public class Solution{
	public int kthSmallest(TreeNode root, int k){
		int res = -1;			// never hit if k is valid
		
		Deque<TreeNode> stack = new ArrayDeque<>();
		
		TreeNode cur = root;
		while( cur != null ){
			stack.push(cur);
			cur = cur.left;
		}
		
		while( !stack.isEmpty() && k > 0 ){
			cur = stack.pop();
			res = cur.val;
			k--;
			
			if ( cur.right != null ){
				cur = cur.right;
				while ( cur != null ){
					stack.push(cur);
					cur = cur.left;
				}
			}
		}
		
		return res;
	}
}