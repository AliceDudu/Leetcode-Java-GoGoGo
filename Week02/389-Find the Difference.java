s每个字符的val＋＋，
t中存在的另外一个字符，它的val＝0

public class Solution{
	public char findTheDifference( String s, String t ){
		int[] alpha = new int[26];
		
		for ( char c : s.toCharArray() ){
			alpha[c - 'a']++;
		}
		
		for ( char c : t.toCharArray() ){
			if ( -- alpha[c - 'a'] <0 ){
				return c;
			}
		}
		
		return 0;
	}
}