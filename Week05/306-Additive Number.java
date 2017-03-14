

需要3个数，num1，num2，num3
num1是一位数的时候，
num2是一位数的时候，
num3从一位开始每次增加一位，每次判断一下是否等于二者之和，直到大于等于
若大于，则返回false，回到上一层，这之后，num2会继续一位一位增加，重复前面过程
若等于，若已经到end，则返回true
若等于，但还未到end，则此时的num2作为num1，num3作为num2传递给下一层


public class Solution {
	
// 	public static void main(String[] args) {
// 	// TODO Auto-generated method stub
// 		String num = "199100199";
// 
// 		boolean k = isAdditiveNumber(num);
// 		
//       System.out.println( "result:" + k);
// 	}

	public static boolean isAdditiveNumber(String num) {
        char[] cArr = num.toCharArray();
        
        //initializing first number
		long num1 = 0;
// 		for循环实现num1的一位数一位数增加
		for (int i = 0; i < cArr.length; i++) {
		    //condition to check if sequence starts with 0
		    if(i > 0 && cArr[0] == '0'){
		        return false;
		    }
		    
			num1 = num1 * 10 + (long) (cArr[i] - '0');
// 			System.out.println( "num1:" + num1);
			
			//initializing second number
			long num2 = 0;
// 			for循环实现num2的一位数一位数增加
			for (int j = i + 1; j < cArr.length; j++) {
			    // condition to check if sequence starts with 0
				if (j > i + 1 && cArr[i + 1] == '0') {
					break;
				}

				num2 = num2 * 10 + (long) (cArr[j] - '0');
// 				System.out.println(  "   num2:" + num2 );

// 				用递归去判断num3与二者和的关系
				if (isAdditiveNumber(num1, num2, cArr, j + 1)) {
					return true;
				}
			}
		}

		return false;
	}

    // finds the third number recursivelt. 
	private static boolean isAdditiveNumber(long num1, long num2, char[] cArr, int idx) {
		long num3 = 0;
		
		int i = idx;
// 		current level：构造num3
// 		给了num1和num2后，看紧跟在后面的num3是否可以等于二者之和，
// 		这个num3是从一位数变成二位数再继续增加位数，直到num3 >= num1 + num2
// 		for循环实现num3的一位数一位数增加
		for (; i < cArr.length; i++) {
		    // condition to check if sequence starts with 0
			if(i > idx && cArr[idx] == '0'){
				return false;
			}
			
			num3 = num3 * 10 + (long) (cArr[i] - '0');
// 			System.out.println( "         num3:" + num3);
// 			System.out.println( "             num1:" + num1 + "   num2:" + num2 + "   num3:" + num3);
			if (num3 >= num1 + num2) {
				break;
			}
		}

// 		如果上面的break是因为大于二者之和，那就false返回到上一层
        // if third number cannot be formed.
		if (num3 != num1 + num2) {
			return false;
		}
		
// 		base case：到达end
// 		如果已经到达end，并且等于前面的和，就返回true
		// if reached end of the given string
		if(i == cArr.length - 1){
			return true;
		}
		
//		System.out.println( "num1:" + num1 + "   num2:" + num2 + "   num3:" + num3);

// 		next level：把num2, num3作为num1，num2传下去
// 		如果等于二者之和，但是还没到end，就继续向下走
// 		这时候，是把num2, num3作为num1，num2传下去了
		return isAdditiveNumber(num2, num3, cArr, i + 1);
	}

}



num1:1
   num2:9
         num3:9
             num1:1   num2:9   num3:9
         num3:91
             num1:1   num2:9   num3:91
   num2:99
         num3:1
             num1:1   num2:99   num3:1
         num3:10
             num1:1   num2:99   num3:10
         num3:100
             num1:1   num2:99   num3:100
         num3:1
             num1:99   num2:100   num3:1
         num3:19
             num1:99   num2:100   num3:19
         num3:199
             num1:99   num2:100   num3:199
result:true



