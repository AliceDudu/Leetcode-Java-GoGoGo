left - root - right

// 在BST中，指定一个node，它的inorder遍历顺序时，它的下一个是什么？

要先从root走到指定node的右孩子处
然后，再找到这个右孩子的最左叶子，这个叶子就是结果
当left为空时，说明这个node就是左叶子，所以此时返回的时当下的root
当left不为空时，就直接把这个叶子一路返回

public class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root == null){
            return null;
        }
        
//         要先从root走到指定node的右孩子处
        if(p.val >= root.val){
            return inorderSuccessor(root.right, p);
            
//         然后，再找到这个右孩子的最左叶子，这个叶子就是结果
        }else{
            TreeNode left = inorderSuccessor(root.left, p);
            
//             当left为空时，说明这个node就是左叶子，所以此时返回的时当下的root
//             当left不为空时，就直接把这个叶子一路返回
            return left == null ? root : left;
        }
        
    }
}

//test-170122-0%
public class Solution{
	public TreeNode inorderSuccessor(TreeNode root, TreeNode p){
		//corner
		if ( root == null || p == null){
			return null;
		}
		
		//core
		boolean findP = false;
		
		Deque<TreeNode> stack = new ArrayDeque<>();
		
		TreeNode cur = root;
		
        while ( cur != null ){
            stack.push(cur);
            cur = cur.left;
        }

        while ( !stack.isEmpty() ){
            cur = stack.pop();
            
            if ( findP ){
            	return cur;
            }
            
            if ( cur.val == p.val ){
            	findP = true;
            }
            
            cur = cur.right;


            if ( cur.right != null ){
                cur = cur.right;
                while ( cur != null ){
                    stack.push(cur);
                    cur = cur.left;
                }
            }
        }
        
        return null;
	
	}
}


        boolean foundNodeP = false;
        Stack<TreeNode> stack = new Stack<>();
        
        while(root != null || !stack.isEmpty()) {
            if(root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                if(foundNodeP) {
                    return root;
                }
                if(root.val == p.val) {
                    foundNodeP = true;
                }
                root = root.right;
            }
        }
        
        return null;