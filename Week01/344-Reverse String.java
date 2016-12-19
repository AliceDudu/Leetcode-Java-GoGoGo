public class Solution {
	public String reverseString(String s){
		//corner
		if ( s == null || s.length() <= 1 )
			return s;
		
		//core
		char[] words = s.toCharArray();
		
		int n = s.length();
		int left = 0;
		int right = n -1;
				
		while ( left < right ){
			char tmp = words[left];
			words[left] = words[right];
			words[right] = tmp;
			left++;
			right--
		}
		
		return new String(words);
	}
}