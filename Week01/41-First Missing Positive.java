

要找的是第一个，而且是正数，如果没有丢的话，那么arr里应该是1到length这几个数，从小到大排列
那就把1到len出现的数字，放到它应该在的位置上
A[i] - 1是当前i上面的数字应该在的角标
当i上的数超过了范围，或者已经在正确的位置上，就走到下一个
上面的while之后，1到len都各自在相应的位置上了
接下来就是从左向右扫，扫到第一个它的值与位置不对应的时候
就是第一个 丢掉的 正数，返回它的值

public class Solution {
    public int firstMissingPositive(int[] A) {
        int i = 0;
        
//         要找的是第一个，而且是正数，如果没有丢的话，那么arr里应该是1到length这几个数，从小到大排列
//         所以角标i上的数去和i＋1比较
        while( i < A.length ){
//         	当i上的数超过了范围，或者已经在正确的位置上，就走到下一个
            if( A[i] == i + 1 || A[i] <= 0 || A[i] > A.length ) {
            	i++;
//             	那就把1到len出现的数字，放到它应该在的位置上
//             A[i] - 1是当前i上面的数字应该在的角标
// 				调换这个位置，直到无法再调换为止
            }else if( A[A[i] - 1] != A[i] ) {
            	swap(A, i, A[i] - 1);
            }else {
            	i++;
            }
        }
        
        i = 0;
        
//         上面的while之后，1到len都各自在相应的位置上了
//         接下来就是从左向右扫，扫到第一个它的值与位置不对应的时候
//         就是第一个 丢掉的 正数，返回它的值
        while( i < A.length && A[i] == i + 1 ) {
        	i++;
        }
        
        return i + 1;
    }
    
    private void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}