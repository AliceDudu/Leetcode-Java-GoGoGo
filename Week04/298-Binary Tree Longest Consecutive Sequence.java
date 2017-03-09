


public class Solution {
// 	用来记录最长的len
    private int max = 0;
    
    public int longestConsecutive(TreeNode root) {
        if(root == null) {
        	return 0;
        }
        
//         root作为这条path的起点时，当前值就是root.val，下一个就应该比它多1
        helper(root, 0, root.val);
        
        return max;
    }
    
//     cur相当于之前的path，用来记录临时的path可以走多长
    public void helper(TreeNode root, int cur, int target){
//     	base case
        if(root == null) {
        	return;
        }
//         current level
// 		如果current root应该是在连续递增序列里的值，那么长度就＋＋
        if(root.val == target) {
        	cur++;
//         如果不等于，就要从它开始重新计数了
        }else {
        	cur = 1;
        }
        
//         每次增加一点后都要重新track一下max
        max = Math.max(cur, max);
        
//         next level
//         把当前的path的长度cur传递下去，同时target＋1
        helper(root.left, cur, root.val + 1);
        helper(root.right, cur, root.val + 1);
    }
}