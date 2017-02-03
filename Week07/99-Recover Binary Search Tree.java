public class Solution{
	TreeNode first = null;
	TreeNode second = null;
		
	TreeNode pre = new TreeNode(Integer.MIN_VALUE);
	
	public void recoverTree( TreeNode root ){
		traverse(root);		//search the two mistaken nodes
			
		int temp = first.val;
		first.val = second.val;
		second.val = temp;
	}
	
	//in-order
	public void traverse( TreeNode root ){
		if ( root == null ){
			return;
		}
		
		traverse(root.left);
		
		if ( first == null && pre.val >= root.val ){
			first = pre;	//If first element has not been found, assign it to prev
		}
		
		if ( first != null && pre.val >= root.val ){
			second = root;	//If first element is found, assign the second element to the root
		}
		
		pre = root;
		
		traverse(root.right);
	}
	
}