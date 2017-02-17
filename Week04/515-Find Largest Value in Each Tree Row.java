每一层记录一个max，加到res
再进入下一层

public class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        
        if ( root == null ){
        	return res;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while ( !queue.isEmpty() ){
        	int size = queue.size();
        	int max = Integer.MIN_VALUE;
        	
        	for ( int i = 0; i < size; i++ ){
        		TreeNode node = queue.poll();
        		max = Math.max(max, node.val);
        		if ( node.left != null ){
        			queue.add(node.left);
        		}
        		if ( node.right != null ){
        			queue.add(node.right);
        		}
        	}
        	res.add(max);
        }
        
        return res;
    }
}