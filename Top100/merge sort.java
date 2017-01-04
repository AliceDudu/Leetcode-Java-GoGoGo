public class Solution{
	public int[] mergeSort(int[] arr){
		//corner case
		if ( arr == null )
			return null;
		
		//core
		int[] helperArr = new int[arr.length];
		doSort(arr, helperArr, 0, arr.length - 1);
		return arr;
	}
	
	private void doSort(int[] arr, int[] helperArr, int start, int end){
		if ( start >= end )
			return;
		
		int mid = start + (end - start) / 2;
		
		doSort(arr, helperArr, start, mid);			//deduction
		doSort(arr, helperArr, mid + 1, end);
		merge(arr, helperArr, start, mid, end);		//merge-sort
	}
	
	private void merge(int[] arr, int[] helperArr, int aStart, int aEnd, int bEnd){
		for ( int i = aStart; i <= bEnd; i++ )
			helperArr[i] = arr[i];
			
		int aCur = aStart;
		int bCur = aEnd + 1;
		
		for ( int i = aStart; i <= bEnd; i++ ){
			if ( aCur > aEnd ){
				arr[i] = helperArr[bCur++];
			}else if( bCur > bEnd ){
				arr[i] = helperArr[aCur++];
			}else if( hleperArr[aCur] <= helperArr[bCur] ){
				arr[i] = helperArr[aCur++];
			}else{
				arr[i] = helperArr[bCur++];
			}
		}
		
	}

}