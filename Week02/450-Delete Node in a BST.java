

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 

 
 用二分法找到key在那里，while停在cur＝key时
 删除cur后，还要把它下面的node重新连接到原来的树上，
 cur是pre的哪边的孩子，就要重新构造哪边
 最后返回整体的root
 
 要删除的node只有一个孩子时，好办，直接另一边补位
 
 要删除的node有两个孩子时
 要返回的是node的右孩子的左叶子
 找到node的右孩子的最左端的叶子
 将node的左孩子放到右孩子的左叶子的左端
 然后把node的右孩子放到此叶子的右侧
 
 
public class Solution {
    
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode cur = root;
        TreeNode pre = null;
        
//         用二分法找到key在那里，while停在cur＝key时
        while( cur != null && cur.val != key ) {
            pre = cur;
            
            if (key < cur.val) {
                cur = cur.left;
            } else if (key > cur.val) {
                cur = cur.right;
            }
        }
        
//         删除cur后，还要把它下面的node重新连接到原来的树上，
// 			cur是pre的哪边的孩子，就要重新构造哪边
        if (pre == null) {
            return deleteRootNode(cur);
        }
        if (pre.left == cur) {
            pre.left = deleteRootNode(cur);
        } else {
            pre.right = deleteRootNode(cur);
        }
        
//         返回整体的root
        return root;
    }
    
    private TreeNode deleteRootNode(TreeNode root) {
        if (root == null) {
            return null;
        }
//         要删除的node只有一个孩子时，好办，直接另一边补位
        if (root.left == null) {
            return root.right;
        }
        if (root.right == null) {
            return root.left;
        }
        
//         要删除的node有两个孩子时
        TreeNode next = root.right;
        TreeNode pre = null;
        
//         找到node的右孩子的最左端的叶子
        for(; next.left != null; pre = next, next = next.left);
        
//         将node的左孩子放到右孩子的左叶子的左端
        next.left = root.left;
        
//         ？？？？为什么一定要这么做呢
//         root.right != next  说明node的右孩子还有子孙
        if( root.right != next ) {
//         	把左叶子的右侧腾出位置，这一分支作为node的左孩子
            pre.left = next.right;
//             将node的右孩子，放到左孙子的右侧，
            next.right = root.right;
        }
        
//         	要返回的是node的右孩子的左叶子
//         返回next，代替被删除的node，作为新的左孩子或者右孩子
        return next;
    	
//     	如果不进行上面的if调换，只做这一步，会出错，为什么呢？
//         TreeNode pre = root.right;
//         return pre;
        
    }

}