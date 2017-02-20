



![](http://upload-images.jianshu.io/upload_images/1667471-ab7ef6475173ede1.JPG?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

- 先用 bs 找到第一个start点
- 如果start存在，则继续找end，如果不存在，返回－1 －1
- end的找法，将helper的target变成原来的＋1
- 这时返回的是 target＋1 应该存在的位置，尽管它未必在array中
- 这样得到的index再－1，就得到原target的对应的end位置

```java
public class Solution {
	public int[] searchRange( int[] A, int target ){
		int start = Solution.firstGreaterEqual(A, target);
		
		if ( start == A.length || A[start] != target ){
			return new int[]{-1, -1};
		}
		
		return new int[]{start, Solution.firstGreaterEqual(A, target + 1) - 1};
	}

	//find the first number that is greater than or equal to target.
	//could return A.length if target is greater than A[A.length-1].
	//actually this is the same as lower_bound in C++ STL.
	public int firstGreaterEqual( int[] A, int target ){
		int low = 0;
		int high = A.length;
		
		while ( low < high ){
			int mid = low + ((high - low) >> 1);
			//low <= mid < high
			if ( A[mid] < target ){
				low = mid + 1;
			}else{
				//should not be mid-1 when A[mid]==target.
				//could be mid even if A[mid]>target because mid<high.
				high = mid;
			}
		}
		
		return low;
	}
}
```
