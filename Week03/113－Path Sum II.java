public class Solution{
	public List<List<Integer>> pathSum(TreeNode root, int sum){
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> currentList = new ArrayList<Integer>();
		
		pathSumHelper(root, sum, currentList, res);
		
		return res;
	}
	
	private void pathSumHelper(TreeNode root, int sum, List<Integer> currentList, List<List<Integer>> res){
		//base
		if ( root == null ){
			return;
		}
		
		//current
		currentList.add(root.val);
		
		//next
		if ( root.left == null && root.right == null && root.val == sum ){
			res.add(new ArrayList(currentList));
			currentList.remove(currentList.size() - 1);		//return to above level 
			return;
		}else{
			pathSumHelper(root.left, sum - root.val, currentList, res);
			pathSumHelper(root.right, sum - root.val, currentList, res);
		}
		currentList.remove(currentList.size() - 1);			//finish two branches, return to above level 
		
	}
}





// if (root.left == null && root.right == null && sum == root.val) {
// 		result.add(new LinkedList(currentResult));
// 		currentResult.remove(currentResult.size() - 1);//don't forget to remove the last integer
// 		return;
// 	} else {
// 		pathSum(root.left, sum - root.val, currentResult, result);
// 		pathSum(root.right, sum - root.val, currentResult, result);
// 	}
// 	currentResult.remove(currentResult.size() - 1);		//走到这一步：说明当前root的左右根都走完了，
// 														//它需要继续返回到上一层了
// 														//那么要以什么‘姿态’返回去呢？这道题里就是，它需要删掉自己最末尾的节点