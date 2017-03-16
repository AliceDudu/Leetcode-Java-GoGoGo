

serialize
前序遍历，root－left－right
就是要加在一个sb里，还有null的时候输出N

deserialize
用queue弹出，因为是前序，弹出的时候也是从前向后的
当前层，弹出来，先看是什么
不是null的话，当前层，把这个value加到node上
base case是N的话，说明是null，直接返回上一层 

public class Codec {
    private static final String N = "N";
    private static final String spliter = ",";
    // Encodes a tree to a single string.
    
    public String serialize(TreeNode root) {
        if(root == null){
            return new String();
        }
        
        StringBuilder sb = new StringBuilder();
        
        helper(root, sb);
        
        return sb.toString();
    }
    
//     前序遍历，root－left－right
    public void helper(TreeNode root, StringBuilder sb){
//     	base case到了null了，就返回N和逗号
        if(root == null){
            sb.append(N).append(spliter);
            return;
        }
        
//         当前层，append value和逗号
        sb.append(root.val).append(spliter);
        
//         先左，后右
        helper(root.left, sb);
        
        helper(root.right, sb);
        
        return;
    }
    
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
    
        if(data == null || data.length() == 0){
            return null;
        }
        
        return helper(new LinkedList<String>(Arrays.asList(data.split(spliter))));
    }
    
    public TreeNode helper(Queue<String> que){

// 		当前层，弹出来，先看是什么
        String cur = que.poll();
		
// 		base case是N的话，说明是null，直接返回上一层        
        if(cur.equals(N)){
            return null;
        }
        
//         不是null的话，当前层，把这个value加到node上
        TreeNode root = new TreeNode(Integer.parseInt(cur));
        
//         node的left和right再去找
        root.left = helper(que);
        
        root.right = helper(que);

        return root;
    }
    
}