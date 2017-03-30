/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// next() will return the next smallest number in the BST.
// 即BST的从小到大的一个弹出顺序，即inorder，用迭代的方式弹出
// 在bst中，小的在左边
// 所以需要把左边的存起来，再提取

public class BSTIterator {

    Stack<TreeNode> stack;
    
    public BSTIterator(TreeNode root) {
        // 给一个root后，把left节点都存到stack里面
        stack = new Stack<TreeNode>();
        
        if(root != null) {
            pushLeft(root);
        }
    }

    /** @return whether we have a next smallest number */
    // 每个node的left都被存在stack了，直接看stack即可
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode curr = stack.pop();
        // 弹出来，如果right还有，再pushleft
        if(curr.right != null) {
            pushLeft(curr.right);
        }
        return curr.val;
    }
    
    private void pushLeft(TreeNode curr) {
        while(curr != null) {
            stack.push(curr);
            curr = curr.left;
        }
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */