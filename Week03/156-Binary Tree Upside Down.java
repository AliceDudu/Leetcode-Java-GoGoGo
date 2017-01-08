public class Solution{
	public TreeNode upsideDownBinaryTree(TreeNode root){
		//root.left==null,for base case, otherwise can pass to next level
		//root==null, for corner case
		if ( root == null || root.left == null ){
			return root;
		}
		
		//pass root.left to next level
		TreeNode newRoot = upsideDownBinaryTree(root.left);
		
		//current level
		root.left.left = root.right;
		root.left.right = root;
		root.left = null;
		root.right = null;
		
		//the lowest left leaf node is transfered to every level as newRoot
		return newRoot;
		
	}
}

//不知道什么情况下用helper函数？什么时候只需要调用自己？
// public class Solution{
// 	public TreeNode upsideDown(TreeNode root){
// 		//corner
// 		if ( root == null ){	//why root.left==null
// 			return null;
// 		}
// 		
// 		//core
// // 		TreeNode cur = root;
// // 		while ( cur.left != null ){
// // 			cur = cur.left;
// // 		}
// 		
// 		return flipHelper(root);
// 	}
// 	
// 	private TreeNode flipHelper(TreeNode root){
// 		//base
// 		if ( root.left == null && root.right == null ){
// 			return root;
// 		}
// 		
// 		//next
// 		flipHelper(root.left);		//no need helper function
// 		
// 		//current
// 		root.left.left = root.right;
// 		root.left.right = root;
// 		root.left = null;
// 		root.right = null;
// 		
// 		return root;
// 
// 	}
// }