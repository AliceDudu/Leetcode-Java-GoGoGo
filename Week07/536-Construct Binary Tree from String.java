

public class Solution {
    public TreeNode str2tree(String s) {
        if(s==null||s.isEmpty()) return null;
        int leftCount=0,rightCount=0;
        int rootEnd=0;
        //find root in s
        for(;rootEnd<s.length();rootEnd++){
            char c=s.charAt(rootEnd);
            if(c=='('){
                break;
            }
        }
        //create root node
        int rootVal=Integer.parseInt(s.substring(0,rootEnd));
        TreeNode root=new TreeNode(rootVal);
        //find left child string
        int leftStart=rootEnd;
        int leftEnd=leftStart;
        for(;leftEnd<s.length();leftEnd++){
            char c=s.charAt(leftEnd);
            if(c=='(') leftCount++;
            else if(c==')') leftCount--;
            if(leftCount==0) break;
        }
        String left=leftStart==s.length()?"":s.substring(leftStart+1,leftEnd);
        //find right child String. *No need to find end index because it will goes to the end of the string exclude last ')'
        int rightStart=leftEnd+2;
        String right=rightStart>=s.length()?"":s.substring(rightStart,s.length()-1);
        
        root.left=str2tree(left);
        root.right=str2tree(right);
        return root;
    }
    
}

public TreeNode str2tree(String s) {
    if (s == null || s.length() == 0) return null;
    int firstParen = s.indexOf("(");
    int val = firstParen == -1 ? Integer.parseInt(s) : Integer.parseInt(s.substring(0, firstParen));
    TreeNode cur = new TreeNode(val);
    if (firstParen == -1) return cur;
    int start = firstParen, leftParenCount = 0;
    for (int i=start;i<s.length();i++) {
        if (s.charAt(i) == '(') leftParenCount++;
        else if (s.charAt(i) == ')') leftParenCount--;
        if (leftParenCount == 0 && start == firstParen) {cur.left = str2tree(s.substring(start+1,i)); start = i+1;}
        else if (leftParenCount == 0) cur.right = str2tree(s.substring(start+1,i));
    }
    return cur;
}