
r从头扫到尾 
r遇到左括号，入栈，更新cur
r遇到右括号，弹栈顶，并把curr加到后面，更新curr
r遇到逗号，则截取l和r之间的数字，用curr存起来


public class Solution {
    public NestedInteger deserialize(String s) {
    	if (s.isEmpty())
        	return null;  	
    	if (s.charAt(0) != '[') // ERROR: special case
        	return new NestedInteger(Integer.valueOf(s));
        
    	Stack<NestedInteger> stack = new Stack<>();
    	NestedInteger curr = null;
    	int l = 0; // l shall point to the start of a number substring; 
               	// r shall point to the end+1 of a number substring
        
//         r从头扫到尾     	
    	for (int r = 0; r < s.length(); r++) {
        	char ch = s.charAt(r);
        	
//         	r遇到左括号，入栈，更新cur
        	if ( ch == '[' ) {
            	if ( curr != null ) {
                	stack.push(curr);
            	}
            	curr = new NestedInteger();
            	l = r + 1;
            
//             r遇到右括号，弹栈顶，并把curr加到后面，更新curr
        	} else if (ch == ']') {
            	String num = s.substring(l, r);
            	
            	if ( !num.isEmpty() )
                	curr.add( new NestedInteger(Integer.valueOf(num)) );
                	
            	if ( !stack.isEmpty() ) {
                	NestedInteger pop = stack.pop();
                	pop.add(curr);
                	curr = pop;
            	}
            	l = r + 1;
            
//             r遇到逗号，则截取l和r之间的数字，用curr存起来
        	} else if ( ch == ',' ) {
            	if ( s.charAt(r - 1) != ']' ) {
                	String num = s.substring(l, r);
                	curr.add(new NestedInteger( Integer.valueOf(num) ));
            	}
            	l = r + 1;
        	}
    	}
    
    	return curr;
	}
}
