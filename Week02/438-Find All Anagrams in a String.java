
left和right表示滑动窗口的左右边界
cnt表示字符串p中需要匹配的字符个数

如果右边界的字符已经在哈希表中了，说明该字符在p中有出现，则cnt自减1,然后哈希表中该字符个数自减1，右边界自加1
如果此时cnt减为0了，说明p中的字符都匹配上了，那么将此时左边界加入结果res中


public class Solution{
	public List<Integer> findAnagrams(String s, String p){
		List<Integer> list = new ArrayList<>();
		
		if ( s == null || s.length() == 0 || p == null || p.length() == 0 ){
			return list;
		}
		
		int[] hash = new int[256];		//???256
		
		for ( char c : p.toCharArray() ){
			hash[c]++;
		}
		
		int left = 0; 
		int right = 0;
		int count = p.length();
		
		while ( right < s.length() ){
			if ( hash[s.charAt(right++)] -- >= 1 ){
				count --;
			}
			
			if ( count == 0 ){
				list.add(left);
			}
			
			if ( right - left == p.length() && hash[s.charAt(left++)] ++ >= 0 ){
				count++;
			}
		}
		
		return list;
	}
}