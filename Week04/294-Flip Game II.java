public class Solution{
	public boolean canWin(String s){
		//corner
		if ( s == null || s.length() == 0 ){
			return false;
		}
		
		return helper(s.toCharArray());
	}
	
	public boolean helper(char[] arr){
		for ( int i = 0; i < arr.length; i++ ){
			if ( arr[i] == '+' && arr[i + 1] == '+' ){
				arr[i] = '-';
				arr[i + 1] = '-';
				
				boolean otherWin = helper(arr);			//2人轮流
				
				arr[i] = '+';				//返回到upper level后恢复＋号
				arr[i + 1] = '+';
				
				if ( !otherWin ){			//另一人false时走这一步，另一人true时，要继续遍历＋＋对
					return true;			//直到找到某一种走法可以让另一人false，最终整体返回的值为true，此时第一人赢
				}
			}
		}
		
		return false;			//如果遍历到头没有＋＋对了，而且几种走法都一直找不到赢的走法了，第一人就最终false
	}
}