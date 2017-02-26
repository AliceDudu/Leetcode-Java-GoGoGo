

public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
    	
    	int[] table = new int[26];
    
//     	先把magazine的字母统计一下frequency
    	for ( char c : magazine.toCharArray() )   
    		table[c - 'a']++;
    
//     	再遍历ransom
    	for ( char c : ransomNote.toCharArray() )
//     		遇到一个字母，就在table里减去一次，如果 < 0 了，说明magazine里没有这么多这个字母，false
        	if ( --table[c - 'a'] < 0 )  
        		return false;
    
    	return true;
	}
}