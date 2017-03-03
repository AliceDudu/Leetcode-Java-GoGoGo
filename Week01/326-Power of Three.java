public class Solution {
    public static boolean isPowerOfThree(int n) {
		if (n <= 0)
			return false;
	
		double r = Math.log10(n) / Math.log10(3);
	
// 		两边取对数，再做除法，如果是，那么这个除法的结果，就是3上面的指数，是个整数
		if (r % 1 == 0)
			return true;
		else
			return false;
	}
}