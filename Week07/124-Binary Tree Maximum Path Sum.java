

		singlePath就是只走一边的时候
		所以要从left和right选择大的一条边走Math.max(left.singlePath, right.singlePath) 
		double是两条边都走了，也要挑left和right的较大的一个，表明它的孩子是先用两边走出来的
		然后到当前层，就是要算上三个点了 left.singlePath + right.singlePath + root.val

public class Solution {

    public class PathSum{
        int singlePath;
        int doublePath;

        public PathSum(int singlePath, int doublePath){
            this.singlePath = singlePath;
            this.doublePath = doublePath;
        }
    }
    
//     helper输入的是root，返回的是pathsum类，最终结果是这个类的doublepath
    public int maxPathSum(TreeNode root) {
        PathSum res = helper(root);
        
//         最后返回的是走两条边的，肯定会比一条边多
        return res.doublePath;
    }
    
    public PathSum helper(TreeNode root) {
//     	先走到底，再往回返值，这之前的过程，是没有数值的，从null返回的是0
        if(root == null){
            return new PathSum(0, Integer.MIN_VALUE);
        }
        
        PathSum left = helper(root.left);
        
        PathSum right = helper(root.right);

// 		singlePath就是只走一边的时候
// 		所以要从left和right选择大的一条边走Math.max(left.singlePath, right.singlePath) 
        int singlePath = Math.max(left.singlePath, right.singlePath) + root.val;
        singlePath = Math.max(singlePath, 0);

// 		double是两条边都走了，也要挑left和right的较大的一个，表明它的孩子是先用两边走出来的
// 		然后到当前层，就是要算上三个点了 left.singlePath + right.singlePath + root.val
        int doublePath = Math.max(left.doublePath, right.doublePath);
        doublePath = Math.max(doublePath, left.singlePath + right.singlePath + root.val);

        return new PathSum(singlePath, doublePath);
    }

}
