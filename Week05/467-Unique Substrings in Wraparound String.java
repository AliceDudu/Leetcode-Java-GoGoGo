
// 
// 以某个字符结束的最大字符串包含其他以该字符结束的字符串的所有子字符串
// 以每个字符(a-z)为结束字符的最长连续字符串就行了，
// 我们用一个数组cnt记录下来，最后在求出数组cnt的所有数字之和就是我们要的结果

public class Solution{
	public int findSubstringInWraproundString( String p ){
		int[] count = new int[26];
		
		int maxLenCur = 0;
		
		for ( int i = 0; i < p.length(); i++ ){
			if ( i > 0 && ( p.charAt(i) - p.charAt(i - 1) == 1 || p.charAt(i - 1) - p.charAt(i) == 25 )){	//
				maxLenCur++;
			}else{
				maxLenCur = 1;		//
			}
			
			int index = p.charAt(i) - 'a'; 	
			count[index] = Math.max(count[index], maxLenCur);
		}
		
		int sum = 0;
		for ( int i = 0; i < 26; i++ ){
			sum += count[i];
		}
		
		return sum;
	}
}