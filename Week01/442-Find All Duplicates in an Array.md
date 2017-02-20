

从头扫到尾
把遇到的数值，应该在的位置角标 上面的数字变成负数
如果下一次扫到了某个位置上是负数，说明这个位置之前已经遇到过一次了
所以直接把这个位置应该有的数字加到res中

```java
public class Solution {
    // when find a number i, flip the number at position i-1 to negative. 
    // if the number at position i-1 is already negative, i is the number that occurs twice.
    
    public List<Integer> findDuplicates( int[] nums ){
        List<Integer> res = new ArrayList<>();
        
        for ( int i = 0; i < nums.length; ++i ){
            int index = Math.abs(nums[i])-1;
            
            if ( nums[index] < 0 ){
                res.add(Math.abs(index+1));
            }
            
            nums[index] = -nums[index];
        }
        return res;
    }
}
```
