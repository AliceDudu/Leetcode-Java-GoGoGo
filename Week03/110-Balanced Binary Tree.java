public class Solution {
    public boolean isBalanced(TreeNode root) {
        //corner
        if ( root == null ){
        	return true;
        }
        
        if ( getHeight(root) == -1 ){
        	return false;
        }else{
        	return true;
        }
    }
    
    public int getHeight(TreeNode root){
    	//base
    	if ( root == null ){
    		return 0;
    	}
    	
    	//next
    	int heightLeft = getHeight(root.left);
    	int heightRight = getHeight(root.right);
    	
    	//current
    	if ( heightLeft == -1 || heightRight == -1 ){
    		return -1;
    	}
    	
    	if ( Math.abs(heightLeft - heightRight) > 1 ){
    		return -1;
    	}
    	
    	return Math.max(heightLeft, heightRight) + 1;

    }
}


// public class Solution{
// 	public boolean balanceBST(TreeNode root){
// 		//corner
// 		if ( root == null ){
// 			return true;
// 		}
// 		
// 		return helper(root);
// 	}
// 	
// 	public boolean helper(TreeNode root){
// 		if ( root == null ){
// 			return;
// 		}
// 		
// 		int height1 = 1;
// 		int height2 = 1;
// 		
// 		if ( height1 - height2 > 1 ){
// 			return false;
// 		}
// 		
// 		
// 		
// 		height1 += helper(root.left);
// 		height2 += helper(root.right);
// 		
// 		// return height1++;
// 		
// 		return true;
// 	}
// }