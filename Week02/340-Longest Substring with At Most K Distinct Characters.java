At Most K Distinct Characters
首先这个window里要有k个distinct
其次它得是最长的

用start，end，map来构成这个window
其中
map用来存distinct的char，并且计数
map的size就是distinct的个数
start和end作为window的两端

end一直走，并且将字母放进map中

当map的大小大于了k个distinct时，就要移动start来删掉map里的多余个数的元素
移除之前，先计算此时的window长度end - start，取最大的作为maxLen
maxLen是用来记录含有k个distinct的window的出现过的最大长度
所以window是可以变化的，只需用maxlen来记忆最长的长度就可以

移除时start向右移动，遇到一个字母，就在map里面抵消掉一个
直到remove一个后，这时map的size就＝＝k了

继续上面的过程，用maxLen来track出现过的最大的长度即可


public class Solution{
	public int lengthOfLongestSubstringKDistinct( String s, int k ){
		//corner
		if ( s == null || s.length() == 0 || k <= 0 ){
			return 0;
		}
		
// 		用start，end，map来构成这个window
		Map<Character, Integer> map = new HashMap<>();
		
		int start = 0;
		int end = 0;
		int maxLen = 0;
		
// 		end一直走，并且将字母放进map中
		for ( end = 0; end < s.length(); end++ ){
			char c = s.charAt(end);
			
			if ( map.containsKey(c) ){
				int freq = map.get(c);
				map.put(c, freq + 1);
			}else{
				map.put(c, 1);
			}
			
// 			当map的大小大于了k个distinct时，就要移动start来删掉map里的多余个数的元素
// 			此时说明window里已经有k＋1个distinct了
			if ( map.size() > k ){
// 				移除之前，计算此时的window长度end - start，取最大的作为maxLen
				maxLen = Math.max(maxLen, end - start);
				
// 				当window超过k个时，就要删除掉一个字母
// 				只能从start删除，不能从中间就断了，从尾巴就没意义了
				while ( map.size() > k ){
					char endC = s.charAt(start);
					int freq = map.get(endC);
					
// 					start向右移动，遇到一个字母，就在map里面抵消掉一个
// 					直到remove一个后，这个size就＝＝k了
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