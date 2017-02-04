//iteration
public class Solution{
	public TreeNode inorderSuccessor( TreeNode root, TreeNode p ){
		if ( root == null || p == null ){
			return null;
		}
		
		TreeNode successor = null;
		
		while ( root != null ){
			if ( p.val < root.val ){
				successor = root;
				root = root.left;
			}else{
				root = root.right;
			}
		}
		
		return successor;
	}
}

//recursion
public class Solution{
	public TreeNode inorderSuccessor( TreeNode root, TreeNode p ){
		if ( root == null || p == null ){
			return null;
		}
		
		if ( p.val >= root.val ){
			return inorderSuccessor(root.right, p);
		}else{
			TreeNode left = inorderSuccessor(root.left, p);
			return left == null ? root : left;
		}
	}
}