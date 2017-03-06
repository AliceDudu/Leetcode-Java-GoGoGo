就是找最小值在哪个区间内
多了重复的就多了几个判断场景


public class Solution {
    public int findMin(int[] num) {
        if(num == null || num.length == 0) {
            return -1; // should throw an exception, not sure if leetcode supports it
        }
        
        int l = 0;
        int r = num.length-1;
        
        while(l < r) {
//         	l最开始在起点，这个如果是从后面截过来的话，那它应该比最后一个大于或者等于
//         	所以如果此时是小于的话，则它就是全局最小
            if(num[l] < num[r]) {
                return num[l];
            }
            
            int m = l + (r-l)/2;
            
//             说明l和m在两个不同的区间，那最小值就在m的左边，所以r移动到m
            if(num[l] > num[m]) {
                r = m;
//             说明l和m在同一个区间，并且还是大头那一块，所以l移动到m
            } else if(num[l] < num[m]) {
                l = m+1;
//                 l和m的值相等时，最小值可能位于m的左边或者右边
            } else { // num[l] == num[m]
//             	此时最小值在m的左边，同时向内缩l和r
                if(num[l] == num[r]) {
                    l++;
                    r--;
                此时在m的右边，更新l即可
                } else { // only the num[l] == num[m] >  num[r] case left
                    l = m+1;
                }
            }
        }
        
        return num[l];
    }
}