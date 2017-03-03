



一次inorder遍历之后就能得到minDiff所追踪的最小值
BST，用左根右，后面的减去前面的是大于零的，所以不用加abs
要求的是最小的diff，所以按升序排列后，每一位只需要减去它前面的一位就可以了，再往前的不用看
所以每一次就是 root.val - prev.val

public class Solution {
    
    int minDiff = Integer.MAX_VALUE;
    TreeNode prev;
    
    public int getMinimumDifference(TreeNode root) {
    	
//     	一次inorder遍历之后就能得到minDiff所追踪的最小值
        inorder(root);
        
        return minDiff;
    }
    
//     BST，用左根右，后面的减去前面的是大于零的，所以不用加abs
    public void inorder(TreeNode root) {
        if (root == null) {
        	return;
        }
        
//         左
        inorder(root.left);
        
//         根
// 		root代表的是当前的node，pre代表的是inorder时node的前一位
// 		要求的是最小的diff，所以按升序排列后，每一位只需要减去它前面的一位就可以了，再往前的不用看
// 		所以每一次就是 root.val - prev.val
        if (prev != null) {
        	minDiff = Math.min(minDiff, root.val - prev.val);
        }
        
        prev = root;
        
//         右
        inorder(root.right);
    }

}