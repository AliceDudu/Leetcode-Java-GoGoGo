

因为a b相差最小的时候就是a＝b的时候
所以a从平方根开始
a如果不能整除area，就一步一步减小
当area可以被a整除时：因为a＊b＝area，就可以求出来b
此时b大于等于a的

public class Solution {
    public int[] constructRectangle(int area) {
        int[] result = new int[2];
        
        if(area == 0){
            return result;
        }
        
//         a从平方根开始，因为a b相差最小的时候就是a＝b的时候
        int a = (int)Math.sqrt(area);
        
//         a如果不能整除area，就一步一步减小
        while( area % a != 0 ){
            a--;
        }
        
//         area可以被a整除时：因为a＊b＝area
        int b = area / a;
        
        result[0] = b;	//L＝b 是大的
        result[1] = a;	//W＝a 是小的
        
        return result;
    }
}