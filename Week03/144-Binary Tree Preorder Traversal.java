public class Solution{
	public List<Integer> preorderTraversal(TreeNode root){
		List<Integer> res = new ArrayList<>();
		//corner
		if ( root == null ){
			return res;
		}
		
		//core
		Deque<TreeNode> stack = new ArrayDeque<>();
		
		stack.push(root);
		
		while ( !stack.isEmpty() ){
			TreeNode cur = stack.pop();
			res.add(cur.val);
			
			if ( cur.right != null ){
				stack.push(cur.right);
			}
			
			if ( cur.left != null ){
				stack.push(cur.left);
			}
		}
		
		return res;
	}
}
