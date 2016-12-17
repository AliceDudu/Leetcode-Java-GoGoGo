public class Solution{
	public int[] plusOne( int[] digits ){
				
		//core logic
// 		int n = len(digits)-1;
		int n = digits.length;
		int i = n-1;
		
		while ( i>=0 ){
			int carry = 0;
			int sum = digits[i] + 1;
			
			if ( sum < 10 ){				
				digits[i] = sum;
				return digits;
			}else{
				int remain = sum % 10;
				carry = 1;
				digits[i] = remain;
				i = i-1;
			}
		}
		
		//corner case: when head_digit+1>=10, length of array will increase 1
// 		if ( carry == 1 ){
// 			arraylist[0] = carry;
// 			arraylist[1~n] = digits;
// 			return arraylist;
// 		}
		int[] newNumber = new int [n+1];
		newNumber[0] = 1;	
		return newNumber;		// ？？？原来的digits是怎么被copy过来的

	}
}