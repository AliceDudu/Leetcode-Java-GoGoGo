

因为要看不同的元素，所以用map来track
key是字母，value是角标，用来算距离


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
		
// 			map的size不到2个时，就是把字母和角标放进去
			if ( map.size() <= 2 ){
				char c = s.charAt(end);
				map.put(c, end);
				end++;
			}
		
// 			大于2时，说明已经有3个字母了，再放不进来这个window了
// 			所以需要去掉一个字母
// 			去的方法，就是看最小的角标所代表的字母，把start放在它之后一位
			if ( map.size() > 2 ){
				int left = s.length();
				
// 				取map的value中最小的那个角标作为left
				for ( int i : map.values() ){
					left = Math.min(left, i);
				}
// 				把这个字母从map中移除
				map.remove(s.charAt(left));
// 				start从left＋1开始
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