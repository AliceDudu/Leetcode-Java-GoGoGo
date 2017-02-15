

如果其左子节点存在，我们通过递归调用函数，算出不包含左子节点返回的值，
同理，如果右子节点存在，算出不包含右子节点返回的值，
那么此节点的最大值可能有两种情况，
一种是该节点值加上不包含左子节点和右子节点的返回值之和，
另一种是左右子节点返回值之和不包含当期节点值，
取两者的较大值
把已经算过的节点用哈希表保存起来

public class Solution {
    public int rob(TreeNode root) {
        return robHelp(root, new HashMap<>());
    }
    
    public int robHelp( TreeNode root, Map<TreeNode, Integer> map ){
    	if ( root == null ){
    		return 0;
    	}
    	
    	if ( map.containsKey(root) ){
    		return map.get(root);
    	}
    	
    	int val = 0;
    	
    	if ( root.left != null ){
    		val += robHelp(root.left.left, map) + robHelp(root.left.right, map);
    	}
    	
    	if ( root.right != null ){
    		val += robHelp(root.right.left, map) + robHelp(root.right.right, map);
    	}
    	
    	val = Math.max( val + root.val, robHelp(root.left, map) + robHelp(root.right, map) );
    	
    	map.put(root, val);
    	
    	return val;
    }
}