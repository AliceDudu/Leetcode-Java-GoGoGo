
The idea is simple, we only update the result (max) when we find a "pair".
If we find a pair. We throw this pair away and see how big the gap is between current and previous invalid.
EX: "( )( )"
stack: -1, 0,
when we get to index 1 ")", the peek is "(" so we pop it out and see what's before "(".
In this example it's -1. So the gap is "current_index" - (-1) = 2.

i从左遍历到右
stack 用来存它遇到的字符
当遇到右括号时，就需要判断是否能够弹出
判断的条件除了 s.charAt(stack.peek()) == '('，还有一个 stack.size() > 1，为什么不是大于等于1，
因为提前放进去了一个－1，是为了处理边界条件的
遇到没办法配对的字符就先放到stack里面

public class Solution {
    public int longestValidParentheses(String s) {
        LinkedList<Integer> stack = new LinkedList<>();
        
        int result = 0;
        stack.push(-1);
        
//         当遇到右括号时，就需要判断是否能够弹出
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')' && stack.size() > 1 && s.charAt(stack.peek()) == '(') {
                stack.pop();
//                 how big the gap is between current and previous invalid
                result = Math.max(result, i - stack.peek());
            
//             遇到没办法配对的字符就先放到stack里面
            } else {
                stack.push(i);
            }
        }
        
        return result;
    }
}


public class Solution {
    public int longestValidParentheses(String s) {
        int[] dp = new int[s.length()];
        int result = 0;
        int leftCount = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                leftCount++;
                
            } else if (leftCount > 0){
                dp[i] = dp[i - 1] + 2;
                dp[i] += (i - dp[i]) >= 0 ? dp[i - dp[i]] : 0;
                result = Math.max(result, dp[i]);
                leftCount--;
            }
        }
        return result;
    }
}