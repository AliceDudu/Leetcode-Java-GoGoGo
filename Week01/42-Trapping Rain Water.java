

要算的是盛水量
从两边向内部扫
两边的低的边是没有办法hold水的，所以掠过，找到第一条高的边
当left小于right的时候，向内移动left边
每条高的边向内部走，找到比它小于等于的，就加入这个差值
遇到大的就跳出去，被减数就要更新了
当left大于right的时候，向内移动right边，用同样的方法去累加差值

public class Solution {
   public int trap(int[] A) {
    if (A.length < 3) {
    	return 0;
    
    int ans = 0;
    int l = 0, r = A.length - 1;
    
    // find the left and right edge which can hold water
//     两边的低的边是没有办法hold水的，所以掠过，找到第一条高的边
    while (l < r && A[l] <= A[l + 1]) {
    	l++;
    }
    while (l < r && A[r] <= A[r - 1]) {
    	r--;
    }
    
    while (l < r) {
        int left = A[l];
        int right = A[r];
        if (left <= right) {
            // add volum until an edge larger than the left edge
//             每条高的边向内部走，找到比它小于等于的，就加入这个差值
// 				遇到大的就跳出去，被减数就要更新了
            while (l < r && left >= A[++l]) {
                ans += left - A[l];
            }
//         同理，当left大于right的时候，向内移动right边，用同样的方法去累加差值
        } else {
            // add volum until an edge larger than the right volum
            while (l < r && A[--r] <= right) {
                ans += right - A[r];
            }
        }
    }
    
    return ans;
}
}