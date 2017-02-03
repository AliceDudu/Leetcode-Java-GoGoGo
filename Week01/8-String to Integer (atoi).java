public class Solution {

	public int myAtoi(String str){
		// null or empty
		if ( str == null || str.length() == 0 )
			return 0;

		// whitespaces ahead
		int index = 0;
		while ( str.charAt(index) == ' ' && index < str.length() )
			index++;				// move on

		// +/- signs
		int sign = 1;
		if ( str.charAt(index) == '+' || str.charAt(index) == '-' ){
			sign = str.charAt(index) == '+' ? 1 : -1;
			index ++;				// take just one sign ??input只有一个符号吗？YES "  -0214abc7483648" -> -214
		}							// takes an optional initial plus or minus sign followed by as many numerical digits as possible

		// convert number
		int total = 0;

        //Integer.
		while ( index < str.length() ){
			int digit = str.charAt(index) - '0';	//??这个字符是数字还是字母？ 减去0的ACSII码
			//-------------
			//System.out.println(digit);

			if ( digit < 0 || digit > 9 )		//??这个时候是什么字符
				break;

			//check if total will be overflow after 10 times and add digit
			//Integer.MAX_VALUe / 10 < total -> total*10 > Integer.MAX_VALUe 不可以
			if ( Integer.MAX_VALUE / 10 < total || (Integer.MAX_VALUE / 10 == total && Integer.MAX_VALUE % 10 < digit) )
				return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;


//			if ( total * 10 <= MAX_VALUE ){
//				total = total * 10;
//			}else{
//				if (sign == 1){
//					return MAX_VALUE;
//				}else
//					return MIN_VALUE;
//			}
//			//-------------
//			System.out.println(total);
//
//			// total + digit=2147483648 already > Max, then turn to -2147483648, then smaller than Max
//			if ( total + digit <= MAX_VALUE ){
//				total = total + digit;
//			}else{
//				if (sign == 1){
//					return MAX_VALUE;
//				}else
//					return MIN_VALUE;
//			}
//			//-------------
//			System.out.println(total);
//			/*
//			8
//			2147483640
//			-2147483648
//			*/

			total = total * 10 + digit;			//没超两个边界时，才能继续进行
			index ++;
		}

		return total * sign;
	}
}
