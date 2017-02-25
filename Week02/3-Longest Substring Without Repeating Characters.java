

i从s的左扫到右
j的作用：相当于是有个queue在只记录没有重复的一段sub str
i代表的是这个sub的尾巴，j代表的是这个头
所以用map来记录无重复的字母的，最近一次出现的角标
那么j的计算方式就是：map.get(s.charAt(i)) + 1，＋1就相当于把这个与i重复的数字剔除了
所以这一段没有重复字母的长度就是i - j + 1

public class Solution {
    public int lengthOfLongestSubstring(String s) {
    
        if (s.length()==0) 
        	return 0;
        	
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max=0;
        
        for (int i=0, j=0; i < s.length(); ++i){
            if ( map.containsKey(s.charAt(i)) ){
//             	j代表的是这个没有重复的一段sub str的头，＋1就相当于把这个与i重复的数字剔除了
                j = Math.max( j, map.get(s.charAt(i)) + 1 );
            }
            
//             所以用map来记录无重复的字母的，最近一次出现的角标
            map.put(s.charAt(i), i);
            
//             所以这一段没有重复字母的长度就是i - j + 1
            max = Math.max(max, i - j + 1);
        }
        
        return max;
    }
}