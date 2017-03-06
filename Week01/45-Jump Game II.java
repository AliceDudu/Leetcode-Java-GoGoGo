

第一步就落在起点，r是可以到达的最远距离
对于每个l <= r， 计算l + nums[l]，其实就是在走这里面的每一步，看下一步最远可以走到哪里
当存在比r远的max时，r＝max，就是更新最远的距离了，
step也要＋＋，因为走了这一步，才到达了max
l可以直接变成r，用同样的方式计算新的无重叠的区间内每一点可以走到的最远的距离
当这个最远的距离已经等于或者超过末尾时，就可以返回当前的步数了


public class Solution {
public int jump(int[] nums) {
    // If nums.length < 2, means that we do not
    // need to move at all.
    if (nums == null || nums.length < 2) {
        return 0;
    }

    // First set up current region, which is
    // from 0 to nums[0].
    
//     第一步就落在起点，r是可以到达的最远距离
    int l = 0;
    int r = nums[0];
    // Since the length of nums is greater than
    // 1, we need at least 1 step.
    int step = 1;

    // We go through all elements in the region.
    while (l <= r) {

        // If the right of current region is greater
        // than nums.length - 1, that means we are done.
//         当这个最远的距离已经等于或者超过末尾时，就可以返回当前的步数了
        if (r >= nums.length - 1) {
            return step;
        }

        // We should know how far can we reach in current
        // region.
        int max = Integer.MIN_VALUE;
        
//         对于每个l <= r， 计算l + nums[l]，其实就是在走这里面的每一步，看哪一个最远
        for (; l <= r; l++) {
            max = Math.max(max, l + nums[l]);
        }

        // If we can reach far more in this round, we update
        // the boundary of current region, and also add a step.
        
//         因为有这个note：You can assume that you can always reach the last index.
//         否则max<=r的话，就死循环了
		
// 		当存在比r远的max时，r＝max，就是更新最远的距离了，
// 		step也要＋＋，因为走了这一步，才到达了max
// 		为什么l可以直接变成r呢，为什么变成r后，又可以走l to max的每一步呢，这个max并不是l走过去的呀？
// 		因为：就算l要严格地等于真正走的那一步的话，它仍然要计算l + nums[l]，
// 		而它因为坐落在上一个l to r内部，所以已经算过了
// 		那接下来只要计算新的无重叠的区间就可以了
// 		每个区间可以累加一个step，但具体这个step落在哪个位置，并不需要知道
// 		那又有个问题了，如果倒数第二步只有一个点可以走到末尾，
// 		而它虽然在区间内，但是再上一步却没有人能走到这一点呢
// 		其实是不存在这个问题的，因为l + nums[l]只是可以走的最大的步数，其实它可以走这期间的任意一步
        if (max > r) {
            l = r;
            r = max;
            step++;
        }
    }

    // We can not finish the job.
    return -1;
}
}