public class Solution {
    public String convertToBase7(int num) {
        if (num == 0) {
        	return "0";
        }
        
        StringBuilder sb = new StringBuilder();
        boolean negative = false;
        
//         记录符号
        if (num < 0) {
            negative = true;
        }
        
//         取余数，然后再取整，从低位向前计算
        while (num != 0) {
            sb.append(Math.abs(num % 7));
            num = num / 7;
        }
        
        if (negative) {
            sb.append("-");
        }
        
//         变换顺序
        return sb.reverse().toString();
    }
}