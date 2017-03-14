

i从头向后走
走到奇数位置，就与前一位比较，换成大的数字，
走到偶数位置，但是不包括第一个0位的，就与前一位比较，换成小的数字，
在交界处，如果会发生交换，则一定会换的更小，所以前面的区间的顺序还是valid的

public class Solution {

    public void wiggleSort(int[] nums) {
    
        for(int i = 0; i < nums.length; i++)
        
            if( i % 2 == 1){
//             	将奇数位置换成大的数字，就与前一位交换
               if( nums[i - 1] > nums[i] ) {
               	swap(nums, i);
               }
//             走到偶数位置，但是不包括第一个0位的，若它比前一个大，就交换过去  
            }else if( i != 0 && nums[i - 1] < nums[i] ) {
            	swap(nums, i);
            }
            
    }
    
    public void swap(int[] nums, int i){
          int tmp = nums[i];
          nums[i] = nums[i - 1];
          nums[i - 1] = tmp;
    }
    
}