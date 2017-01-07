//94. Binary Tree Inorder Traversal		
//iterative--inorder
public class Solution{
	public List<Integer> preorder(TreeNode root){
	
		List<Integer> res = new ArrayList<Integer>();	//先把结果res定义出来
		//corner
		if ( root == null ){
			return res;
		}
		
		//core
// 		List<Integer> res = new ArrayList<>();
// 		Deque<Integer> stack = new ArrayDeque<>();		//里面是TreeNode
		Deque<TreeNode> stack = new ArrayDeque<>();
		
		while ( root != null ){
			stack.push(root);
			root = root.left;
		}
		
		while ( !stack.isEmpty() ){
			TreeNode cur = stack.pop();
			res.add(cur.val);
			cur = cur.right;
			while ( cur != null ){
				stack.push(cur);
				cur = cur.left;
			}
		}
		
		return res;
	}
}
