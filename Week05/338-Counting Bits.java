public class Solution{
	public int[] countBits( int num ){
		int res[] = new int[num + 1];
		int offset = 1;
		
		for ( int index = 1; index < num + 1; ++index ){
			if ( offset * 2 == index ){
				offset *= 2;
			}
			
			res[index] = res[index - offset] + 1;
		}
		return res;
	}
}