

可以建立一个32位的数字，来统计每一位上1出现的个数，
对于每个i，nums j的第 i 位上是1的话，sum＋＋
我们知道如果某一位上为1的话，那么如果该整数出现了三次，对3去余为0，
我们把每个数的对应位都加起来对3取余，最终剩下来的那个数就是单独的数字

public int singleNumber(int[] nums) {
    int ans = 0;

//         	建立一个32位的数字，来统计每一位上1出现的个数    
    for(int i = 0; i < 32; i++) {
        int sum = 0;
        
        for(int j = 0; j < nums.length; j++) {
// 			对于每个i，nums j的第 i 位上是1的话，sum＋＋
            if(((nums[j] >> i) & 1) == 1) {
                sum++;
//                 如果某一位上为1的话，那么如果该整数出现了三次，对3去余为0
                sum %= 3;
            }
            
//             System.out.println( "i:" + i + "  num j:" + nums[j] + "  sum:" + sum);
        }
        
//         把每个数的对应位都加起来对3取余，最终剩下来的那个数就是单独的数字
        if(sum != 0) {
            ans |= sum << i;
        }
    }
    
    return ans;
}

i:0  num j:1  sum:1
i:0  num j:1  sum:2
i:0  num j:1  sum:0	变成0
i:0  num j:2  sum:0
i:0  num j:2  sum:0
i:0  num j:2  sum:0
i:0  num j:3  sum:1

i:1  num j:1  sum:0
i:1  num j:1  sum:0
i:1  num j:1  sum:0
i:1  num j:2  sum:1
i:1  num j:2  sum:2
i:1  num j:2  sum:0 变成0
i:1  num j:3  sum:1

i:2  num j:1  sum:0
i:2  num j:1  sum:0
i:2  num j:1  sum:0
i:2  num j:2  sum:0
i:2  num j:2  sum:0
i:2  num j:2  sum:0

