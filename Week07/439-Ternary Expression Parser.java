


public class Solution {
    public String parseTernary(String expression) {
        if(expression == null || expression.length() == 0){
            return expression;
        }
        char[] exp = expression.toCharArray();
        
        return DFS(exp, 0, exp.length - 1) + "";
        
    }
    public char DFS(char[] c, int start, int end){
        if(start == end){
            return c[start];
        }
        int count = 0, i =start;
        for(; i <= end; i++){
            if(c[i] == '?'){
                count ++;
            }else if (c[i] == ':'){
                count --;
                if(count == 0){
                    break;
                }
            }
        }
        return c[start] == 'T'? DFS(c, start + 2, i - 1) : DFS(c, i+1,end);
    }
}