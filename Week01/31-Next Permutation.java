


按字典顺序，找到应该排在给定input的下一个顺序的形式
eg 1，3，5，4，2
out 1，4，2，3，5
从后向前，找到离end最近的那个升序的位置i：那么后半段就是已经到头了，到头的下一个就是reverse这一段
再从后向前，找到第一个比i大的数字，先把二者swap：然后，i被换到后半段，那半段仍然是到头了的
最后把i＋1到end整体reverse一下

public class Solution{

	public void nextPermutation( int[] A ){

		if( A == null || A.length <= 1 ){
	    	return;
	    }
    
	    int i = A.length - 2;
    
    	//从后向前，找到离end最近的那个升序的位置就是i
		while( i >= 0 && A[i] >= A[i + 1]){
			i--; // Find 1st id i that breaks descending order
		}
    
		if( i >= 0 ){                           // If not entirely descending
			int j = A.length - 1;              // Start from the end
			
			//从后向前找到第一个比A[i]大的数
			while( A[j] <= A[i] ){
				j--;           // Find rightmost first larger id j
			}

			swap(A, i, j);                     // Switch i and j
		}

		reverse(A, i + 1, A.length - 1);       // Reverse the descending sequence
	}

	public void swap( int[] A, int i, int j ){
    	int tmp = A[i];
    	A[i] = A[j];
    	A[j] = tmp;
	}

	public void reverse( int[] A, int i, int j ){
    	while( i < j ){
    		swap(A, i++, j--);
    	}
	}

}