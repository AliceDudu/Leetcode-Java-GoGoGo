

//         i从num的头扫到尾，
// 			stack里只放小的数字，用k－－去控制stack里面元素的个数，里面一共装k个小的元素
//         处理全部相等的情况
//         stack从尾pop出来，再reverse一下就得到结果
//         删掉串首的0

public class Solution {
    public String removeKdigits(String num, int k) {
        int len = num.length();
        //corner case
        if( k == len )        
            return "0";
            
        Deque<Character> stack = new Stack<>();
        
//         i从num的头扫到尾，
// 			stack里只放小的数字，用k－－去控制stack里面元素的个数，里面一共装k个小的元素
        int i =0;
        while( i < num.length() ){
            //whenever meet a digit which is less than the previous digit, discard the previous one
            while( k > 0 && !stack.isEmpty() && stack.peek() > num.charAt(i) ){		//stack.peek() > num.charAt(i)
                stack.pop();
                k--;
            }
            
            stack.push(num.charAt(i));
            i++;
        }
        
//         处理全部相等的情况
        // corner case like "1111"
        while( k > 0 ){
            stack.pop();
            k--;            
        }
        
//         stack从尾pop出来，再reverse一下就得到结果
        //construct the number from the stack
        StringBuilder sb = new StringBuilder();
        while( !stack.isEmpty() )
            sb.append(stack.pop());
            
        sb.reverse();
        
//         删掉串首的0
        //remove all the 0 at the head
        while( sb.length() > 1 && sb.charAt(0) == '0')
            sb.deleteCharAt(0);
            
        return sb.toString();
    }
}

