public class Solution{
	public String decodeString( String s ){
		Deque<Integer> count = new ArrayDeque<>();	//store digit
		Deque<String> res = new ArrayDeque<>();
		
		int i = 0;
		res.push("");
		
		while ( i < s.length() ){
			char ch = s.charAt(i);
			
			if ( ch >= '0' && ch <= '9' ){	//read single or continuous digits
				int start = i;
				while ( s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9' ){
					i++;
				}
				count.push(Integer.parseInt(s.substring(start, i + 1)));
			}else if ( ch == '[' ){
				res.push("");
			}else if ( ch == ']' ){
				String str = res.pop();
				StringBuilder sb = new StringBuilder();
				
				int times = count.pop();
				
				for ( int j = 0; j < times; j++ ){	//k times of str
					sb.append(str);
				}
				
				res.push(res.pop() + sb.toString());	//?why pop
			}else{
				res.push(res.pop() + ch);	//?
			}
			
			i++;
			
		}
		return res.pop();
	}
}