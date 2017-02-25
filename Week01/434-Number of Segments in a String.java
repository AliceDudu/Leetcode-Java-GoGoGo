



i从s的左扫到右
每次遇到一个单词的第一个字母时，即第一个非空时，segs＋1
然后每个单词再一直while走到空格停止

public class Solution {
    public int countSegments(String s) {
    
    	int segs = 0;
		char[] chars = s.toCharArray();

		for(int i = 0; i < chars.length; i++) {
// 			每次遇到一个单词的第一个字母时，即第一个非空时，segs＋1
    		if( chars[i] != ' ' ) 
    			segs++;

//     		然后每个单词再一直while走到空格停止
    		while( i < chars.length && chars[i] != ' ' ) 
    			i++;
		}
		
		return segs;
	}
}