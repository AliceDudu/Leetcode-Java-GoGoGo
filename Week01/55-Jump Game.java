
max：表示最远能到达的位置
遍历数组中每一个数字，如果当前坐标大于max
或者max已经抵达最后一个位置，则跳出循环

否则就更新max的值为其和i + A[i]中的较大值，
其中i + A[i]表示当前位置能到达的最大位置

第一遍ac，第二遍又TLE

public class Solution {
    public boolean canJump( int[] A ){
    
    	int max = 0;
    
    	for( int i = 0; i < A.length; i++ ){
        	if( i > max ){
        		return false;
        	}
        
        	max = Math.max(A[i] + i, max);
    	}
    
    	return true;
	}
}



从倒数第二个位置，如果当前在此位置，那么这上面的数字，至少需要是1才能走到end
所以，如果它是0，临界值就是1，
	那就看，它的前一步是否能够比2步大。。。
	如果一直到头都没有找到能覆盖这些步的，说明走不到end

// in this case we evaluate 
// if there exist an element somewhere at the start of the array 
// which has a jump value large enough to jump over this 0 value element.

public class Solution {
    public boolean canJump( int[] nums ){
    
       if( nums.length < 2 ){
       		return true;
       }
       
       for( int curr = nums.length - 2; curr >= 0; curr-- ){
           if( nums[curr] == 0 ){
               int neededJumps = 1;
               
               while( neededJumps > nums[curr] ){
                   neededJumps++;
                   curr--;
                   
                   if( curr < 0 ){
                   		return false;
                   }
               }
           }
       }
       return true;
    }
}