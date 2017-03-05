
Suppose you have two endpoints A and B, when you want to find a point C 
that has minimum sum of distance between AC and BC, 
the point C will always between A and B. Draw a graph and you will understand it. 
Lets keep moving forward. After we locating the point C between A and B, we can define that
dis(AC) = c - a; dis(CB) = b - c;
sum = dis(AC) + dis(CB) = b - a.
b - a will be a constant value, given specific b and a. 
Thus there will be no difference between points among A and B.
In this problem, we set two boundaries, saying i and j, and we move the i and j to do the computation.

最后的状态是，所有点都相等，即任意两点的距离都要变为0
用这两点做差，就是要移动的步数，因为不管c在哪里，这个差值都是固定的，
所以可以忽略c的真实位置，而只看这个差值
array从小到大排好序后，双指针做差，累加这个差值，就得到整体的步数

public class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length - 1;
        int count = 0;
        
        while(i < j){
            count += nums[j] - nums[i];
            i++;
            j--;
        }
        
        return count;
    }
}