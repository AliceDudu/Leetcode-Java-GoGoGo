Adding 1 to n - 1 elements is the same as subtracting 1 from one element, 嗯这个懂
那最后大家都要想等，同时还是每一次有个元素是在减少1，那只能大家都减少到min，因为min是不可能减少到倒数第二min的
那总共的次数，就是每一个元素距离min的距离，大家都加起来，就是总的次数

Adding 1 to n - 1 elements is the same as subtracting 1 from one element, 
w.r.t goal of making the elements in the array equal.
So, best way to do this is make all the elements in the array equal to the min element.
sum(array) - n * minimum

public class Solution {
    public int minMoves(int[] nums) {
        if (nums.length == 0) {
        	return 0;
        }
        
        int min = nums[0];
        
        for (int n : nums) {
        	min = Math.min(min, n);
        }
        
        int res = 0;
        
        for (int n : nums) {
        	res += n - min;
        }
        
        return res;
    }
}