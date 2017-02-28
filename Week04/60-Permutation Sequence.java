
use a list to store the remaining numbers,
 for n numbers the permutations can be divided to (n-1)! groups, 
 for n-1 numbers can be divided to (n-2)! groups, and so on.
  
 Thus k/(n-1)! indicates the index of current number, 
 and k%(n-1)! denotes remaining index for the remaining n-1 numbers.
 
We keep doing this until n reaches 0, then we get n numbers permutations that is kth.



以n = 4, k = 17
最高位可取1,2,3,4中的一个，每个数字出现3！= 6次，所以k = 16的第一位数字的下标为16 / 6 = 2，即3被取出
第二位此时从1,2,4中取一个，k = 16是此时的k' = 16 % (3!) = 4，而剩下的每个数字出现2！= 2次，所以第二数字的下标为4 / 2 = 2，即4被取出
第三位此时从1,2中去一个，k' = 4是此时的k'' = 4 % (2!) = 0，而剩下的每个数字出现1！= 1次，所以第三个数字的下标为 0 / 1 = 0，即1被取出

public class Solution {
    public String getPermutation(int n, int k) {
    
        List<Integer> num = new LinkedList<Integer>();
        
//         由n构成nums
        for ( int i = 1; i <= n; i++ ) {
        	num.add(i);
        }
        
        int[] fact = new int[n];  // factorial
        fact[0] = 1;
        
        for ( int i = 1; i < n; i++ ) {
        	fact[i] = i * fact[i - 1];
        }
        
        k = k - 1;
        StringBuilder sb = new StringBuilder();
        
        for ( int i = n; i > 0; i-- ){
        
            int ind = k / fact[i - 1];
            k = k % fact[i - 1];
            
            sb.append( num.get(ind) );
            
            num.remove(ind);
        }
        
        return sb.toString();
    }
}


