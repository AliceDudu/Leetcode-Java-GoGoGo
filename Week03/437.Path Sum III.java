
public class Solution {
    public int pathSum(TreeNode root, int sum) {
        if( root == null ){
            return 0;
        }
        
        return findPath(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }
    
    public int findPath(TreeNode root, int sum){
        int res = 0;
        
        if( root == null ){
            return res;
        }
            
        if( sum == root.val ){
            res++;
        }
        
        res += findPath(root.left, sum - root.val);
        res += findPath(root.right, sum - root.val);
        
        return res;
    }
   
}

// public class Solution{
// 	public int pathSum(TreeNode root, int sum){
// 		//corner
// 		if ( root == null ){
// 			return 0;
// 		}
// 		
// 		return pathSumCount(root, sum) + pathSumCount(root.left, sum) + pathSumCount(root.right, sum);
// 	}
// 	
// 	public int pathSumCount(TreeNode root, int sum){
// 		int res = 0;
// 		
// 		//base
// 		if ( root == null ){
// 			return res;
// 		}
// 		
// 		//current
// 		if ( sum == root.val ){
// 			res++;
// 		}
// 		
// 		//next
// 		res += pathSumCount(root.left, sum - root.val);
// 		res += pathSumCount(root.right, sum - root.val);
// 		
// 		return res;
// 	}
// }
