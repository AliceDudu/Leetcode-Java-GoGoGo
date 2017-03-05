


第一个for之后，stack里面是从num的起点开始，一个严格升序的子序列
i从num的最后一位向前扫，看stack的top然后比较，相当于是在从circle的尾巴顺时针向next方向扫
把stack的顶端的所有小于num i的都pop走，剩下的顶端的，就是最next的比它大的点
如果 最next的比它大的点 是空的，就赋值－1，不为空，就取出来top
然后把这个点push到stack中去
再继续倒着走num，走到了2
2和刚才push进去的倒数第一个数字比较，相当于从2开始，沿着顺时针方向，找它的next大的
这个push进去的倒数第一个点，相当于是把2和之前的一串连接了起来

public class Solution {
    public int[] nextGreaterElements(int[] nums) {
        if(nums == null || nums.length == 0) {
        	return new int[0];
        }
        
        int[] ret = new int[nums.length];
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        
//         这个for之后，stack里面是从num的起点开始，一个严格升序的子序列
        for(int i = nums.length - 2; i >= 0; i--) {
            while( !stack.isEmpty() && nums[i] >= stack.peek() ) {
            	stack.pop();
            }
            stack.push(nums[i]);
        }
        
//         i从num的最后一位向前扫，看stack的top然后比较，相当于是在从circle的尾巴顺时针向next方向扫
        for(int i = nums.length - 1; i>= 0; i--) {
//         	把stack的顶端的所有小于num i的都pop走，剩下的顶端的，就是最next的比它大的点
            while( !stack.isEmpty() && nums[i] >= stack.peek() ) {
            	stack.pop();
            }
            
//             如果 最next的比它大的点 是空的，就赋值－1，不为空，就取出来top
            if(stack.isEmpty()) {
            	ret[i] = -1;
            }else {
            	ret[i] = stack.peek();
            }
            
//             把tail的1放入stack，那么num倒着走到2时，第一个比较的时tail这个1，相当于2在按着顺时针的方向扫circle
// 			比tail 1先入栈的head 1，都没有比tail 1大，那么当看2时，2是比tail 1大的，自然就比head 1大，所以head 1可以直接被poop掉
            stack.push(nums[i]);
        }
        
        return ret;
    }
}