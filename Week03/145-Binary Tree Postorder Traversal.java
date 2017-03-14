public class Solution{
    public List<Integer> postorderTraversal(TreeNode root){
        LinkedList<Integer> res = new LinkedList<>();
        //corner
        if ( root == null ){
            return res;
        }

        //core
        Deque<TreeNode> stack = new ArrayDeque<>();
        
//         先把root放进去，然后先pop出来
        stack.push(root);
        while ( !stack.isEmpty() ){
            TreeNode cur = stack.pop();
            res.addFirst(cur.val);

//          然后把left先放进去，这样就后出来
            if ( cur.left != null ){
                stack.push(cur.left);
            }

//          再把right放进去，这样就可以先放出来
            if ( cur.right != null ){
                stack.push(cur.right);
            }
        }

        return res;    
    }
}
