先把给定字符串排入队中，然后取出检测其是否合法，若合法直接返回，
不合法的话，对其进行遍历，
对于遇到的左右括号的字符，去掉括号字符生成一个新的字符串，
如果这个字符串之前没有遇到过，将其排入队中，
用哈希表记录一个字符串是否出现过。
对队列中的每个元素都进行相同的操作，直到队列为空还没找到合法的字符串的话，那就返回空集

public class Solution {
    public List<String> removeInvalidParentheses( String s ){
      List<String> res = new ArrayList<>();
      
      // sanity check
      if (s == null){
      	return res;
      }
       
      
      Set<String> visited = new HashSet<>();
      Queue<String> queue = new LinkedList<>();
      
      // initialize
      queue.add(s);
      visited.add(s);
      
      boolean found = false;
      
      while ( !queue.isEmpty() ){
        s = queue.poll();
        
        if ( isValid(s) ){
          // found an answer, add to the result
          res.add(s);
          found = true;
        }
      
        if ( found ){
        	continue;
        } 
      
        // generate all possible states
        for ( int i = 0; i < s.length(); i++ ){
          // we only try to remove left or right paren
          if ( s.charAt(i) != '(' && s.charAt(i) != ')' ){
          	continue;
          } 
        
          String t = s.substring(0, i) + s.substring(i + 1);
        
          if ( !visited.contains(t) ){
            // for each state, if it's not visited, add it to the queue
            queue.add(t);
            visited.add(t);
          }
        }
      }
      
      return res;
    }
    
    // helper function checks if string s contains valid parantheses
    boolean isValid( String s ){
      int count = 0;
    
      for ( int i = 0; i < s.length(); i++ ){
        char c = s.charAt(i);
        if ( c == '(' ){
        	count++;
        } 
        if ( c == ')' && count-- == 0 ){
        	return false;
        } 
      }
    
      return count == 0;
    }
}