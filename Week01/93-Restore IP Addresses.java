


用i，j，k分别代表三个点的位置
起始关系是：j = i + 1; j < i + 4， k = j + 1; k < j + 4
每一次，由这三个节点，构成的string，要判断是否每一个都符合valid

public class Solution {
    public List<String> restoreIpAddresses(String s) {
    
        List<String> res = new ArrayList<String>();
        int len = s.length();
        
//         用i，j，k分别代表三个点的位置
        for( int i = 1; i < 4 && i < len - 2; i++ ){
        
//         	起始关系是：j = i + 1; j < i + 4， k = j + 1; k < j + 4
            for( int j = i + 1; j < i + 4 && j < len - 1; j++){
            
                for( int k = j + 1; k < j + 4 && k < len; k++){
                
                    String s1 = s.substring(0, i);
                    String s2 = s.substring(i, j);
                    String s3 = s.substring(j, k);
                    String s4 = s.substring(k, len);
                    
//                     每一次，由这三个节点，构成的string，要判断是否每一个都符合valid
                    if( isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4) ){
                        res.add(s1 + "." + s2 + "." + s3 + "." + s4);
                    }
                }
            }
        }
        
        return res;
    }
    
    public boolean isValid( String s ){
//     	这四个条件是不合格的情况
        if( s.length() > 3 || s.length() == 0 || (s.charAt(0) == '0' && s.length() > 1) || Integer.parseInt(s) > 255 )
            return false;
            
        return true;
    }
}