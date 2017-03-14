


 当root自身引领的一个树看作subtree时，还有当它的left和right各引领一颗subtree时，这个结果加起来
 当root和left和right同时满足它们的值等于value时，就返回1
 否则就返回0
 
public class Solution {
    public int countUnivalSubtrees(TreeNode root) {
        if(root == null) 
        	return 0;
        
//         因为是子树，要考虑root
//         当root自身引领的一个树看作subtree时，还有当它的left和right各引领一颗subtree时，这个结果加起来
        return isUnitree(root, root.val) + countUnivalSubtrees(root.left) + countUnivalSubtrees(root.right);
    }
    
//     返回值是int
    private int isUnitree(TreeNode root, int value){
//     	走到叶子，返回1
        if(root == null) 
        	return 1;
        
//         当root和left和right同时满足它们的值等于value时，就返回1
//         current level判断三个点的值是不是value
//         将value传递给下一层的left和right孩子
        if(root.val == value && isUnitree(root.left, value) == 1 && isUnitree(root.right, value) == 1) 
        	return 1;
        
//         否则就返回0
        return 0;
    }
}