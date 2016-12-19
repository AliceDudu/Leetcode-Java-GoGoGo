package leetcode;

public class Solution {

// 	public static void main(String[] args) {
// 		// TODO Auto-generated method stub
// //		int[] arr = {4,3,2,3,2,2,0};
// 		int[] arr = {6,-2,3,2,3};
// 		System.out.println(divideSubarray(arr));
// 
// 	}
	
	public Boolean divideSubarray(int[] arr){
		if ( arr == null )
			return false;
		if ( arr.length == 1 )
			return true;
		
		
		int left = 0;
		int right = arr.length - 1;
		int sum_left = arr[left];
		int sum_right = arr[right];
		
		while ( left < right ){			
			
			if ( sum_left < sum_right ){
				left ++;
				sum_left += arr[left];
			}else if ( sum_left > sum_right ){
				right --;
				sum_right += arr[right];
			}else{
				left ++;
				right --;
				sum_left += arr[left];
				sum_right += arr[right];
			}
		}
		
		if ( sum_left == sum_right ){
			return true;
		}else{
			return false;
		}
	}
	
}
