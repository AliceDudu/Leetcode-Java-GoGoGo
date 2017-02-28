we have to know the bitwise XOR in java

0 ^ N = N
N ^ N = 0
So..... if N is the single number

N1 ^ N1 ^ N2 ^ N2 ^..............^ Nx ^ Nx ^ N

= (N1^N1) ^ (N2^N2) ^..............^ (Nx^Nx) ^ N

= 0 ^ 0 ^ ..........^ 0 ^ N

= N

public class Solution {
    public int singleNumber(int[] nums) {
        
        int ans =0;
    
        int len = nums.length;
    
//     	因为有上面两个rule，所以ans从头到尾累计做异或，最后剩下的就是res
        for(int i = 0; i != len; i++)
            ans ^= nums[i];
    
        return ans;
    
    }
}