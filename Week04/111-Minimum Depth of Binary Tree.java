public class Solution{
	public int minDepth(TreeNode root){
		//corner & base 
		if ( root == null ){
			return 0;
		}
		
		//next
		int L = minDepth(root.left);
		int R = minDepth(root.right);
		
		//current
		int min = Math.min(L, R);
		
		//return
		return 1 + (min > 0 ? min : Math.max(L, R));
			
	}
}


// public class Solution{
// 	public int minDepth(TreeNode root){
// 		//corner
// 		if ( root == null ){
// 			return 0;
// 		}
// 		
// 		//core
// 		int min = 1;
// 
// 		helper(root, 1, min);
// 		
// 		return min;
// 	}
// 	
// 	public void min(TreeNode root, int len, int min){
// 		//base
// 		if ( root.left == null && root.right == null ){
// 			if ( len < min ){
// 				min = len;
// 			}
// 			return ;
// 		}
// 		
// 		//current
// 		len++;						//向下走的时候可以不进行count，就是走，往回返的时候再count
// 		
// 		//next
// 		helper(root.left, len, min);
// 		len--;
// 		helper(root.right, len, min);
// 		len--;
// 		
// 		return ;
// 	}
// }