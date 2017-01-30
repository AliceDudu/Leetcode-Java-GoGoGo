public class Solution{	
	public int lengthOfLongestSubstringTwoDistinct(String s){
		//corner
		if ( s == null || s.length() == 0 ){
			return 0;
		}
	
		int start = 0;
		int end = 0;
	
		Map<Character, Integer> map = new HashMap<>();
		int res = 0;
	
		while ( end < s.length() ){
			if ( map.size() <= 2 ){
				char c = s.charAt(end);
				map.put(c, end);
				end++;
			}
		
			if ( map.size() > 2 ){
				int left = s.length();
				for ( int i : map.values() ){
					left = Math.min(left, i);
				}
				map.remove(s.charAt(left));
				start = left + 1;
			}
		
			res = Math.max(res, end - start);
		}
	
		return res;
	
	}

}




// 	public int lengthOfLongestSubstringTwoDistinct(String s){
// 		int left = 0;
// 		int right = -1;
// 		int maxLen = 0;
// 		
// 		for ( int k = 1; k < s.length(); k++ ){
// 			if ( s.charAt(k) == s.charAt(k - 1) ){
// 				continue;
// 			}
// 			
// 			if ( right > -1 && s.charAt(k) != s.charAt(right) ){
// 				maxLen = Math.max(maxLen, k - left);
// 				left = right + 1;
// 			}
// 			
// 			right = k - 1;
// 		}
// 		
// 		return Math.max(s.length() - left, maxLen);
// 		
// 	}