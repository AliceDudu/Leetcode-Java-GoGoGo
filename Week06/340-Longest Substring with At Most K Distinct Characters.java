public class Solution{
	public int lengthOfLongestSubstringKDistinct( String s, int k ){
		//corner
		if ( s == null || s.length() == 0 || k <= 0 ){
			return 0;
		}
		
		Map<Character, Integer> map = new HashMap<>();
		
		int start = 0;
		int end = 0;
		int maxLen = 0;
		
		for ( end = 0; end < s.length(); end++ ){
			char c = s.charAt(end);
			
			if ( map.containsKey(c) ){
				int freq = map.get(c);
				map.put(c, freq + 1);
			}else{
				map.put(c, 1);
			}
			
			if ( map.size() > k ){
				maxLen = Math.max(maxLen, end - start);
				
				while ( map.size() > k ){
					char endC = s.charAt(start);
					int freq = map.get(endC);
					
					if ( freq == 1 ){
						map.remove(endC);
					}else{
						map.put(endC, freq - 1);
					}
					start++;
				}
			}
		}
		if ( start < s.length() ){
			maxLen = Math.max(maxLen, end - start);
		}
		
		return maxLen;
	}
}