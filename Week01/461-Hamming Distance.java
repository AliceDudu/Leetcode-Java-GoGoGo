

可以一开始直接将两个数字异或起来，然后我们遍历异或结果的每一位，统计为1的个数

public int hammingDistance(int x, int y) {
// 	可以一开始直接将两个数字异或起来
    int xor = x ^ y;
    int count = 0;
    
    for (int i = 0; i < 32; i++) {
//     	然后我们遍历异或结果的每一位，统计为1的个数
    	count += (xor >> i) & 1;
    }
    
    return count;
}