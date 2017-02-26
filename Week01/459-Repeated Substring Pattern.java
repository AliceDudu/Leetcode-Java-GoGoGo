


The length of the repeating substring must be a divisor of the length of the input string
Search for all possible divisor of str.length, starting for length/2
If i is a divisor of length, 
repeat the substring from 0 to i the number of times i is contained in s.length
If the repeated substring is equals to the input str return true

public boolean repeatedSubstringPattern(String str) {
	int l = str.length();
	
// 	i表示substr的长度，可以从l／2递减到1
	for( int i = l / 2; i >= 1; i--) {

// 		找可以整除的长度		
		if( l % i == 0 ) {

// 			m是这一段substr可以被重复的次数
			int m = l / i;
			
// 			(0, i)就是subS
			String subS = str.substring(0, i);
			StringBuilder sb = new StringBuilder();
			
// 			用subS重复m次，构造一个string，看是否等于原来的
			for( int j = 0; j < m; j++) {
				sb.append(subS);
			}
			
			if( sb.toString().equals(str) ) 
				return true;
		}
	}
	
	return false;
}

