public class Solution {
    public int firstUniqChar(String s) {
    
        int freq [] = new int[26];
        
//         从头扫到尾，freq相当于一个hash表，index就是相应字母的序号，val是出现的次数
        for(int i = 0; i < s.length(); i ++)
            freq [s.charAt(i) - 'a'] ++;
        
//         从freq的头向后扫，第一次遇到1的时候返回这个index
        for(int i = 0; i < s.length(); i ++)
            if(freq [s.charAt(i) - 'a'] == 1)
                return i;
                
        return -1;
    }
}