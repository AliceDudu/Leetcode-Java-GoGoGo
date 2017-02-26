

2-abc
3-def
9-wxyz

可以看成bfs，每一层取一个后，把path传递给下一层，再从这层取一个，。。。
当层数offset已经走到string尾巴后，就可以把path加到ret里了

public class Solution {
    private static final String[] KEYS = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
    
    public List<String> letterCombinations(String digits) {
    	List<String> ret = new LinkedList<String>();
    	    
    	if ( digits == null || digits.length() == 0 ){
    	    return ret;
    	}
    	    
    	combination("", digits, 0, ret);
    	
    	return ret;
    }
    
//     String prefix, int offset
    private void combination( String prefix, String digits, int offset, List<String> ret ) {
//     	当层数offset已经走到string尾巴后，就可以把path加到ret里了
    	if ( offset >= digits.length() ) {
    		ret.add(prefix);
    		return;
    	}
    	
    	String letters = KEYS[ (digits.charAt(offset) - '0') ];		//offset=0, d=2, letters="abc"
    	
    	for ( int i = 0; i < letters.length(); i++ ) {
    	
    		//     String prefix + letters.charAt(i)－－每一层取一个, int offset + 1－－把path传递给下一层
    		combination(prefix + letters.charAt(i), digits, offset + 1, ret);
    	}
    }
}
