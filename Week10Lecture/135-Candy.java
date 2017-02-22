

public class Solution {
    public int candy(int[] ratings) {
    
        if (ratings == null || ratings.length == 0) {
	        return 0;
	    }
	    
        int total = 1;
        int prev = 1;
        int countDown = 0;
        
        for (int i = 1; i < ratings.length; i++) {		//
            if ( ratings[i] >= ratings[i - 1] ) {
                if ( countDown > 0 ) {
                    total += countDown * (countDown + 1) / 2; // arithmetic progression
                    
                    if (countDown >= prev) {
                    	total += countDown - prev + 1;
                    }
                    
                    countDown = 0;
                    prev = 1;
                }
                
                prev = ratings[i] == ratings[i - 1] ? 1 : prev + 1;
                total += prev;
            } else {
            	countDown++;
            }
        }
        
        if ( countDown > 0 ) { // if we were descending at the end
            total += countDown * (countDown + 1) / 2;		 //这是把后面四个降序的给加起来
            
            if ( countDown >= prev ) {
            	total += countDown - prev + 1;	 //这个是为什么？
            }
        }
        
        return total;
    }
}