public class Solution{
	public int numDecodings( String s ){
		if ( s == null || s.length() == 0 ){
			return 0;
		}
		
		if ( s.charAt(0) == '0' ){
			return 0;
		}
		
		int[] num = new int[s.length() + 1];
		
		num[0] = 1;
		num[1] = 1;
		int tmp;
		
		for ( int i = 2; i <= s.length(); i++ ){
			tmp = Integer.parseInt(s.substring(i - 1, i));
			
			if ( tmp != 0 ){
				num[i] = num[i - 1];
			}
			
			if ( s.charAt(i - 2) != '0' ){
				tmp = Integer.parseInt(s.substring(i - 2, i));
				
				if ( tmp > 0 && tmp <= 26 ){
					num[i] += num[i - 2];
				}
			}
		}
		
		return num[s.length()];
	}
}