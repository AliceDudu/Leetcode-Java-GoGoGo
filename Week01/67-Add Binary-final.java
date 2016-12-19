public class Solution {
	public String addBinary(String a, String b){
		int len1 = a.length() - 1;			// ??? a==null or a=='' :a.length()==0??
		int len2 = b.length() - 1;
		
		StringBuilder result = new StringBuilder();
		int sum = 0, carry = 0;
		
		while ( len1 >= 0 || len2 >= 0 ){
			int first = (len1 >=0) ? (a.charAt(len1) - '0') : 0;
			int second = (len2 >= 0) ? (b.charAt(len2) - '0') : 0;
			
			sum = carry + first + second;
			
			if ( sum <= 1 ){
				result.insert(0, sum);
				sum = 0;
				carry = 0;
			}else{
				result.insert(0, sum % 2);
				sum = 0;
				carry = 1;
			}
			
			len1--;
			len2--;
		}
		
		if ( carry == 1 )
			result.insert(0, 1);
		
		return result.toString();
		
	}
}