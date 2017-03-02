



遇到小的先push进去，n < stack.peek().min 越小越容易在后面找到和它一起构成132的，所以push进来

如果 n > stack.peek().min，先pop出来，last = stack.pop()，就接着看是否有 n < last.max ，是的话，就是true，
否的话，last.max = n，就把max替换掉，后面的更容易找到132

此时的n在从stack内部向前找，因为刚才的last已经是pop出来的，没发现符合，就得去stack里面找一下，看是否有132，
n >= stack.peek().max ，说明min max n三者构成的是123，是不需要的，就pop出去
上面的while剩余下来的就是n < stack.peek().max 再加上stack.peek().min < n，就可以true

如果前面还没有，那就stack.push(last)，继续从后面找


public class Solution {
    class Pair{
        int min;
        int max;
        
        public Pair(int min, int max){
            this.min = min;
            this.max = max;
        }
    }
    
    public boolean find132pattern(int[] nums) {
        Stack<Pair> stack = new Stack();
        
        for( int n: nums ){
        
//         	n < stack.peek().min 越小越容易在后面找到和它一起构成132的，所以push进来
            if( stack.isEmpty() || n < stack.peek().min ) {
            
            	stack.push( new Pair(n, n) );
            	
            }else if( n > stack.peek().min ){ 
            
                Pair last = stack.pop();
                
//                 n > stack.peek().min 并且 n < last.max ，所以三者构成了132
                if( n < last.max ) {
                	return true;		//1 4 2
                	
                }else {
//                 	n > stack.peek().min 并且 n > last.max，就把max替换掉，后面的更容易找到132
                    last.max = n;
                    
                    //此时已经构成了13或者12，那么比当前的max小的，并且在这之前的是没有用的，因为需要的是在后面比这个小的
//                     此时的n向前找，看是否有132，n >= stack.peek().max ，说明min max n三者构成的是123，是不需要的
                    while( !stack.isEmpty() && n >= stack.peek().max ) {
                    	stack.pop();
                    }
                    
                    //上面的while剩余下来的就是n < stack.peek().max 再加上stack.peek().min < n，就可以true
                    // At this time, n < stack.peek().max (if stack not empty)
                    if( !stack.isEmpty() && stack.peek().min < n ) {
                    	return true;
                    }
                    
                    
                    stack.push(last);		//这里push的是last，不是n
                }
                
            }
        }
        return false;
    }
}