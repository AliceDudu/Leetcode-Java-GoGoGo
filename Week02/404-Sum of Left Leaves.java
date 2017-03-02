

前序
从root出发，相当于先去找到最底层的left child，此处最底层其实是叶子的child null节点
每一层里，先判断left是否为叶子，是的话加到ans里，
判断完left再判断right，然后返回上一层


public class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
//     base case
    	if(root == null) {
    		return 0;
    	}
    	
//     	current level
    	int ans = 0;
    	
    	if(root.left != null) {
//     		root.left是个叶子
        	if(root.left.left == null && root.left.right == null) {
        		ans += root.left.val;
        	}else {
//         	next level
//         		如果root.left还有左右孩子，就先走左边
        		ans += sumOfLeftLeaves(root.left);
        	}
    	}
    	
//     	next level
//     	通过上面if的判断，已经走过了left这个叶子，所以继续走right
    	ans += sumOfLeftLeaves(root.right);
    
    	return ans;
	}
}

