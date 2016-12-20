public class Solution {
	public boolean isValid(String s){
	
		if ( s == null || s.length() == 0 )
			return true;
		if ( (s.length() & 1) == 1 )			//判断奇偶性，奇数的时候肯定配不了对
			return false;
		
		
		//定义stack
		char[] str = s.toCharArray();
		Deque<Character> stack = new LinkedList<Character>();
		
		//要去遍历string
		//遇到左边的就放到stack
		//当前遇到右边的括号，看是否与顶端的相匹配
// 		int n = s.length();
		for ( char ch : str ){
		
			if ( ch == '(' || ch == '[' || ch == '{' ){
				stack.offerLast(ch);
			}else{
				if ( stack.isEmpty() )			// !!! forgotten: 右括号先单独出现 不合法
					return false;
			}
			
			char left = stack.pollLast();
			
			if ( ( ch == ')' && left == '(' ) || 
				 ( ch == ']' && left == '[' ) ||
				 ( ch == '}' && left == '{' ) ){
				continue;
			}else{
				return false;
			}
			
// 			if ( s[i] in ['(', '[', '{'] ){
// 				stack.add(s[i]);
// 			}else if ( s[i] in [')', ']', '}'] ){
// 				//看是否与栈顶的匹配
// 				if (no)
// 					return false;
// 				else{
// 					stack.pollLast();	
// 				}
// 			}

		}	
		
		return stack.isEmpty();
		
// 		if ( stack.isEmpty() )
// 			return true;
// 		else
// 			return false;		
	}
}