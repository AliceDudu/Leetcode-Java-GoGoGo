


格雷码的性质，有一条是说镜面排列的，
n位元的格雷码可以从n-1位元的格雷码
以上下镜射后加上新位元的方式快速的得到


public class Solution {
    
    public List<Integer> grayCode(int n) {
    
    	List<Integer> rs = new ArrayList<Integer>();
    
    	rs.add(0);
    
    	for( int i = 0; i < n; i++ ){
        	int size = rs.size();
        	
        	for( int k = size - 1; k >= 0; k-- )
            	rs.add( rs.get(k) | 1 << i );
    		}
    		
    	return rs;
	}
	

}