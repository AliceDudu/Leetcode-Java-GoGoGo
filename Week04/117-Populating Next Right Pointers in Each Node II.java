

由于子树有可能残缺，故需要平行扫描父节点同层的节点，找到他们的左右子节点

public class Solution{
	public void connect( TreeLinkNode root ){
		TreeLinkNode dummy = new TreeLinkNode(0);
		TreeLinkNode pre = dummy;
		
// 		TreeLinkNode cur = root;
		
		while ( root != null ){
		
			if ( root.left != null ){
				pre.next = root.left;
				pre = pre.next;
			}
			
			if ( root.right != null ){
				pre.next = root.right;
				pre = pre.next;
			}
			
			root = root.next;
			
			if ( root == null ){
				pre = dummy;
				root = dummy.next;
				dummy.next = null;
			}
		}
	}
}