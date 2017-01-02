/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        if ( n == 1 )
			return n;
		
		int start = 1;
		int end = n;
		
		while ( start < end ){
			int mid = start + (end - start)/2;
			
			if ( isBadVersion(mid) ){
				end = mid;
			}else{
				start = mid + 1;
			}
		}
		
		return isBadVersion(start) ? start : end;
    }
}

// －－－1st version
// public class Solution {
// 	public int firstBadVersion(int n){
// 		if ( n <= 0 )
// 			return Integer.MIN_VALUE;					// ??? when to return MIN???
// 	
// // 		int i = n -1;	
// // 		while ( i>=0 && i<n ){
// // 			if ( isBadVersion( n[i] ) )
// // 				i = i / 2;	
// // 		}
// 
// 		int start = 1;
// 		int end = n;									//n versions [1, 2, ..., n] ,not 0 ~ n-1
// 		
// 		while ( start < end - 1 ){						// why -1 not end
// 			int mid = start + ( end - start )/2;		// !!! start+distance not mid = (start+end)) / 2 overflow
// 			if ( VersionControl.isBadVersion(mid) ){
// 				end = mid;
// 			}else{
// 				start = mid;
// 			}
// 		}
// 		
// 		return VersionControl.isBadVersion(start) ? start : end;		// !!! return int
// 														// !!! the latest version of your product fails
// 	}
// }
// 
// // ??? Line 14: error: non-static method isBadVersion(int) cannot be referenced from a static context
// //---public class Solution extends VersionControl