
因为个数要大于n／3，所以这样的数字种数只可能<=2，否则总个数超过n
x用来存这两个可能的众数

第一遍for，count用来计数，如果遇到等于众数内的，就＋＋，遇到不同的，就－－，相当于抵消掉一个普通数和众数

第二遍for，count清零，数一下x中的两个数，在nums中总共出现了几次

第三遍for，看count里的两个计数，选择真正大于n／3的，并将其放入res中，注意查重


public class Solution{
	public List<Integer> majorityElement( int[] nums ){
	
	  	ArrayList<Integer> res = new ArrayList<>();
	  	
        if( nums.length == 0 ){
        	return res;
        }
        
        int[] count = new int[2];        
        int[] x = new int[2];       
   
        x[0] = 0; 
        x[1] = 1; 
               
        for( int i = 0; i < nums.length; i++ ){
        	if( x[0] == nums[i] ){
        		count[0]++;
        	}else if( x[1] == nums[i] ){
        		count[1]++;
        	}else if( count[0] == 0 ){	//frist in
        		x[0] = nums[i];
        		count[0] = 1;
        	}else if( count[1] == 0 ){
        		x[1] = nums[i];
        		count[1] = 1;
        	}else{
        		count[0]--;
        		count[1]--;        		
        	}
        }
        
        Arrays.fill(count, 0);
        
        for( int n : nums ){// Count again for x1, x2
    		if( n == x[0] ){
    			count[0]++;
    		}else if( n == x[1] ){
    			count[1]++;
    		}
    	}
    	
    	for( int j = 0; j < 2; j++ ){
    		if( count[j] > nums.length / 3 && !res.contains(x[j]) ){
    			res.add(x[j]);
    		}
    	}        
    	
    	return res;
	}
}