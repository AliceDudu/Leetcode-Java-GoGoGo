public class Solution {
	public String addStrings(String num1, String num2){
		int len1 = num1.length() - 1;
		int len2 = num2.length() - 1;
		
		StringBuilder result = new StringBuilder();		//??? StringBuilder 和 String 的关系
		int sum = 0, carry = 0;
		
		while ( len1 >= 0 || len2 >= 0 ){								//其中一个index<0时
			int first = len1 >= 0 ? (num1.charAt(len1) - '0') : 0;		//??? 变成数字了 - '0'
			int second = len2 >= 0 ? (num2.charAt(len2) - '0') : 0;		//短的，相当于前面几位都在加零
			
			sum = carry + first + second;
			
			if ( sum <= 9 ){
				result.insert(0, sum);
				sum = 0;
				carry = 0;
			}else{
				result.insert(0, sum % 10);
				sum = 0;
				carry = 1;
			}
			
			len1--;
			len2--;
		}
		
		if ( carry == 1 )
			result.insert(0, "1");
		
		return result.toString();
	}
}

/*
public class Solution {
	public String addStrings(String num1, String num2){
		if ( num1 == null )
			return num2;
		if ( num2 == null )
			return num1;
		
		int len1 = num1.length();
		int len2 = num2.length();
		
		if ( len1 < len2 ){				//-------while ( len1 >= 0 || len2 >= 0 )
			int shortl = len1;
			int longl = len2;
			String shortnum = num1;
			String longnum = num2;
		}else{
			int shortl = len2;
			int longl = len1;
			String shortnum = num2;
			String longnum = num1;
		}								//-------
		
		String result;  // first add, then reverse
		int carry = 0;
		
		while ( short1 >= 1 ){
			int sum = shortnum[short1-1] + longnum[short1-1] + carry;
			int remain = sum % 10;
			int carry = sum / 10;
			result.append(remain);
			shortl--;	
		}
		
		int diff = longl - shortl;
		
		while ( diff >= 1 ){
			int sum = longnum[diff-1] + carry;
			int remain = sum % 10;
			int carry = sum / 10;
			result.append(remain);
			diff--;	
		}
		
		if (carry)
			result.append(1);
		
		return result.reverse();
		
	}
}
*/