
逆波兰表达式就是把操作数放前面，把操作符后置的一种写法，
通过观察可以发现，第一个出现的运算符，其前面必有两个数字，
当这个运算符和之前两个数字完成运算后从原数组中删去，
把得到一个新的数字插入到原来的位置，继续做相同运算，直至整个数组变为一个数字。



i从头遍历到尾，
遇到数字，就加入到stack中，
遇到符号，就pop出来两个做运算，并把结果push进stack中
直到最后剩下一个，返回pop出来的结果

public class Solution {
    public int evalRPN(String[] a) {
  
  		Stack<Integer> stack = new Stack<>();
  
  		for (int i = 0; i < a.length; i++) {
    		switch (a[i]) {
      			case "+":
        			stack.push(stack.pop() + stack.pop());
        			break;
          
      			case "-":
        			stack.push(-stack.pop() + stack.pop());
        			break;
          
      			case "*":
        			stack.push(stack.pop() * stack.pop());
        			break;

      			case "/":
        			int n1 = stack.pop(), n2 = stack.pop();
        			stack.push(n2 / n1);
        			break;
          
      			default:
        			stack.push(Integer.parseInt(a[i]));
    		}
  		}
  
  		return stack.pop();
	}
}


