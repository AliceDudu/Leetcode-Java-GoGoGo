

每一条path可以含有不同的层数，层间隔相当于逗号
这个层数不是预先设定好的，而是走出来的，直到所有层走完了s，就可以把path加到res里

每一层的left和right边界，
right是从left走到尾，
left是从s的左扫到右，
每到一个新区间，就判断一下这一段是否符合回文，符合就add到path中，
接着去看剩余的部分，即left从i＋1开始，是否有符合回文的组成

public class Solution {
        List<List<String>> resultLst;
	    ArrayList<String> currLst;
	    
	    public List<List<String>> partition(String s) {
	    
	        resultLst = new ArrayList<List<String>>();
	        currLst = new ArrayList<String>();
	        
// 	        0是left点，当前层的左边界，subset
// 			left是从s的左扫到右，
	        backTrack(s, 0);
	        
	        return resultLst;
	    }
	    
	    public void backTrack(String s, int l){
	    
// 	    	和subset区别：subset是遇到一个直接加进去，这里允许重复，并且还是得全跑完
	        if( currLst.size() > 0 && l >= s.length() ){	//the initial str could be palindrome
// 	        		当一条path已经把s所有都加入后，整条path加入到res
	                List<String> r = (ArrayList<String>) currLst.clone();	
	                resultLst.add(r);
	        }
	        
// 	        i是当前层的右边界
// 			right是从left走到尾，
	        for( int i = l; i < s.length(); i++ ){
// 	        	每到一个新区间，就判断一下这一段是否符合回文，符合就add到path中，
	            if( isPalindrome(s, l, i) ){
	                if( l == i)
	                    currLst.add( Character.toString(s.charAt(i)) );
	                else
	                    currLst.add(s.substring(l, i + 1));
	                
// 	                接着去看剩余的部分，即left从i＋1开始，是否有符合回文的组成
	                backTrack(s, i + 1);
	                
	                currLst.remove(currLst.size() - 1);
	            }
	        }
	    }
	    
// 	    判断l到r这一段是否回文
	    public boolean isPalindrome(String str, int l, int r){
	        if( l == r ){
	        	return true;
	        }
	        
	        while( l < r){
	            if( str.charAt(l) != str.charAt(r) ) {
	            	return false;
	            }
	            l++;
	            r--;
	        }
	        
	        return true;
	    }
}