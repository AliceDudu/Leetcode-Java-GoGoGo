// 双指针
// 从s的第一个开始对照
// 若t的j处＝＝对照字母，则i，j同时＋1
// 若不等，则j继续＋1寻找

public class Solution{
	public boolean isSubsequence(String s, String t) {
        //corner
        if ( s == null || s.length() == 0 ){
        	return true;
        }
        //core
        int i = 0;
        int j = 0;
        
        while ( i < s.length() && j < t.length() ){
        	if ( t.charAt(j) != s.charAt(i) ){
        		j++;
        	}else{
        		i++;
        		j++;
        	}
        }
        
        return i == s.length() ? true : false;
    }
}


