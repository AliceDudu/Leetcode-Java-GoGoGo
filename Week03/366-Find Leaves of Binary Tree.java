


public class Solution {
    public List<List<Integer>> findLeaves(TreeNode root) {
        
//         装整体答案
        List<List<Integer>> leavesList = new ArrayList< List<Integer>>();
//         装当前path
        List<Integer> leaves = new ArrayList<Integer>();
        
        while(root != null) {
        	
//         	对每一次的root调用helper
            if(isLeave(root, leaves)) 
            	root = null;
            
//             调用后的，把当前path加到结果中
            leavesList.add(leaves);
            
//             清空path
            leaves = new ArrayList<Integer>();
        }
        
        return leavesList;
    }
    
    public boolean isLeave(TreeNode node, List<Integer> leaves) {
//         当前node是叶子时
        if (node.left == null && node.right == null) {
//         	把node加到当前path中
            leaves.add(node.val);
            return true;
        }
        
//         如果还没到叶子，就继续走它的孩子，先左后右
//         到right时同理
        if (node.left != null) {
//         	if里面为true时，说明node.left是叶子了，那就要把它删掉
             if(isLeave(node.left, leaves))  
             	node.left = null;
        }
        
        if (node.right != null) {
             if(isLeave(node.right, leaves)) 
             	node.right = null;
        }
        
        return false;
    }
}