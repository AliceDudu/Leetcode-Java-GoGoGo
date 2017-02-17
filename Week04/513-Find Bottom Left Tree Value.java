用层序遍历
遍历完当前行所有结点之后才去下一行，
遍历每行第一个结点时更新结果res

public class Solution{
	public int findBottomLeftValue( TreeNode root ){
		if ( root == null ){
			return 0;
		}
		
		int res = 0;
		
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		
		while ( !queue.isEmpty() ){
			int size = queue.size();

			for ( int i = 0; i < size; i++ ){
				TreeNode node = queue.poll();
				
				if ( i == 0 ){
					res = node.val;
				}
				if ( node.left != null ){
					queue.add(node.left);
				}
				if ( node.right != null ){
					queue.add(node.right);
				}
			}
		}
		return res;
	}
}