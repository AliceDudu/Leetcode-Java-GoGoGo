

如果我们只是简单的用个for循环让x乘以自己n次的话，OJ因超时无法通过，
所以我们需要优化我们的算法，使其在更有效的算出结果来。

可以用递归来折半计算，
每次把n缩小一半，这样n最终会缩小到1，任何数的1次方都为x，
这时候我们再往回乘，如果此时n是偶数，直接把上次递归得到的值算个平方返回即可，
如果是奇数，则还需要乘上个x的值。
还有一点需要引起我们的注意的是n有可能为负数，对于n是负数的情况，我们可以先用其绝对值计算出一个结果再取其倒数即可

public class Solution {
	public double myPow(double x, int n) {
// 		n小于0时，－n变成正数，结果取倒数
		if (n < 0){
			return 1 / power(x, n * -1);
		}
		
		return power(x, n);
	}
	
    public double power(double x, int n) {
//     	corner ／ base case
		if (n == 0){
			return 1;
		}
// 		每次把n缩小一半，这样n最终会缩小到1，任何数的1次方都为x，
		if (n == 1){
			return x;
		}
			
		double pow = power(x, n / 2);
		
// 		这时候我们再往回乘，如果此时n是偶数，直接把上次递归得到的值算个平方返回即可，
		if (n % 2 == 0){
			return pow * pow;
// 		如果是奇数，则还需要乘上个x的值。
		}else{
			return x * pow * pow;
		}
	}
}